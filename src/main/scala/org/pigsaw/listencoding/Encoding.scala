package org.pigsaw.listencoding

import scala.annotation.tailrec

case class Encoding(num: Int, freq: Int) {

  override def toString = freq match {
    case 1 => num.toString
    case _ => s"($num,$freq)"
  }
}

object Encoding {

  def make(s: Seq[Int]): Seq[Encoding] = make(s, Nil)

  @tailrec
  private def make(s: Seq[Int], acc: Seq[Encoding]): Seq[Encoding] =
    s.isEmpty match {
      case true  => acc.reverse
      case false =>
        val num = s.head
        val freq = s.prefixLength(_ == num)
        val rest = s.drop(freq)
        make(rest, Encoding(num, freq) +: acc)
    }
}
