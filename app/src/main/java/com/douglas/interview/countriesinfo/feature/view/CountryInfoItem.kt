package com.douglas.interview.countriesinfo.feature.view

import com.douglas.interview.countriesinfo.R
import com.douglas.interview.countriesinfo.feature.City
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.country_item_view.view.*

class CountryInfoItem(private val city: City) : Item() {

	override fun bind(viewHolder: GroupieViewHolder, position: Int) {
		viewHolder.itemView.cityName.text = city.name
	}

	override fun getLayout() = R.layout.country_item_view
}
