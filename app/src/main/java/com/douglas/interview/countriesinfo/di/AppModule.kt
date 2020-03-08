package com.douglas.interview.countriesinfo.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class AppModule {

	@Provides
	@Reusable
	fun provideContext(application: Application): Application = application
}
