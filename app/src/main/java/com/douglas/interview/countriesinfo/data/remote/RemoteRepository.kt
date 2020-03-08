package com.douglas.interview.countriesinfo.data.remote

import com.apollographql.apollo.api.Response
import com.douglas.interview.countriesinfo.GetCountriesInfoQuery
import io.reactivex.Observable

interface RemoteRepository {

	fun getCountryInfo(countryName: String = ""): Observable<Response<GetCountriesInfoQuery.Data>>
}
