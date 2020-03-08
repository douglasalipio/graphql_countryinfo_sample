package com.douglas.interview.countriesinfo.di

import com.douglas.interview.countriesinfo.data.AppRepository
import com.douglas.interview.countriesinfo.data.AppRepositoryImp
import com.douglas.interview.countriesinfo.data.remote.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {

	@Provides
	@Reusable
	fun provideAppRepository(remoteDataSource: RemoteRepository): AppRepository =
		AppRepositoryImp(remoteDataSource)

}
