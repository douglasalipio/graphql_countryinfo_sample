package com.douglas.interview.countriesinfo.data

import com.apollographql.apollo.api.Response
import com.douglas.interview.countriesinfo.GetCountriesInfoQuery
import io.reactivex.Observable

interface AppRepository {

	fun getCountryInfo(countryName: String): Observable<Response<GetCountriesInfoQuery.Data>>
}
