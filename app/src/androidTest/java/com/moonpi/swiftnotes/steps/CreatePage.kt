package com.moonpi.swiftnotes.steps

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.ImageButton
import com.moonpi.swiftnotes.R
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.endsWith
import org.hamcrest.Matcher
import ru.tinkoff.allure.step
import java.util.regex.Pattern.matches

class CreatePage {
    private val title = onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.titleEdit), ViewMatchers.isDisplayed()))
    private val note = onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.bodyEdit), ViewMatchers.isDisplayed()))
    private val backButton = onView(withClassName(endsWith("ImageButton")))
    private val titleDefaultText = "Title"
    private val noteDefaultText = "Note"
    private val saveDialog = onView(withId(android.R.id.message)).inRoot(isDialog())
    private val positiveButton = onView(withId(android.R.id.button1)).inRoot(isDialog())
    private val negativeButton = onView(withId(android.R.id.button2)).inRoot(isDialog())
    private val messageText = "Save changes?"
    private val positiveButtonText = "YES"
    private val negativeButtonText = "NO"
    private val menu = onView(ViewMatchers.withClassName(CoreMatchers.endsWith("ImageView")))

    fun checkTitle() {
        step("Проверить хинт заголовка \"{titleDefaultText}\"") {
            title.check(ViewAssertions.matches(ViewMatchers.withHint(titleDefaultText)))
        }
    }

    fun addNoteText(titleText: String, noteText: String) {
        step("В поля \"{titleDefaultText}\" и \"{noteDefaultText}\" ввести текст") {
            title.perform(replaceText(titleText))
            note.perform(replaceText(noteText))
        }
    }

    fun checkNote() {
        step("Проверить хинт текста \"{noteDefaultText}\"") {
            note.check(ViewAssertions.matches(ViewMatchers.withHint(noteDefaultText)))
        }
    }

    fun clickBackButton() {
        step("Нажать в тулбаре \"Назад\"") {
            backButton.perform(click())
        }
    }

    fun checkDialogMessageText() {
        step("Проверить текст \"{messageText}\"") {
            saveDialog.check(ViewAssertions.matches(withText(messageText)))
        }
    }

    fun checkButtonsText() {
        step("Проверить наличие двух кнопок \"{negativeButtonText}\", \"{positiveButtonText}\"") {
            positiveButton.check(ViewAssertions.matches(withText(positiveButtonText)))
            negativeButton.check(ViewAssertions.matches(withText(negativeButtonText)))
        }
    }

    fun clickNegativeButton() {
        step("Нажать \"{negativeButtonText}\"") {
            negativeButton.perform(click())
        }
    }

    fun clickPositiveButton() {
        step("Нажать \"{positiveButtonText}\"") {
            positiveButton.perform(click())
        }
    }

    fun checkCorrectText(titleText: String, noteText: String){
        step("Проверить, что текст введен корректно"){
            title.check(ViewAssertions.matches(ViewMatchers.withText(titleText)))
            note.check(ViewAssertions.matches(ViewMatchers.withText(noteText)))
        }
    }

    fun clickMenu(){
        step("Нажать \"Меню\""){
            menu.perform(click())
        }
    }
}