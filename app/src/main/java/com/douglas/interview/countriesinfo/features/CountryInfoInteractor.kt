package com.douglas.interview.countriesinfo.features

import com.apollographql.apollo.api.Response
import com.douglas.interview.countriesinfo.GetCountriesInfoQuery
import com.douglas.interview.countriesinfo.data.AppRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountryInfoInteractor @Inject constructor(private val appRepository: AppRepository) :
	CountryInfoContract.Interactor {

	private val disposable = CompositeDisposable()
	override fun requestCountryInfo(
		getCountryInfoCallback: GetCountryCallback,
		countryName: String
	) {
		disposable.add(appRepository
			.getCountryInfo(countryName)
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.doOnError { getCountryInfoCallback.onDataNotAvailable(it.message.toString()) }
			.subscribe { getCountryInfoCallback.onCountryInfoLoaded(it) })
	}


	interface GetCountryCallback {

		fun onCountryInfoLoaded(data: Response<GetCountriesInfoQuery.Data>)

		fun onDataNotAvailable(strError: String)
	}

	override fun disposable() = disposable.clear()
}
