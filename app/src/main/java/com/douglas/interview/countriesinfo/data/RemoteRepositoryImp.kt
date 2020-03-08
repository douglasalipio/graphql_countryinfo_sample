package com.douglas.interview.countriesinfo.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.apollographql.apollo.rx2.rxQuery
import com.douglas.interview.countriesinfo.GetCountriesInfoQuery
import javax.inject.Inject

class RemoteRepositoryImp @Inject constructor(private val apolloClient: ApolloClient) : RemoteRepository{

	override fun getCountryInfo(countryName: String) = apolloClient.rxQuery(GetCountriesInfoQuery())
}
