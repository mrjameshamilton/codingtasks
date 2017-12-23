import java.util.Stack;

class Brackets {

    /**
     * Are brackets in the string balanced? String can contain ()[]{}.
     *
     * @param S the string
     *
     * @return returns 1 if brackets are balanced, 0 otherwise.
     */
    public static int solution(String S) {
        if (S.length() == 0) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.size() > 0) {
                    if (!isPair(stack.pop(), c)) {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

    private static boolean isOpen(char a) {
        return a == '(' || a == '[' || a == '{';
    }

    private static boolean isPair(char a, char b) {
        return (a == '(' && b == ')')
                || (a == '[' && b == ']')
                || (a == '{' && b == '}');
    }

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}") + ", " + 1);
        System.out.println(solution( "([)()]") + ", " + 0);
    }
}

