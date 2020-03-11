package com.douglas.interview.countriesinfo.feature.view


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import com.douglas.interview.countriesinfo.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CountryInfoActivityTest {

	@Rule
	@JvmField
	var mActivityTestRule = ActivityTestRule(CountryInfoActivity::class.java)

	@Test
	fun countryInfoActivityTest() {
		val checkableImageButton = onView(
			allOf(
				withId(R.id.text_input_end_icon), withContentDescription("Show dropdown menu"),
				childAtPosition(
					childAtPosition(
						withClassName(`is`("android.widget.FrameLayout")),
						2
					),
					0
				),
				isDisplayed()
			)
		)
		checkableImageButton.perform(click())
	}

	private fun childAtPosition(
		parentMatcher: Matcher<View>, position: Int
	): Matcher<View> {

		return object : TypeSafeMatcher<View>() {
			override fun describeTo(description: Description) {
				description.appendText("Child at position $position in parent ")
				parentMatcher.describeTo(description)
			}

			public override fun matchesSafely(view: View): Boolean {
				val parent = view.parent
				return parent is ViewGroup && parentMatcher.matches(parent)
					&& view == parent.getChildAt(position)
			}
		}
	}
}
