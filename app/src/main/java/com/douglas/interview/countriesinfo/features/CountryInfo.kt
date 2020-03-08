package com.douglas.interview.countriesinfo.features

data class CountryInfo	(
	val name: String,
	val population: String,
	val capital: String,
	val cities: List<City>
)

data class City(
	val name: String,
	val population: String
)
