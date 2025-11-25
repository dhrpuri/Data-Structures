import java.util.*;
import java.util.Stack;

class arrayPractice {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        //System.out.println(isSubsequence(s,t));
        /*int[] arr = new int[]{-4, -3, -2, -1, 4, 3, 2};
		String str  = "leet**cod*e";
        System.out.println(removeStar(str));
        */
        /*arrayPractice arrayPractice = new arrayPractice();
        List<String> result = arrayPractice.fizzBuzz(1000);
        for(String str:result) {
            System.out.print(str + " ,");
        }
        */
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Length of LCS String : "+lcsStringLength(s1, s2));
        System.out.println(lcsString(s1, s2));

        arrayPractice ap  = new arrayPractice();
        ap.printOddEven(20);
    }

    public void printOddEven(int n){
        System.out.println("Even Numbers : ");
        for(int i = 1;i<=n;i++){
            if(i%2 == 0){
                System.out.println(i);
            }
        }
        System.out.println("Odd Numbers : ");
        for(int i = 1;i<=n;i++){
            if(i%2 != 0){
                System.out.println(i);
            }
        }
    }
    public static int lcsStringLength(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = buildDpMatrix(s1, s2);
        int index = dp[m][n];
        return index;
    }
    public static String lcsString(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = buildDpMatrix(s1, s2);
        int index = dp[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index + 1];
        lcs[index] = '\0'; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m, j = n;
        while (i > 0 && j > 0) {
            // If current character in s1 and s2 are same, then
            // current character is part of LCS
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[index - 1] = s1.charAt(i - 1);
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        // Convert the lcs character array to a string and return it
        return new String(lcs, 0, temp);
    }

    private static int[][] buildDpMatrix(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        // Create a 2D array to store lengths of longest common subsequence.
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp array in bottom-up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp;
    }
    public List<String> fizzBuzz(int n){
        List<String> result = new ArrayList<>();
        for(int i = 1;i<= n; i++){
            if(i%3 == 0 && i%5 == 0){result.add("FizzBuzz");}
            else if(i%3 == 0){result.add("Fizz");}
            else if(i%5 == 0){result.add("Buzz");}
            else {result.add(Integer.toString(i));}
        }
        return result;
    }

    public static String removeStar(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == '*'){stack.pop();}
			else{stack.push(s.charAt(i));}
		}
		for(char c:stack){sb.append(c);}
		return sb.toString();
    }

    public static boolean countOcc(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return set.stream().distinct().count() != set.size();
    }

    public static List<List<Integer>> findDiff(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : set1) {
            if (set2.contains(num)) {
                list1.add(num);
            }
        }
        for (int num : set2) {
            if (set1.contains(num)) {
                list2.add(num);
            }
        }
        answer.add(list1);
        answer.add(list2);
        return answer;
    }


    public static int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int zeros = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeros++;
            }
            end++;
            if (zeros > k) {
                if (nums[start] == 0) {
                    zeros--;
                }
                start++;
            }
        }
        return end - start;
    }

    public static int findMaxVowel(String str, int k) {
        int count = 0;
        for (char c : str.substring(0, k).toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }
        int maxCount = count;
        for (int i = k; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                count++;
            }
            if (isVowel(str.charAt(i - k))) {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static boolean isVowel(char ch) {
        String str = "aeiouAEIOU";
        return str.indexOf(ch) != -1;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode curNode = head.next;
        ListNode oddList = new ListNode(head.val), evenList = new ListNode(head.val);
        ListNode oddListHead = oddList;
        ListNode evenListHead = evenList;
        while (curNode != null) {
            ListNode newListNode = new ListNode(curNode.val);
            if (curNode.val % 2 == 0) {
                evenList.next = newListNode;
                evenList = newListNode;
            } else {
                oddList.next = newListNode;
                oddList = newListNode;
            }
            curNode = curNode.next;
        }
        oddList.next = evenListHead.next;
        return oddListHead;
    }


    public static ListNode deleteMiddleNode(ListNode head) {
        ListNode slow_ptr = head;
        ListNode fast_ptr = head.next;
        ListNode prevNode = head;
        ListNode nextNode = head;

        while (fast_ptr != null && fast_ptr.next != null) {
            // Move the fast pointer by two nodes
            fast_ptr = fast_ptr.next.next;
            // Move the slow pointer by one node
            slow_ptr = slow_ptr.next;
        }

        prevNode.next = nextNode;
        slow_ptr.next = null;

        return head;
    }

    public static int maxProduct(int[] inputArray) {
        if (inputArray.length == 2) return inputArray[0] * inputArray[1];
        int maxProduct = inputArray[0] * inputArray[1];
        for (int i = 1; i < inputArray.length; ) {
            if (i + 1 != inputArray.length) {
                maxProduct = Math.max(maxProduct, inputArray[i] * inputArray[i + 1]);
            }
            i++;
        }
        return maxProduct;
    }


    public static boolean checkPalindrome(String str) {
        if (str.length() == 1) return true;
        int low = 0, high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else return false;
        }
        return true;
    }

    public static int solution(int year) {
        int quotent = year / 100;
        System.out.println(quotent);
        int dividend = year % 100;
        System.out.println(dividend);
        int century = 0;
        if (quotent == 0) {
            century = 1;
        } else {
            if (dividend != 0) {
                century = quotent + 1;
            } else {
                century = quotent;
            }

        }
        return century;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode reverseList(ListNode head) {
        ListNode prevNode = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode curNode = new ListNode(head.val);
            curNode.next = prevNode;
            prevNode = curNode;
            head = head.next;
        }
        if (head.next == null) {
            ListNode tempNode = new ListNode(head.val);
            tempNode.next = prevNode;
            prevNode = tempNode;
        }
        return prevNode;
    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int guess(int num) {
        int result = 0;
        return result;
    }

    public static boolean isSubsequence(String s, String t) {
        Stack<Character> stack = new Stack<Character>();
        boolean isSub = false;
        if (s.isEmpty() || t.isEmpty()) {
            return true;
        }
        if (s.length() == t.length()) {
            return s.equals(t);
        }
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        char currentChar = stack.peek();
        for (int i = t.length() - 1; i >= 0; i--) {
            if (currentChar == t.charAt(i)) {
                stack.pop();
                if (stack.isEmpty()) {
                    return true;
                }
                currentChar = stack.peek();
            }
        }
        return stack.isEmpty();
    }

    //Log of pair of elements of the array
    public static void logarr() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        double result;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result = Math.log(arr[i]) / Math.log(arr[j]);
                System.out.println(result);
            }
        }
    }

    //Count the number of characters in the given string
    public static void strcount() {
        String str = "abcdef";
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        System.out.println(count);
    }
}

