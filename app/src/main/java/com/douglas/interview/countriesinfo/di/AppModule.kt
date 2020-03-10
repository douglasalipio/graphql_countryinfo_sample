package com.douglas.interview.countriesinfo.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class AppModule {

	@Provides
	@Reusable
	fun provideApplicationContext(application: Application): Application = application

	@Provides
	@Reusable
	fun provideContext(context: Context): Context = context
}
