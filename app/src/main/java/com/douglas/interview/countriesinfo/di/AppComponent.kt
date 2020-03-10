package com.douglas.interview.countriesinfo.di

import com.douglas.interview.countriesinfo.feature.view.CountryInfoActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
	modules = [
		AppModule::class,
		GraphModule::class,
		RemoteRepositoryModule::class,
		MapperModule::class,
		PresenterModule::class,
		InteractorModule::class,
		LocalRepositoryModule::class,
		AppRepositoryModule::class]
)
interface AppComponent {
	fun inject(activity: CountryInfoActivity)
}
