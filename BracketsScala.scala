import scala.annotation.tailrec

object BracketsScala {

  def main(args: Array[String]): Unit = {
    println("true", isBalanced(""))
    println("true", isBalanced("{[]}"))
    println("true", isBalanced("{[()()]}"))
    println("false", isBalanced("([)()]"))
    println("false", isBalanced("]"))
    println("false", isBalanced("{"))
  }

  def isBalanced(s: String): Boolean = {
    @tailrec def isBalancedList(l: List[Char], stack: List[Char]): Boolean = (l.isEmpty, stack.isEmpty) match {
      case (true, true) => true
      case (false, _) =>
        if (isOpen(l.head)) isBalancedList(l.tail, l.head :: stack)
        else if (stack.nonEmpty && isPair(stack.head, l.head)) isBalancedList(l.tail, stack.tail)
        else false
      case _ => false
    }

    def isOpen(c: Char): Boolean = c match {
      case '(' | '{' | '[' => true
      case _ => false
    }

    def isPair(a: Char, b: Char): Boolean = (a, b) match {
      case ('(', ')') | ('{', '}') | ('[', ']') => true
      case _ => false
    }

    isBalancedList(s.toCharArray.toList, List())
  }
}
