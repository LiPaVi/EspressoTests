package com.moonpi.swiftnotes

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SimpleTest {

    @get:Rule
    val rule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun newNoteHints() {
        onView(withId(R.id.newNote)).perform(click())
        onView(allOf(withId(R.id.titleEdit), isDisplayed())).check(matches(withHint("Title")))
        onView(allOf(withId(R.id.bodyEdit), isDisplayed())).check(matches(withHint("Note")))
    }
}