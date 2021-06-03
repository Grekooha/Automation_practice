package com.automationpractice
import org.scalatest.{BeforeAndAfterAll, Suite}
import com.codeborne.selenide.Selenide.open

trait OpenURL extends Suite with BeforeAndAfterAll {

  private val url: String = "http://www.automationpractice.com"

  override def beforeAll: Unit = {
    open(url)

  }
}
