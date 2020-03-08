package com.douglas.interview.countriesinfo

import android.app.Application
import com.douglas.interview.countriesinfo.di.AppComponent
import com.douglas.interview.countriesinfo.di.DaggerAppComponent


class App : Application() {

	companion object {
		lateinit var appComponent: AppComponent
	}


	override fun onCreate() {
		super.onCreate()
		initDagger()
	}

	private fun initDagger() {
		appComponent = DaggerAppComponent.create()
	}
}
