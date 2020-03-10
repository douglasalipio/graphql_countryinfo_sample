package com.douglas.interview.countriesinfo.features.view

import com.douglas.interview.countriesinfo.R
import com.douglas.interview.countriesinfo.features.City
import com.douglas.interview.countriesinfo.features.CountryInfo
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.country_header_view.view.*
import kotlinx.android.synthetic.main.country_item_view.view.*

class CountryInfoItem(private val city: City) : Item() {

	override fun bind(viewHolder: GroupieViewHolder, position: Int) {
		viewHolder.itemView.cityName.text = city.name
		viewHolder.itemView.cityPopulation.text = city.population
	}

	override fun getLayout() = R.layout.country_item_view
}
