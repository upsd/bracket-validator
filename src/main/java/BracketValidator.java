import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketValidator {

    private final Map<Character, Character> bracketPairs;

    public BracketValidator() {
        bracketPairs = new HashMap<>();

        bracketPairs.put('{', '}');
        bracketPairs.put('[', ']');
        bracketPairs.put('(', ')');
    }

    public Bracket validate(String input) {
        Stack<Character> brackets = new Stack<>();


        for (char c : input.toCharArray()){
            if (isOpeningBracket(c)) {
                brackets.push(c);
            }
            if (isClosingBracket(c)) {
                if (!brackets.empty() && brackets.peek() == getOpeningBracketOf(c)) {
                    brackets.pop();
                } else {
                    return Bracket.INVALID;
                }
            }
        }

        return brackets.size() != 0 ? Bracket.INVALID : Bracket.VALID;
    }

    private boolean isClosingBracket(char c) {
        return bracketPairs.containsValue(c);
    }

    private boolean isOpeningBracket(char c) {
        return bracketPairs.containsKey(c);
    }

    private char getOpeningBracketOf(char bracket) {
        return bracketPairs.entrySet().stream()
                .filter(entry -> entry.getValue() == bracket)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
    }
}
