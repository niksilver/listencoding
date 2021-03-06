package org.pigsaw.listencoding

import org.scalatest.{FlatSpec, ShouldMatchers}

class EncodingTest extends FlatSpec with ShouldMatchers {

  "make" should "give single encodings if all different digits" in {
    val seq = Seq(5,6,7,8)
    Encoding.make(seq) should equal (Seq(Encoding(5,1), Encoding(6,1), Encoding(7,1), Encoding(8,1)))
  }

  it should "give a multiple encodings if it's one digit repeated" in {
    val seq = Seq(5,5,5,5)
    Encoding.make(seq) should equal (Seq(Encoding(5,4)))
  }

  it should "give repeat encodings for several repeated digits" in {
    val seq = Seq(5,5,6,6,6,5)
    Encoding.make(seq) should equal (Seq(Encoding(5,2), Encoding(6,3), Encoding(5,1)))
  }

  "toString" should "be nice for a repeat encoding" in {
    Encoding(3,4).toString should equal ("(3,4)")
  }

  it should "return a single digit for a single encoding" in {
    Encoding(3,1).toString should equal ("3")
  }
}
