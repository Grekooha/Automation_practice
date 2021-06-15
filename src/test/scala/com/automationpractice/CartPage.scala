package com.automationpractice

import org.scalatest.flatspec.AnyFlatSpec

class CartPage() extends AnyFlatSpec with OpenURL {

  val productsName: String = "Printed Dress"
  val attributes: String = "Orange, S"
  val price: String = "$26.00"

  private val page = new Cart()

  "User" should "view product information, add to cart and check attributes." in {

    page
      .itemsExist()
      .selectItem("\t\t\t\t\t\t\tPrinted Dress\n\t\t\t\t\t\t")
      .checkProductName(productsName)
      .closeAddWindow()
      .goToCart()
      .checkCartInfo(price)
  }
}