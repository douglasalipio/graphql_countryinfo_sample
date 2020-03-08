package com.douglas.interview.countriesinfo.utils

import com.douglas.interview.countriesinfo.GetCountriesInfoQuery

interface Mapper<in FROM, out TO> {

	fun map(from: GetCountriesInfoQuery.Data?): TO?

	fun mapToList(from: FROM): List<TO>
}
