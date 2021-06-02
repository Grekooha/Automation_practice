package com.automationpractice

import com.codeborne.selenide.Selenide.$
import com.codeborne.selenide.Condition
import org.openqa.selenium.By

class Search {

  private val selectSearchField = $(By.id("center_column"))
  private val entryField = $(By.id("search_query_top"))

  def inputText(searchText: String): Search = {

    entryField
      .setValue(searchText)
      .pressEnter()
    this

  }

  def hasResult(assertHasResultText: String): Search = {

    selectSearchField
      .shouldHave(Condition.text(assertHasResultText))
      .shouldBe(Condition.visible)
    this

  }
}