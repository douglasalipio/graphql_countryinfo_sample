package com.douglas.interview.countriesinfo.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.douglas.interview.countriesinfo.R


fun initArrayAdapter(
	context: Context,
	countryArray: Array<String>
): ArrayAdapter<String> {
	return ArrayAdapter(
		context,
		R.layout.support_simple_spinner_dropdown_item,
		countryArray
	)
}

fun hideKeyboardFrom(context: Context, view: View) {
	val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
	imm.hideSoftInputFromWindow(view.windowToken, 0)
}
