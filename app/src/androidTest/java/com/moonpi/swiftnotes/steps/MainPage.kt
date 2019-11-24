package com.moonpi.swiftnotes.steps

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isEnabled
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.moonpi.swiftnotes.R
import org.hamcrest.CoreMatchers
import ru.tinkoff.allure.step

class MainPage {
    private val addNote = onView(ViewMatchers.withId(R.id.newNote))
    private val toolbar = onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.toolbarMain), ViewMatchers.isDisplayed()))
    private val titleText = "Swiftnotes"
    private val backup = "Backup notes"
    private val restore = "Restore notes"
    private val rateApp = "Rate app"
    private val titleView = onView(ViewMatchers.withId(R.id.titleView))
    private val bodyView = onView(ViewMatchers.withId(R.id.bodyView))
    private val menu = onView(ViewMatchers.withContentDescription("Ещё"))
    private val backupMenu = onView(withText(backup))
    private val restoreMenu = onView(withText(restore))
    private val rateAppMenu = onView(withText(rateApp))
    private val note = onView(ViewMatchers.withId(R.id.relativeLayout))
    private val delete = onView(ViewMatchers.withId(R.id.action_delete))

    fun clickPlusButton() {
        step("Нажать \"+\"") {
            addNote.perform(click())
        }
    }

    fun checkToolbarTitle() {
        step("Открылся главный экран \"{titleText}\"") {
            toolbar.check(ViewAssertions.matches(ViewMatchers.withChild(withText(titleText))))
        }
    }

    fun checkNoteText(titleText: String, noteText: String) {
        step("Проверяем, что запись появилась") {
            titleView.check(ViewAssertions.matches(withText(titleText)))
            bodyView.check(ViewAssertions.matches(withText(noteText)))
        }
    }

    fun clickMenu() {
        step("Нажать \"Меню\"") {
            menu.perform(click())
        }
    }

    fun checkMenu() {
        step("Проверить отображение пунктов меню: \"{backup}\", \"{restore}\", \"{rateApp}\"") {
            backupMenu.check(ViewAssertions.matches(isEnabled()))
            restoreMenu.check(ViewAssertions.matches(isEnabled()))
            rateAppMenu.check(ViewAssertions.matches(isEnabled()))
        }
    }
}