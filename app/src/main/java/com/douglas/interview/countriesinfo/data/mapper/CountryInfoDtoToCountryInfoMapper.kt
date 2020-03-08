package com.douglas.interview.countriesinfo.data.mapper

import com.douglas.interview.countriesinfo.GetCountriesInfoQuery
import com.douglas.interview.countriesinfo.features.City
import com.douglas.interview.countriesinfo.features.CountryInfo
import com.douglas.interview.countriesinfo.utils.Mapper

class CountryInfoDtoToCountryInfoMapper : Mapper<GetCountriesInfoQuery.Data, CountryInfo> {

	override fun map(from: GetCountriesInfoQuery.Data?): CountryInfo? {
		if (from != null) {
			CountryInfo(
				name = from.countries.last().name,
				capital = from.countries.last().capital?.name.orEmpty(),
				population = from.countries.last().population.toString(),
				cities = mapCities(from.countries.last().cities)
			)
		}
		return null
	}

	private fun mapCities(cities: List<GetCountriesInfoQuery.City>) =
		cities.map { City(it.name, it.population.toString()) }

	override fun mapToList(from: GetCountriesInfoQuery.Data): List<CountryInfo> {
		TODO("Not yet implemented")
	}
}
