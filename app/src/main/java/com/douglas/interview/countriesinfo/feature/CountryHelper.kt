package com.douglas.interview.countriesinfo.feature

import com.douglas.interview.countriesinfo.App
import com.douglas.interview.countriesinfo.data.feature.country.CountryCode
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader

object CountryHelper {

	private const val COUNTRY_CODE_FILE_NAME = "country_code.json"
	const val DEFAULT_COUNTRY_NAME = "Brazil"

	private val type = object : TypeToken<List<CountryCode>>() {}.type

	fun countryCode(countryName: String): String {
		val countryCodeJson = App.context.assets
			.open(COUNTRY_CODE_FILE_NAME)
			.bufferedReader()
			.use(BufferedReader::readText)
		val countryList = Gson().fromJson<List<CountryCode>>(countryCodeJson, type)
		return countryList.findLast { country -> country.name == countryName }?.code.orEmpty()
	}
}
