package org.pigsaw.listencoding

case class Encoding(num: Int, freq: Int) {

  override def toString = freq match {
    case 1 => num.toString
    case _ => s"($num,$freq)"
  }
}

object Encoding {

  def make(s: Seq[Int]): Seq[Encoding] = s.isEmpty match {
    case true => Seq()
    case false =>
      val num = s.head
      val freq = s.prefixLength(_ == num)
      val rest = s.drop(freq)
      Encoding(num, freq) +: make(rest)
  }
}
