package com.douglas.interview.countriesinfo.utils

interface Mapper<in FROM, out TO> {

    fun map(from: FROM?): TO?

    fun mapToList(from: FROM): List<TO>
}
