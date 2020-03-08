package com.douglas.interview.countriesinfo.features

import com.douglas.interview.countriesinfo.foundation.BaseInteractor
import com.douglas.interview.countriesinfo.foundation.BasePresenter
import com.douglas.interview.countriesinfo.foundation.BaseView

interface CountryInfoContract {

	interface View : BaseView<Presenter> {

		fun showCountryInfo()
	}

	interface Presenter : BasePresenter {
		fun loadData(countryName: String)
	}

	interface Interactor : BaseInteractor {
		fun requestCountryInfo(getCountryInfoCallback: CountryInfoInteractor.GetCountryCallback, countryName: String)
		fun disposable()
	}
}
