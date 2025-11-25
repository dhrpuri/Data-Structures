package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PalindromePermutation {

    public static void main(String[] args) {
        String s1 = "Tact Coa";
        System.out.println("Palindrome permutation  = " + isPalindromePermutation(s1));
    }

    public static boolean isPalindromePermutation(String str) {
        if (str == null || str.isEmpty()) return true;
        int charCount = 0;
        String s = str.toLowerCase().replace(" ", "");
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (char c : charMap.keySet()) {
            if (charMap.get(c) % 2 != 0) {
                charCount++;
            }
        }
        if (charCount == 1) {
            List<String> palindromeList = listPalindromes(s, charMap);
            palindromeList.forEach(System.out::println);
            return true;
        }
        return false;
    }

    public static List<String> listPalindromes(String s, Map<Character, Integer> charMap) {
        List<String> palindromeList = new ArrayList<>();
        char middleChar;
        for (char c : charMap.keySet()) {
            if (charMap.get(c) % 2 != 0) {
                middleChar = c;
                charMap.put(c, charMap.get(c) - 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        return palindromeList;
    }
}
