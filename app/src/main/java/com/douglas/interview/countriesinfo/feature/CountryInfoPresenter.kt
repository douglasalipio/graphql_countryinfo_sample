package com.douglas.interview.countriesinfo.feature

import com.douglas.interview.countriesinfo.data.local.LocalRepository
import javax.inject.Inject

class CountryInfoPresenter @Inject constructor(private val interactor: CountryInfoContract.Interactor) :
	CountryInfoContract.Presenter {
	@Inject
	lateinit var localRepository: LocalRepository
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
		}, countryName)
	}

	override fun dropView() {
		view = null
		interactor.disposable()
	}
}
