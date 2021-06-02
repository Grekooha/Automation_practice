package com.automationpractice

import com.codeborne.selenide.Condition.{text, visible}
import com.codeborne.selenide.Selectors.{byClassName, byId, byTitle}
import com.codeborne.selenide.Selenide.$

class Cart {

  private val item = $(byClassName("product-container"))
  private val closeWindow = $(byTitle("Close window"))
  private val cartField = $(byTitle("View my shopping cart"))
  private val clickAddToCart = $(byTitle("Add to cart"))
  private val cssProductsName = $("#layer_cart_product_title")
  private val cssAttributes = $("#layer_cart_product_attributes")
  private val cssPrice = $("#layer_cart_product_price")
  private val cssPriceCart = $(byId("total_product"))

  val productsName : String = "Faded Short Sleeve T-shirts"
  val attributes : String = "Orange, S"
  val price : String = "$16.51"

  def itemExist(): Cart = {

    item
      .exists()

    this

  }

  def addToCart(): Cart ={

    item
      .hover()
    clickAddToCart
      .click()

    this

  }

  def closeAddWindow(): Cart={

    closeWindow
      .click()
    this

  }

  def goToCart(): Cart ={

    cartField
      .click()
    this

  }

  def checkingInfo(): Cart = {

    cssProductsName.waitUntil(visible, 30000).isEnabled
    cssProductsName.shouldHave(text("Faded Short Sleeve T-shirts"))
    cssAttributes.shouldHave(text("Orange, S"))
    cssPrice.shouldHave(text("$16.51"))
    this

  }

  def checkingCartInfo(): Cart = {

    cssPriceCart.shouldHave(text(price))
    this

  }
}
