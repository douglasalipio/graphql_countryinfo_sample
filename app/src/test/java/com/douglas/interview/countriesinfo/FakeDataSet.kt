package com.douglas.interview.countriesinfo

import com.douglas.interview.countriesinfo.feature.City
import com.douglas.interview.countriesinfo.feature.CountryInfo


fun mockCountryInfo() =
	CountryInfo(
		name = "Ireland",
		population = "20000000",
		capital = "Dublin",
		cities = listOf(City("Dublin", "1000000"))
	)

fun mockCountryDto() = GetCountriesInfoQuery.Data(listOf( GetCountriesInfoQuery.Country(
	name = "Ireland",
	population = 20000000,
	capital = GetCountriesInfoQuery.Capital(name = "Dublin"),
	cities = listOf(GetCountriesInfoQuery.City(name = "Dublin", population = 1000000))))
)
