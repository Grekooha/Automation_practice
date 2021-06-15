package com.automationpractice

import com.codeborne.selenide.Condition.{text, visible}
import com.codeborne.selenide.Selectors.{byClassName, byId, byTitle, byXpath}
import com.codeborne.selenide.Selenide.{$, $$}

class Cart {

  private val items = $(byClassName("product-container"))
  private val closeWindow = $(byTitle("Close window"))
  private val cartField = $(byTitle("View my shopping cart"))
  private val addToCartButton = $$(byTitle("Add to cart"))
  private val productsName = $("#layer_cart_product_title")
  private val attributes = $("#layer_cart_product_attributes")
  private val price = $("#layer_cart_product_price")
  private val priceCart = $(byId("total_product"))
  private val allItem = $$(byClassName("product-container"))

  def itemsExist(): Cart = {

    items.exists()
    this

  }

  //  def addToCart(): Cart = {
  //
  //    item.hover()
  //    addToCartButton.click()
  //    this
  //
  //  }

  def closeAddWindow(): Cart = {

    closeWindow.click()
    this

  }

  def goToCart(): Cart = {

    cartField.click()
    this

  }

  def checkProductName(nameProductField: String): Cart = {

    productsName.waitUntil(visible, 30000).isEnabled
    productsName.shouldHave(text(nameProductField))
    this

  }

  def checkAttributes(attributesField: String): Cart = {

    attributes.shouldHave(text(attributesField))
    this

  }

  def checkPrice(priceField: String): Cart = {

    price.shouldHave(text(priceField))
    this

  }

  def checkCartInfo(price: String): Cart = {

    priceCart.shouldHave(text(price))
    this

  }

  def selectItem(selectItem: String): Cart = {

    allItem.find(text(selectItem)).hover()
    addToCartButton.find(text("Add to cart")).click()
    this

  }

}
