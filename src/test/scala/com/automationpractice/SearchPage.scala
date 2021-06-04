package com.automationpractice

import org.scalatest.flatspec.AnyFlatSpec

class SearchPage() extends AnyFlatSpec with OpenURL {

  val searchTextPositive: String = "T-shirts"
  val resultTextPositive: String = "Faded Short Sleeve T-shirts"
  val searchTextNegative: String = "\"CREATE DATABASE myFalseDB;"
  val searchResultNegative: String = s"\n\t\t\t\t\tNo results were found for your search \"${searchTextNegative}\"\n\t\t\t"
  val hasNotResult: String = "Blouse"

  private val page = new Search()

  "User" should "enter correct and incorrect request and press enter" in {

    page
      .inputText(searchTextPositive)
      .hasResult(resultTextPositive)
      .hasNotResult(hasNotResult)
      .inputText(searchTextNegative)
      .hasResult(searchResultNegative)

  }
}
