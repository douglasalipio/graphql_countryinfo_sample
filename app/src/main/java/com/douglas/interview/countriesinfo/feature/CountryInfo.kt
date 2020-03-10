package com.douglas.interview.countriesinfo.feature

data class CountryInfo(
	val name: String,
	val native: String,
	val continent: String,
	val language: List<String>,
	val cities: List<City>
)

data class City(val name: String)


