package com.douglas.interview.countriesinfo.data

import com.douglas.interview.countriesinfo.data.local.LocalRepository
import com.douglas.interview.countriesinfo.data.remote.RemoteRepository
import io.reactivex.Flowable
import javax.inject.Inject

class AppRepositoryImp @Inject constructor(
	private val remoteRepository: RemoteRepository,
	private val localRepository: LocalRepository
) :
	AppRepository {

	override fun getCountryInfo(countryName: String) = remoteRepository.getCountryInfo(countryName)

	override fun getCountryCode(countryName: String) = localRepository.countryCode(countryName)
}
