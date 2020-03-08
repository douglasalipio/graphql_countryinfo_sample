package com.douglas.interview.countriesinfo.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.douglas.interview.countriesinfo.App
import com.douglas.interview.countriesinfo.R
import com.douglas.interview.countriesinfo.foundation.BaseActivity
import javax.inject.Inject

class CountryInfoActivity : BaseActivity(), CountryInfoContract.View {

	@Inject
	lateinit var presenter: CountryInfoPresenter

	override fun onInject() = App.appComponent.inject(this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		presenter.loadData("Brazil")
	}

	override fun showCountryInfo(countryInfo: CountryInfo) {

	}

	override fun showDataError() {

	}
}
