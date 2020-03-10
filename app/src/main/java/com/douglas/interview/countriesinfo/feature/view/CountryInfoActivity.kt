package com.douglas.interview.countriesinfo.feature.view

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.makeText
import com.douglas.interview.countriesinfo.App
import com.douglas.interview.countriesinfo.R
import com.douglas.interview.countriesinfo.feature.CountryHelper.DEFAULT_COUNTRY_NAME
import com.douglas.interview.countriesinfo.feature.CountryInfo
import com.douglas.interview.countriesinfo.feature.CountryInfoContract
import com.douglas.interview.countriesinfo.feature.CountryInfoPresenter
import com.douglas.interview.countriesinfo.foundation.BaseActivity
import com.douglas.interview.countriesinfo.utils.hideKeyboardFrom
import com.douglas.interview.countriesinfo.utils.initArrayAdapter
import com.douglas.interview.countriesinfo.utils.initGridLayout
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CountryInfoActivity : BaseActivity(),
	CountryInfoContract.View {

	@Inject
	lateinit var presenter: CountryInfoPresenter
	private val countryAdapter = GroupAdapter<GroupieViewHolder>()

	override fun onInject() = App.appComponent.inject(this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		presenter.loadData(DEFAULT_COUNTRY_NAME)
		presenter.takeView(this)
		initComponents()
	}

	private fun initComponents() {
		val dropDowAdapter = initArrayAdapter(this, resources.getStringArray(R.array.countries_array))
		dropDownCountry.setAdapter(dropDowAdapter)
		countryList?.initGridLayout(this, countryAdapter)
		dropDownCountry?.setOnItemClickListener { _, _, _, _ -> onClickCountrySearch() }
	}

	private fun onClickCountrySearch() {
		countryAdapter.clear()
		hideKeyboardFrom(this, dropDownCountry)
		presenter.loadData(dropDownCountry.text.toString())
	}

	override fun showCountryInfo(countryInfo: CountryInfo) {
		val headerItem = Section().apply { setHeader(CountryInfoHeader(countryInfo)) }
		countryAdapter.add(headerItem)
		countryInfo.cities.forEach {
			val cityItem = Section(CountryInfoItem(it))
			countryAdapter.add(cityItem)
		}
	}

	override fun showDataError() {
		makeText(this, getString(R.string.generic_error_message), Toast.LENGTH_SHORT).show()
	}
}
