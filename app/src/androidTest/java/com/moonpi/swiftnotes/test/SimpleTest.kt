package com.moonpi.swiftnotes.test

import android.support.test.espresso.Espresso.pressBack
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.rule.SwiftnotesRule
import com.moonpi.swiftnotes.steps.CreatePage
import com.moonpi.swiftnotes.steps.MainPage
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName

@RunWith(AndroidJUnit4::class)
@DisplayName("Создание заметки")
class SimpleTest : AbstractSwiftnotesTest() {

    private val titleText = "Заметка № 1"
    private val noteText = "Hello, world!"

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
    }

    @Test
    @DisplayName("Проверка экрана создания заметки")
    fun createScreenTest() {
        mainPage.clickPlusButton()
        createPage.checkTitle()
        createPage.checkNote()
        createPage.clickBackButton()
        createPage.checkDialogMessageText()
        createPage.checkButtonsText()
        createPage.clickNegativeButton()
        mainPage.checkToolbarTitle()
    }

    @Test
    @DisplayName("Проверка сохранения заметки")
    fun saveNewNoteTest() {
        mainPage.clickPlusButton()
        createPage.addNoteText(titleText, noteText)
        createPage.checkCorrectText(titleText, noteText)
        createPage.clickBackButton()
        createPage.clickPositiveButton()
        mainPage.checkNoteText(titleText, noteText)
    }

    @Test
    @DisplayName("Проверка пунктов меню в тулбаре")
    fun menuTest() {
        mainPage.clickMenu()
        mainPage.checkMenu()
        pressBack()
        mainPage.clickPlusButton()
        createPage.clickMenu()
        createPage.checkMenu()
    }

    @Test
    @DisplayName("Проверка удаления заметки")
    fun deleteNoteTest() {
        mainPage.clickPlusButton()
        createPage.addNoteText(titleText, noteText)
        createPage.clickBackButton()
        createPage.clickPositiveButton()
        mainPage.longClickToNote()
        mainPage.deleteNote()
        mainPage.checkDeletedNote()
    }
}
