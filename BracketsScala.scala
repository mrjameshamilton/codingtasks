import scala.annotation.tailrec

object BracketsScala {

  @tailrec private def isBalanced(l: List[Char], stack: List[Char]): Boolean = (l.isEmpty, stack.isEmpty) match {
    case (true, true) => true
    case (false, _) =>
      if (isOpen(l.head)) isBalanced(l.tail, l.head :: stack)
      else if (stack.nonEmpty && isPair(stack.head, l.head)) isBalanced(l.tail, stack.tail)
      else false
    case _ => false
  }

  private def isOpen(c: Char): Boolean = c match {
    case '(' | '{' | '[' => true
    case _ => false
  }

  private def isPair(a: Char, b: Char): Boolean = (a, b) match {
    case ('(', ')') | ('{', '}') | ('[', ']') => true
    case _ => false
  }

  private def isBalanced(l: List[Char]): Boolean = isBalanced(l, List())

  def isBalanced(s: String): Boolean = isBalanced(s.toCharArray.toList)

  def main(args: Array[String]): Unit = {
    println("true", isBalanced(""))
    println("true", isBalanced("{[]}"))
    println("true", isBalanced("{[()()]}"))
    println("false", isBalanced("([)()]"))
    println("false", isBalanced("]"))
    println("false", isBalanced("{"))
  }
}
