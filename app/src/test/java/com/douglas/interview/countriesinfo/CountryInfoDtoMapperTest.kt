package com.douglas.interview.countriesinfo

import com.douglas.interview.countriesinfo.data.mapper.CountryInfoDtoToCountryInfoMapper
import junit.framework.Assert.assertEquals
import org.junit.Test

class CountryInfoDtoMapperTest {

	private val mapper = CountryInfoDtoToCountryInfoMapper()

	@Test
	fun `should validate forecast mapper`() {
		// given
		val countryDto = mockCountryDto()
		val expectedCountryInfo = mockCountryInfo()
		// when
		val mappingResult = mapper.map(countryDto)
		// then
		assertEquals(expectedCountryInfo.name, mappingResult?.name)
		assertEquals(expectedCountryInfo.capital, mappingResult?.capital)
		assertEquals(expectedCountryInfo.population, mappingResult?.population)
	}

}
