package com.douglas.interview.countriesinfo.di

import com.douglas.interview.countriesinfo.feature.CountryInfoContract
import com.douglas.interview.countriesinfo.feature.CountryInfoPresenter
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
