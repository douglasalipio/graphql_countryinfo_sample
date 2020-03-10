package com.douglas.interview.countriesinfo.feature

import javax.inject.Inject

class CountryInfoPresenter @Inject constructor(private val interactor: CountryInfoContract.Interactor) :
	CountryInfoContract.Presenter {
	@Inject
	lateinit var countryHelper: CountryHelper
	private var view: CountryInfoContract.View? = null

	override fun <T> takeView(view: T) {
		this.view = view as CountryInfoContract.View
	}

	override fun loadData(countryName: String) {

		interactor.requestCountryInfo(object : CountryInfoInteractor.GetCountryCallback {
			override fun onCountryInfoLoaded(data: CountryInfo?) {
				data?.let { view?.showCountryInfo(data) }
			}

			override fun onDataNotAvailable(strError: String) {
				view?.showDataError()
			}

		}, CountryHelper.countryCode(countryName))
	}

	override fun dropView() {
		view = null
		interactor.disposable()
	}
}
