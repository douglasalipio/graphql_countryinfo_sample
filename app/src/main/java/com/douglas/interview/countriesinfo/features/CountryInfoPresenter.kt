package com.douglas.interview.countriesinfo.features

import com.apollographql.apollo.api.Response
import com.douglas.interview.countriesinfo.GetCountriesInfoQuery
import javax.inject.Inject

class CountryInfoPresenter @Inject constructor(private val interactor: CountryInfoContract.Interactor) :
	CountryInfoContract.Presenter {

	private var view: CountryInfoContract.View? = null

	override fun <T> takeView(view: T) {
		this.view = view as CountryInfoContract.View
	}

	override fun loadData(countryName: String) {

		interactor.requestCountryInfo(object : CountryInfoInteractor.GetCountryCallback {
			override fun onCountryInfoLoaded(data: Response<GetCountriesInfoQuery.Data>) {
				view?.showCountryInfo()
			}

			override fun onDataNotAvailable(strError: String) {
			}

		}, "Brazil")
	}

	override fun dropView() {
		view = null
		interactor.disposable()
	}
}
