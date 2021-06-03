package com.automationpractice

import org.scalatest.flatspec.AnyFlatSpec

class CartPage() extends AnyFlatSpec with OpenURL {

  val productsName : String = "Faded Short Sleeve T-shirts"
  val attributes : String = "Orange, S"
  val price : String = "$16.51"

  private val page = new Cart()

  "User" should "view product information, add to cart and check attributes." in {

    page
      .itemExist()
      .addToCart()
      .checkProductName(productsName)
      .checkAttributes(attributes)
      .checkPrice(price)
      .closeAddWindow()
      .goToCart()
      .checkCartInfo(price)

  }
}