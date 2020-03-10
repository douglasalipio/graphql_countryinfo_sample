package com.douglas.interview.countriesinfo.data.mapper

import com.douglas.interview.countriesinfo.GetCountriesInfoQuery
import com.douglas.interview.countriesinfo.feature.City
import com.douglas.interview.countriesinfo.feature.CountryInfo
import com.douglas.interview.countriesinfo.utils.Mapper

class CountryInfoDtoToCountryInfoMapper : Mapper<GetCountriesInfoQuery.Data, CountryInfo> {

	override fun map(from: GetCountriesInfoQuery.Data?): CountryInfo? {
		if (from != null) {
			return CountryInfo(
				name = from.country()?.name().orEmpty(),
				native = from.country()?.native_().orEmpty(),
				continent = from.country()?.continent()?.name().orEmpty(),
				language = mapLanguages(from.country()?.languages()).orEmpty(),
				cities = mapCities(from.country()?.states().orEmpty())
			)
		}
		return null
	}

	private fun mapLanguages(language: List<GetCountriesInfoQuery.Language>?) =
		language?.map { it.name().orEmpty() }


	private fun mapCities(cities: List<GetCountriesInfoQuery.State>) =
		cities.map { City(it.name().orEmpty()) }

	override fun mapToList(from: GetCountriesInfoQuery.Data): List<CountryInfo> {
		TODO("Not yet implemented")
	}
}
