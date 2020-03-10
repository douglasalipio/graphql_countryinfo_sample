package com.douglas.interview.countriesinfo

import com.douglas.interview.countriesinfo.features.*
import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class CountryInfoPresenterTest {
	@Mock
	private lateinit var view: CountryInfoContract.View

	@Mock
	private lateinit var interactor: CountryInfoContract.Interactor

	@Captor
	private lateinit var getCountryInfoCallbackCaptor: ArgumentCaptor<CountryInfoInteractor.GetCountryCallback>
	private lateinit var presenter: CountryInfoPresenter

	@Before
	fun setUp() {
		MockitoAnnotations.initMocks(this)
		presenter = CountryInfoPresenter(interactor)
		presenter.takeView(view)
	}

	@Test
	fun `should return a country info`() {
		//Given
		presenter.loadData("Ireland")
		//When
		verify(interactor).requestCountryInfo(capture(getCountryInfoCallbackCaptor), anyString())
		getCountryInfoCallbackCaptor.value.onCountryInfoLoaded(mockCountryInfo())
		//Then
		verify(view).showCountryInfo(mockCountryInfo())
	}

	@Test
	fun `should show a error message`() {
		//Given
		presenter.loadData("Ireland")
		//When
		verify(interactor).requestCountryInfo(capture(getCountryInfoCallbackCaptor), anyString())
		getCountryInfoCallbackCaptor.value.onDataNotAvailable("data not available.")
		//Than
		verify(view).showDataError()
	}


}
