package com.douglas.interview.countriesinfo.di

import com.douglas.interview.countriesinfo.data.AppRepository
import com.douglas.interview.countriesinfo.features.CountryInfoContract
import com.douglas.interview.countriesinfo.features.CountryInfoInteractor
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class InteractorModule {

	@Provides
	@Reusable
	fun provideCountryInteractor(appRepository: AppRepository): CountryInfoContract.Interactor =
		CountryInfoInteractor(appRepository)
}
