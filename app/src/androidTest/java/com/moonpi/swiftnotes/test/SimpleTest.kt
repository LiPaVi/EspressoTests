package com.moonpi.swiftnotes.test

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.R
import com.moonpi.swiftnotes.steps.MainPage
import com.moonpi.swiftnotes.rule.SwiftnotesRule
import com.moonpi.swiftnotes.steps.CreatePage
import org.hamcrest.CoreMatchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step

@RunWith(AndroidJUnit4::class)
@DisplayName("Создание заметки")
class SimpleTest : AbstractSwiftnotesTest() {

    @get:Rule
    val rule = SwiftnotesRule(MainActivity::class.java, false)

    lateinit var mainPage: MainPage
    lateinit var createPage: CreatePage

    @Before
    fun prepare() {
        rule.launchActivity()
        mainPage = MainPage()
        createPage = CreatePage()
    }

    @Test
    @DisplayName("Проверка открытия страницы создания")
    fun newNoteHints() {
        mainPage.clickPlusButton()
        createPage.checkTitle()
        createPage.checkNote()
        deviceScreenshot("page_display")
    }

    @Test
    @DisplayName("Проверка экрана создания заметки")
    fun createScreenTest() {
        mainPage.clickPlusButton()
        createPage.checkTitle()
        createPage.checkNote()
//        Нажать в тулбаре "Назад"
//        Появляется диалог. Проверить текст "Save changes?". Проверить наличие двух кнопок "No", "Yes".
//        Нажать "No"
//        Открылся главный экран (проверяем по текстовке в тулбаре)
        deviceScreenshot("main_page_display")
    }

    @Test
    @DisplayName("Проверка сохранения заметки")
    fun SaveNewNoteTest() {
        mainPage.clickPlusButton()
//        В поля "Title" и "Note" ввести текст
//        Проверить, что текст введен корректно
//        Нажать в тулбаре "Назад"
//        В диалоге нажать "Yes"
//        Открылся главный экран. Проверяем, что запись появилась (обе текстовки)
    }

    @Test
    @DisplayName("Проверка пунктов меню в тулбаре")
    fun MenuTest() {
//        Нажать "Меню"
//        Проверить отображение пунктов меню: "Backup notes", "Restore notes", "Rate app"
//        Нажать "+"
//        Нажать "Меню"
//        Проверить отображение пунктов меню: "Note font size", "Hide note body in list"
    }

    @Test
    @DisplayName("Проверка удаления заметки")
    fun DeleteNoteTest() {
        mainPage.clickPlusButton()
//        В поля "Title" и "Note" ввести текст
//        Нажать в тулбаре "Назад"
//        В диалоге нажать "Yes"
//        Лонг тап на заметку на главном экране
//        В тулбаре нажать "Удалить"
//        Проверяем отсутствие заметки на главном экране
    }
}
