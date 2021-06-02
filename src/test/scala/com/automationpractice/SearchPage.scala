package com.automationpractice

import org.scalatest.flatspec.AnyFlatSpec

class SearchPage() extends AnyFlatSpec with OpenURL {
  private val page = new Search()

  "User" should "enter the correct request and press enter" in {

    page
      .inputText("T-shirts")
      .hasResult("Faded Short Sleeve T-shirts")

  }

  it should "enter an incorrect request and press enter" in {

    val searchName: String = "\"CREATE DATABASE myFalseDB;"
    val searchResult: String = s"\n\t\t\t\t\tNo results were found for your search \"${searchName}\"\n\t\t\t"

    page
      .inputText(searchName)
      .hasResult(searchResult)

  }
}
