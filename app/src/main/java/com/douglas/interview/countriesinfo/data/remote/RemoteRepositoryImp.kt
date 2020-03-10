package com.douglas.interview.countriesinfo.data.remote

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx2.rxQuery
import com.douglas.interview.countriesinfo.GetCountriesInfoQuery
import com.douglas.interview.countriesinfo.data.remote.RemoteRepository
import io.reactivex.Observable
import javax.inject.Inject

class RemoteRepositoryImp @Inject constructor(private val apolloClient: ApolloClient) :
	RemoteRepository {

	override fun getCountryInfo(countryName: String): Observable<Response<GetCountriesInfoQuery.Data>> {
		val query = GetCountriesInfoQuery
			.builder()
			.nameSelected(countryName)
			.build()

		return apolloClient.rxQuery(query)
	}
}
