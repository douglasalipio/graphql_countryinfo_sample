package com.douglas.interview.countriesinfo.data.local

import android.content.Context
import com.douglas.interview.countriesinfo.App
import com.douglas.interview.countriesinfo.data.feature.country.CountryCode
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import java.io.BufferedReader
import javax.inject.Inject

class LocalRepositoryImp : LocalRepository {
	companion object {
		private const val COUNTRY_CODE_FILE_NAME = "country_code.json"
		const val DEFAULT_COUNTRY_NAME = "Brazil"
	}

	private val type = object : TypeToken<List<CountryCode>>() {}.type

	override fun countryCode(countryName: String): Observable<String> {
		return Observable.fromCallable {
			val countryCodeJson = App.context.assets
				.open(COUNTRY_CODE_FILE_NAME)
				.bufferedReader()
				.use(BufferedReader::readText)
			val countryList = Gson().fromJson<List<CountryCode>>(
				countryCodeJson,
				type
			)
			countryList.findLast { country -> country.name == countryName }?.code.orEmpty()
		}
	}
}
