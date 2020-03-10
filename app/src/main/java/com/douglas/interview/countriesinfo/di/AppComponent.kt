package com.douglas.interview.countriesinfo.di

import com.douglas.interview.countriesinfo.features.CountryInfoPresenter
import com.douglas.interview.countriesinfo.features.view.CountryInfoActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
	modules = [
		AppModule::class,
		GraphModule::class,
		RemoteModule::class,
		MapperModule::class,
		PresenterModule::class,
		InteractorModule::class,
		RepositoryModule::class]
)
interface AppComponent {
	fun inject(activity: CountryInfoActivity)
	fun build(): AppComponent
}
