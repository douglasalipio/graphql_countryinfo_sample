package com.douglas.interview.countriesinfo.di

import android.app.Application
import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.douglas.interview.countriesinfo.App
import com.douglas.interview.countriesinfo.data.AppRepository
import com.douglas.interview.countriesinfo.data.AppRepositoryImp
import com.douglas.interview.countriesinfo.data.local.LocalRepository
import com.douglas.interview.countriesinfo.data.local.LocalRepositoryImp
import com.douglas.interview.countriesinfo.data.mapper.CountryInfoDtoToCountryInfoMapper
import com.douglas.interview.countriesinfo.data.remote.RemoteRepository
import com.douglas.interview.countriesinfo.data.remote.RemoteRepositoryImp
import com.douglas.interview.countriesinfo.feature.CountryInfoContract
import com.douglas.interview.countriesinfo.feature.CountryInfoInteractor
import com.douglas.interview.countriesinfo.feature.CountryInfoPresenter
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

@Module
class LocalRepositoryModule {

	@Provides
	@Reusable
	fun provideLocalSource(): LocalRepository = LocalRepositoryImp()
}

@Module
class AppRepositoryModule {

	@Provides
	@Reusable
	fun provideAppRepository(
		remoteDataSource: RemoteRepository,
		localRepository: LocalRepository
	): AppRepository = AppRepositoryImp(remoteDataSource, localRepository)

}

@Module
class RemoteRepositoryModule {

	@Provides
	@Reusable
	fun provideRemoteSource(apolloClient: ApolloClient): RemoteRepository =
		RemoteRepositoryImp(apolloClient)
}

@Module
class InteractorModule {

	@Provides
	@Reusable
	fun provideCountryInteractor(appRepository: AppRepository): CountryInfoContract.Interactor =
		CountryInfoInteractor(appRepository, CountryInfoDtoToCountryInfoMapper())
}

@Module
class PresenterModule {

	@Provides
	@Reusable
	fun provideAuthentication(interactor: CountryInfoContract.Interactor) =
		CountryInfoPresenter(interactor)
}

@Module
class MapperModule {
	@Provides
	@Reusable
	internal fun provideCountryInfoMapper() = CountryInfoDtoToCountryInfoMapper()
}


