package com.demo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginTest {

    @Test
    fun press_Display_Country_button_move_to_error_state() {
        // Given
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Then
        onView(withId(R.id.btnDisplayCountry)).check(matches(withText("Display country")))

        // When
        onView(withId(R.id.btnDisplayCountry)).perform(click())

        // Then
        onView(withId(R.id.imageError)).check(matches(withId(R.id.imageError)))
    }

//    @Test
//    fun clickDisplayCountryButton_navigateToCountryListFragment() {
//        // GIVEN - On the Login screen
//        val scenario = launchFragmentInContainer<LoginFragment>(Bundle(), R.style.Theme_Recyclerviewlab)
//
//        val navController = mock(NavController::class.java)
//        scenario.onFragment {
//            Navigation.setViewNavController(it.view!!, navController)
//        }
//
//        // WHEN - Click on the button
//        onView(withId(R.id.btnDisplayCountry)).perform(click())
//
//        // THEN - Verify that we navigate to the add screen
//        verify(navController).navigate(R.id.action_showCountries)
//    }
}