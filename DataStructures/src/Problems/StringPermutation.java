package Problems;

import java.util.HashMap;
import java.util.Map;

class StringPermutation {
    public static void main(String[] args) {
        String s1 = "1233";
        String s2 = "";
        System.out.println("is permutation  = " + isPermutation(s1, s2));
    }

    public static boolean isPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.isEmpty() || s2.isEmpty()) return true;
        Map<Character, Integer> characterMap = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : s2.toCharArray()) {
            if (characterMap.get(c) == null || characterMap.get(c) <= 0) {
                return false;
            }
            characterMap.put(c, characterMap.get(c) - 1);
        }
        return true;
    }
}
