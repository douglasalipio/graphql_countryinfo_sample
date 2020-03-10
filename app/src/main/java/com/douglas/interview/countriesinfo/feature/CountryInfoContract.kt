package com.douglas.interview.countriesinfo.feature

import com.douglas.interview.countriesinfo.foundation.BaseInteractor
import com.douglas.interview.countriesinfo.foundation.BasePresenter
import com.douglas.interview.countriesinfo.foundation.BaseView

interface CountryInfoContract {

	interface View : BaseView<Presenter> {

		fun showCountryInfo(countryInfo: CountryInfo)
		fun showDataError()
	}

	interface Presenter : BasePresenter {
		fun loadData(countryName: String)
	}

	interface Interactor : BaseInteractor {
		fun requestCountryInfo(
			getCountryInfoCallback: CountryInfoInteractor.GetCountryCallback,
			countryName: String
		)

		fun disposable()
	}
}
