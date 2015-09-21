package org.pigsaw.listencoding

import org.scalatest.{FlatSpec, ShouldMatchers}

class EncodingTest extends FlatSpec with ShouldMatchers {

  "of" should "give single encodings if all different digits" in {
    val seq = Seq(5,6,7,8)
    Encoding.of(seq) should equal (Seq(Encoding(5,1), Encoding(6,1), Encoding(7,1), Encoding(8,1)))
  }

  it should "give a multiple encodings if it's one digit repeated" in {
    val seq = Seq(5,5,5,5)
    Encoding.of(seq) should equal (Seq(Encoding(5,4)))
  }
}
