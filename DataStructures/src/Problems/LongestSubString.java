package Problems;

import java.util.HashSet;
import java.util.Set;

class LongestSubString {
    public static void main(String[] args) {
        String s = "abcbacbb";
        System.out.println("result = " + longestSubStringLength(s));
        System.out.println("result = " + longestSubString(s));

        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println("Max average in array = " + findMaxAverage(nums, 4));
    }

    public static int longestSubStringLength(String s) {
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);

            for (int i = left; i < right; i++) {
                if (s.charAt(i) == c) {
                    left = i + 1;
                    break;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    public static String longestSubString(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0, max = 0, curMax = 0, maxLeft = 0, maxRight = 0;
        for (; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (window.contains(ch)) {
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
            if (max != curMax) {
                curMax = max;
                maxLeft = left;
                maxRight = right;
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int left = 0, right = k - 1;
        double max = Integer.MIN_VALUE, avg, sum = 0;
        for (int i = 0; i < right; i++) {
            sum = sum + nums[i];
        }

        while (right < nums.length) {
            sum = sum + nums[right];
            max = Math.max(max, sum);
            sum = sum - nums[left];
            left++;
            right++;
        }
        return max / k;
    }
}
