package com.douglas.interview.countriesinfo.data

interface RemoteRepository {

	fun getCountryInfo(countryName: String = "")
}
