package com.douglas.interview.countriesinfo.data

import com.douglas.interview.countriesinfo.data.remote.RemoteRepository
import javax.inject.Inject

class AppRepositoryImp @Inject constructor(private val remoteRepository: RemoteRepository) :
	AppRepository {

	override fun getCountryInfo(countryName: String) = remoteRepository.getCountryInfo(countryName)

}
