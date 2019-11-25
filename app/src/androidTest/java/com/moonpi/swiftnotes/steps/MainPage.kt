package com.moonpi.swiftnotes.steps

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.longClick
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.RootMatchers
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isEnabled
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.moonpi.swiftnotes.R
import org.hamcrest.CoreMatchers
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class MainPage {
    private val titleText = "Swiftnotes"
    private val backup = "Backup notes"
    private val restore = "Restore notes"
    private val rateApp = "Rate app"
    private val addNote = onView(ViewMatchers.withId(R.id.newNote))
    private val toolbar = onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.toolbarMain), ViewMatchers.isDisplayed()))
    private val titleView = onView(ViewMatchers.withId(R.id.titleView))
    private val bodyView = onView(ViewMatchers.withId(R.id.bodyView))
    private val menu = onView(ViewMatchers.withContentDescription("Ещё"))
    private val backupMenu = onView(withText(backup))
    private val restoreMenu = onView(withText(restore))
    private val rateAppMenu = onView(withText(rateApp))
    private val note = onView(ViewMatchers.withId(R.id.relativeLayout))
    private val delete = onView(ViewMatchers.withId(R.id.action_delete))
    private val okButton = onView(ViewMatchers.withId(android.R.id.button1)).inRoot(RootMatchers.isDialog())

    fun clickPlusButton() {
        step("Нажать \"+\"") {
            addNote.perform(click())
            deviceScreenshot("main_page_display")
        }
    }

    fun checkToolbarTitle() {
        step("Открылся главный экран \"$titleText\"") {
            toolbar.check(ViewAssertions.matches(ViewMatchers.withChild(withText(titleText))))
            deviceScreenshot("main_page_display")
        }
    }

    fun checkNoteText(titleText: String, noteText: String) {
        step("Проверяем, что запись появилась") {
            titleView.check(ViewAssertions.matches(withText(titleText)))
            bodyView.check(ViewAssertions.matches(withText(noteText)))
            deviceScreenshot("main_page_display")
        }
    }

    fun clickMenu() {
        step("Нажать \"Меню\"") {
            menu.perform(click())
            deviceScreenshot("main_page_display")
        }
    }

    fun checkMenu() {
        step("Проверить отображение пунктов меню: \"$backup\", \"$restore\", \"$rateApp\"") {
            backupMenu.check(ViewAssertions.matches(isEnabled()))
            restoreMenu.check(ViewAssertions.matches(isEnabled()))
            rateAppMenu.check(ViewAssertions.matches(isEnabled()))
            deviceScreenshot("main_page_display")
        }
    }

    fun longClickToNote() {
        step("Лонг тап на заметку на главном экране") {
            note.perform(longClick())
            deviceScreenshot("main_page_display")
        }
    }

    fun deleteNote() {
        step("В тулбаре нажать \"Удалить\" и затем нажать \"Ок\"") {
            delete.perform(click())
            okButton.perform(click())
            deviceScreenshot("main_page_display")
        }
    }

    fun checkDeletedNote() {
        step("Проверяем отсутствие заметки на главном экране") {
            note.check(ViewAssertions.doesNotExist())
            deviceScreenshot("main_page_display")
        }
    }
}