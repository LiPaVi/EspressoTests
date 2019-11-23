package com.moonpi.swiftnotes.steps

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import com.moonpi.swiftnotes.R
import org.hamcrest.CoreMatchers
import ru.tinkoff.allure.step

class CreatePage {
    private val title = Espresso.onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.titleEdit), ViewMatchers.isDisplayed()))
    private val note = Espresso.onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.bodyEdit), ViewMatchers.isDisplayed()))
    private val titleDefaultText = "Title"
    private val noteDefaultText = "Note"

    fun checkTitle(){
        step("Проверить хинт заголовка \"{titleDefaultText}\"") {
            title.check(ViewAssertions.matches(ViewMatchers.withHint(titleDefaultText)))
        }
    }

    fun checkNote() {
        step("Проверить хинт текста \"{noteDefaultText}\"") {
            note.check(ViewAssertions.matches(ViewMatchers.withHint(noteDefaultText)))
        }
    }

    fun clickBackButton() {
        step("Нажать в тулбаре \"Назад\""){
            //TODO
        }
    }
}