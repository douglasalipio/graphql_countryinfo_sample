package com.douglas.interview.countriesinfo

import com.douglas.interview.countriesinfo.feature.City
import com.douglas.interview.countriesinfo.feature.CountryInfo


fun mockCountryInfo() =
	CountryInfo(
		name = "Ireland",
		continent = "Europe",
		native = "Dublin",
		language = listOf(),
		cities = listOf(City("Dublin"))
	)

fun mockCountryDto() = GetCountriesInfoQuery.Data(
	GetCountriesInfoQuery.Country(
		"",
		"Ireland",
		"Ireland",
		"",
		listOf(),
		"",
		listOf(),
		GetCountriesInfoQuery.Continent("", "Europe")
	)
)
