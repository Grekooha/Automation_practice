package com.automationpractice

import org.scalatest.flatspec.AnyFlatSpec

class CartPage() extends AnyFlatSpec with OpenURL {
  private val page = new Cart()

  "User" should "check the availability of information in the item" in {

    page
      .itemExist()

  }

  it should "press add to cart" in {
    page
      .addToCart()

  }

  "Checking" should "check info" in {

    page
      .checkingInfo()
      .closeAddWindow()

  }

  "User" should "press cart field" in {

    page
      .goToCart()

  }

  "Checking" should "check cart info" in {

    page
      .checkingCartInfo()

  }
}