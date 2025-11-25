package Problems;

import java.util.Arrays;

class FindFirstPalindrome {
    public static void main(String[] args) {
//        String[] words = {"abc","car","ada","racecar","cool"};
//        System.out.println(firstPalindrome(words));


        System.out.println(isIntegerPalindrome(10));


    }

    public static String firstPalindrome(String[] words) {
        return Arrays.stream(words).filter(FindFirstPalindrome::isPalindrome).findFirst().orElse(null);
    }

    public static boolean isPalindrome(String s) {
        char[] charArray = s.replace("[^a-ZA-Z0-9]", "").toLowerCase().toCharArray();
        int start = 0, end = charArray.length - 1;
        while (start < end) {
            if (charArray[start] == charArray[end]) {
                start++;
                end--;
            } else
                return false;

        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1, false);
    }

    public static boolean isPalindrome(final String s, int leftIndex, int rightIndex, final boolean isCharacterDeleted) {

        while (leftIndex < rightIndex) {

            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {

                if (isCharacterDeleted) {
                    return false;
                }
                return isPalindrome(s, leftIndex + 1, rightIndex, true) || isPalindrome(s, leftIndex, rightIndex - 1, true);
            }

            ++leftIndex;
            --rightIndex;

        }

        return true;
    }

    public static boolean isIntegerPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) (temp % 10);
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return (reversed == x);
    }
}
