package com.douglas.interview.countriesinfo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


fun Context.isConnectedToNetwork(): Boolean {
	val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
	val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
	var result = false
	activeNetwork?.let { result = activeNetwork.isConnectedOrConnecting }
	return result
}
