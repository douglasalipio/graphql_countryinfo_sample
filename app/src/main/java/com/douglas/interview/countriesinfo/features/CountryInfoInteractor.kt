package com.douglas.interview.countriesinfo.features

import com.douglas.interview.countriesinfo.data.AppRepository
import com.douglas.interview.countriesinfo.data.mapper.CountryInfoDtoToCountryInfoMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountryInfoInteractor @Inject constructor(
	private val appRepository: AppRepository,
	private val mapper: CountryInfoDtoToCountryInfoMapper
) :
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
			.subscribe { response ->
				val data = mapper.map(response.data())
				getCountryInfoCallback.onCountryInfoLoaded(data)
			})
	}


	interface GetCountryCallback {

		fun onCountryInfoLoaded(data: CountryInfo?)

		fun onDataNotAvailable(strError: String)
	}

	override fun disposable() = disposable.clear()
}
