package com.douglas.interview.countriesinfo.foundation

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

	init {
		inject()
	}

	private fun inject() = onInject()
	protected abstract fun onInject()

}
