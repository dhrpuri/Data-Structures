package Problems;

import java.util.HashMap;
import java.util.Map;

class uniqueCharacterString {

    public static void main(String[] args) {
        String str = "qwertsssy";
        System.out.println("Has unique characters  = " + hasUniqueCharacters(str));
        System.out.println("Has unique characters with no extra DS  = " + isUnique(str));
    }

    public static boolean hasUniqueCharacters(String str) {
        if (str == null) {
            return true;
        }
        Map<Character, Boolean> visited = new HashMap<>();
        for (Character c : str.toCharArray()) {
            if (visited.get(c) != null)
                return false;
            visited.put(c, true);
        }
        return true;
    }

    public static boolean isUnique(String s) {
        if (s == null) {
            return true;
        }
        int currIndex = 0;
        for (int i = 1; i < s.length(); i++, currIndex++) {
            char curr = s.charAt(currIndex);
            if (curr == s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
