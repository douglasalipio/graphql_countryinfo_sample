package com.douglas.interview.countriesinfo.data.local

import android.content.Context
import com.douglas.interview.countriesinfo.App
import com.douglas.interview.countriesinfo.data.feature.country.CountryCode
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Flowable
import io.reactivex.Observable
import java.io.BufferedReader
import javax.inject.Inject

interface LocalRepository {
	fun countryCode(countryName: String): Observable<String>
}
