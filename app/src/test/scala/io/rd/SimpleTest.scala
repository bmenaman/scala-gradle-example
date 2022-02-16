package io.rd

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class SimpleTest extends AnyFreeSpec with Matchers {
  "a test should" in {
    2 + 2 shouldBe 4
  }
}