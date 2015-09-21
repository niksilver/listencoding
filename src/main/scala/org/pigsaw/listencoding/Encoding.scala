package org.pigsaw.listencoding


case class Encoding(num: Int, freq: Int)

object Encoding {
  def of(s: Seq[Int]) =
    s map { Encoding(_, 1) }
}
