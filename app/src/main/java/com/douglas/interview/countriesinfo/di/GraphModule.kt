package com.douglas.interview.countriesinfo.di

import com.apollographql.apollo.ApolloClient
import com.douglas.interview.countriesinfo.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class GraphModule {

	@Provides
	@Singleton
	fun provideInterceptor(): HttpLoggingInterceptor =
		HttpLoggingInterceptor()
			.setLevel(
				if (BuildConfig.DEBUG)
					HttpLoggingInterceptor.Level.BODY
				else
					HttpLoggingInterceptor.Level.NONE
			)

	@Provides
	@Singleton
	fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
		OkHttpClient.Builder()
			.addInterceptor(httpLoggingInterceptor)
			.writeTimeout(10, TimeUnit.SECONDS)
			.connectTimeout(10, TimeUnit.SECONDS)
			.readTimeout(10, TimeUnit.SECONDS)
			.build()

	@Provides
	@Singleton
	fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient =
		ApolloClient.builder()
			.serverUrl(BuildConfig.BASE_URL)
			.okHttpClient(okHttpClient)
			.build()
}
