package com.moonpi.swiftnotes.steps

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import com.moonpi.swiftnotes.R
import ru.tinkoff.allure.step

class MainPage {
    private val addNote = Espresso.onView(ViewMatchers.withId(R.id.newNote))

    fun clickPlusButton() {
        step("Нажать \"+\"") {
            addNote.perform(click());
        }
    }
}