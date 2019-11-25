package com.moonpi.swiftnotes.steps

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.ViewMatchers.*
import com.moonpi.swiftnotes.R
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.endsWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class CreatePage {
    private val messageText = "Save changes?"
    private val positiveButtonText = "YES"
    private val negativeButtonText = "NO"
    private val noteFontSize = "Note font size"
    private val hideNote = "Hide note body in list"
    private val titleDefaultText = "Title"
    private val noteDefaultText = "Note"
    private val title = onView(CoreMatchers.allOf(withId(R.id.titleEdit), isDisplayed()))
    private val note = onView(CoreMatchers.allOf(withId(R.id.bodyEdit), isDisplayed()))
    private val backButton = onView(withClassName(endsWith("ImageButton")))
    private val saveDialog = onView(withId(android.R.id.message)).inRoot(isDialog())
    private val positiveButton = onView(withId(android.R.id.button1)).inRoot(isDialog())
    private val negativeButton = onView(withId(android.R.id.button2)).inRoot(isDialog())
    private val menu = onView(withContentDescription("Ещё"))
    private val noteFontSizeMenu = onView(withText(noteFontSize))
    private val hideNoteMenu = onView(withText(hideNote))

    fun checkTitle() {
        step("Проверить хинт заголовка \"$titleDefaultText\"") {
            title.check(ViewAssertions.matches(withHint(titleDefaultText)))
            deviceScreenshot("create_page_display")
        }
    }

    fun addNoteText(titleText: String, noteText: String) {
        step("В поля \"$titleDefaultText\" и \"$noteDefaultText\" ввести текст") {
            title.perform(replaceText(titleText))
            note.perform(replaceText(noteText))
            deviceScreenshot("create_page_display")
        }
    }

    fun checkNote() {
        step("Проверить хинт текста \"$noteDefaultText\"") {
            note.check(ViewAssertions.matches(withHint(noteDefaultText)))
            deviceScreenshot("create_page_display")
        }
    }

    fun clickBackButton() {
        step("Нажать в тулбаре \"Назад\"") {
            backButton.perform(click())
            deviceScreenshot("create_page_display")
        }
    }

    fun checkDialogMessageText() {
        step("Проверить текст \"$messageText\"") {
            saveDialog.check(ViewAssertions.matches(withText(messageText)))
            deviceScreenshot("create_page_display")
        }
    }

    fun checkButtonsText() {
        step("Проверить наличие двух кнопок \"$negativeButtonText\", \"$positiveButtonText\"") {
            positiveButton.check(ViewAssertions.matches(withText(positiveButtonText)))
            negativeButton.check(ViewAssertions.matches(withText(negativeButtonText)))
            deviceScreenshot("create_page_display")
        }
    }

    fun clickNegativeButton() {
        step("Нажать \"$negativeButtonText\"") {
            negativeButton.perform(click())
            deviceScreenshot("create_page_display")
        }
    }

    fun clickPositiveButton() {
        step("Нажать \"$positiveButtonText\"") {
            positiveButton.perform(click())
            deviceScreenshot("create_page_display")
        }
    }

    fun checkCorrectText(titleText: String, noteText: String) {
        step("Проверить, что текст введен корректно") {
            title.check(ViewAssertions.matches(withText(titleText)))
            note.check(ViewAssertions.matches(withText(noteText)))
            deviceScreenshot("create_page_display")
        }
    }

    fun clickMenu() {
        step("Нажать \"Меню\"") {
            menu.perform(click())
            deviceScreenshot("create_page_display")
        }
    }

    fun checkMenu() {
        step("Проверить отображение пунктов меню: \"$noteFontSize\", \"$hideNote\"") {
            noteFontSizeMenu.check(ViewAssertions.matches(isEnabled()))
            hideNoteMenu.check(ViewAssertions.matches(isEnabled()))
            deviceScreenshot("create_page_display")
        }
    }
}