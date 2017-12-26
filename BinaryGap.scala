import java.lang.Integer.toBinaryString

import scala.annotation.tailrec

/**
  * A binary gap in integer N >= 0 is a
  * maximal sequence of consecutive 0s surrounded
  * by 1s in the binary representation of N
  */
object BinaryGap {

  def solution(n: Int): Int =
    solution(toBinaryString(n).toCharArray.toList, 0, 0)

  @tailrec def solution(bits: List[Char], acc: Int, max: Int): Int = bits match {
    case Nil => max
    case _ :: '0' :: _ => solution(bits.tail, acc + 1, max) //start (10..) or keep (00..) counting
    case '0' :: '1' :: _ => solution(bits.tail, 0, Math.max(max, acc)) //stop counting
    case _ => solution(bits.tail, 0, max) //continue
  }

  def main(args: Array[String]): Unit = {
    println(5, solution(1041))
    println(4, solution(529))
    println(1, solution(20))
    println(0, solution(15))
    println(2, solution(51712))
  }
}
