package com.douglas.interview.countriesinfo.feature.view

import com.douglas.interview.countriesinfo.R
import com.douglas.interview.countriesinfo.feature.CountryInfo
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.country_header_view.view.*


class CountryInfoHeader(private val countryInfo: CountryInfo) : Item() {

	override fun bind(viewHolder: GroupieViewHolder, position: Int) {
		viewHolder.itemView.countryName.text = countryInfo.name
		viewHolder.itemView.capital.text = countryInfo.capital
		viewHolder.itemView.population.text = countryInfo.population
	}

	override fun getLayout() = R.layout.country_header_view
}
