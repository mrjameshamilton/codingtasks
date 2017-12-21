import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterPermutations {

    //given a string with unique characters,
    //return all permutations of those characters
    //do it recursively
    private static List<String> solution(String s) {
        if (s.length() == 1) {
            return Collections.singletonList(s);
        }

        List<String> result = new ArrayList<>();

        for (char c : s.toCharArray()) {
            for (String x : solution(s.replace(""+c, ""))) {
                result.add(c + x);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABC"));
    }
}
