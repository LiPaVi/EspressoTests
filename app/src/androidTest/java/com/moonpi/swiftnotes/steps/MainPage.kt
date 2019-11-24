package com.moonpi.swiftnotes.steps

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.moonpi.swiftnotes.R
import org.hamcrest.CoreMatchers
import ru.tinkoff.allure.step

class MainPage {
    private val addNote = Espresso.onView(ViewMatchers.withId(R.id.newNote))
    private val toolbar = onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.toolbarMain), ViewMatchers.isDisplayed()))
    private val titleText = "Swiftnotes"


    fun clickPlusButton() {
        step("Нажать \"+\"") {
            addNote.perform(click());
        }
    }

    fun checkToolbarTitle() {
        step("Открылся главный экран \"{titleText}\"") {
            toolbar.check(ViewAssertions.matches(ViewMatchers.withChild(withText(titleText))))
        }
    }
}