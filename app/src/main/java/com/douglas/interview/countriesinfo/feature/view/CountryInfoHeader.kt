package com.douglas.interview.countriesinfo.feature.view

import android.annotation.SuppressLint
import com.douglas.interview.countriesinfo.R
import com.douglas.interview.countriesinfo.feature.CountryInfo
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.country_header_view.view.*


class CountryInfoHeader(private val countryInfo: CountryInfo) : Item() {

	@SuppressLint("SetTextI18n")
	override fun bind(viewHolder: GroupieViewHolder, position: Int) {
		viewHolder.itemView.countryName.text = "${countryInfo.name}/${countryInfo.native}"
		viewHolder.itemView.languages.text = countryInfo.language.joinToString()
		viewHolder.itemView.continent.text = countryInfo.continent
	}

	override fun getLayout() = R.layout.country_header_view
}
