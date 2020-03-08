package com.douglas.interview.countriesinfo.di

import com.douglas.interview.countriesinfo.features.CountryInfoContract
import com.douglas.interview.countriesinfo.features.CountryInfoPresenter
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class PresenterModule {

	@Provides
	@Reusable
	fun provideAuthentication(interactor: CountryInfoContract.Interactor) =
		CountryInfoPresenter(interactor)
}
