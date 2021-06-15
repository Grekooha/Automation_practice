package com.automationpractice

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.$
import org.openqa.selenium.By

class Search {

  private val searchField = $(By.id("center_column"))
  private val entryField = $(By.id("search_query_top"))

  def inputText(searchText: String): Search = {

    entryField
      .setValue(searchText)
      .pressEnter()
    this

  }

  def hasNotResult(assertHasNotResult: String): Search = {

    searchField
      .shouldNotHave(Condition.text(assertHasNotResult))
    this

  }

  def hasResult(assertHasResultText: String): Search = {

    searchField
      .shouldHave(Condition.text(assertHasResultText))
      .shouldBe(Condition.visible)
    this

  }
}