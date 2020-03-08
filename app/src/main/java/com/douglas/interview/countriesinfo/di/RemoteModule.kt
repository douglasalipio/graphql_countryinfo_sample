package com.douglas.interview.countriesinfo.di

import com.apollographql.apollo.ApolloClient
import com.douglas.interview.countriesinfo.data.remote.RemoteRepository
import com.douglas.interview.countriesinfo.data.remote.RemoteRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RemoteModule {

	@Provides
	@Reusable
	fun provideRemoteSource(apolloClient: ApolloClient): RemoteRepository =
		RemoteRepositoryImp(apolloClient)
}
