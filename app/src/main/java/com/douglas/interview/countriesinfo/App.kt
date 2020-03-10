package com.douglas.interview.countriesinfo

import android.app.Application
import android.content.Context
import com.douglas.interview.countriesinfo.di.AppComponent
import com.douglas.interview.countriesinfo.di.DaggerAppComponent


class App : Application() {

	companion object {
		lateinit var appComponent: AppComponent
		lateinit var context: Context
	}


	override fun onCreate() {
		super.onCreate()
		initDagger()
		context = this.applicationContext
	}

	private fun initDagger() {
		appComponent = DaggerAppComponent.create()
	}
}
