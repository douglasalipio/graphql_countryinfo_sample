package com.douglas.interview.countriesinfo.di

import com.douglas.interview.countriesinfo.data.mapper.CountryInfoDtoToCountryInfoMapper
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class MapperModule {
	@Provides
	@Reusable
	internal fun provideCountryInfoMapper() = CountryInfoDtoToCountryInfoMapper()
}
