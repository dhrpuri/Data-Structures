import java.util.*;

class arrayPractice{
	//Log of pair of elements of the array
	   public static void logarr(){
	    int [] arr = new int[] {1,2,3,4,5};
	    double result;
	    for(int i = 0; i<arr.length;i++){
	      for(int j = 0;j<arr.length;j++){
	        result = Math.log(arr[i])/Math.log(arr[j]);
	        System.out.println(result);
	      }
	    }
	  }
	//Count the number of characters in the given string
	  public static void strcount(){
	    String str = "abcdef";
	    int count = 0;
	    for (char c : str.toCharArray()){
	      count++;
	    }
	    System.out.println(count);
	  }
	}

class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int[] result = mergeArray(nums1,3,nums2,3);
        for(int x:result){
            System.out.println(x);
        }
    }

    private static int[] mergeArray(int[] nums1, int m, int[] nums2,int n){
        int i = m-1; int j = n-1; int cur = m+n-1;
        while(i>=0 && j>=0){
            int a = nums1[i],b = nums2[j];
            if(a>=b){
                nums1[cur] = a;
                i--;
            }
            else if(a<b) {
                nums1[cur] = b;
                j--;
            }
            cur--;
        }
        while(j>=0){
            int b = nums2[j];
            nums1[cur] = b;
            cur--;j--;
        }
        return nums1;
    }
}

class RemoveElement {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,2,3};
        int[] result = removeElement(nums1,3);
        for(int x:result){
            System.out.println(x);
        }
    }

    public static void swapElements(int idx1, int idx2, int nums[]){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public static int[] removeElement(int[] nums, int val) {
        int n = nums.length;

        int left = 0;

        for(int right = 0 ; right < n ; right++){
            if(nums[right] != val){
                swapElements(left, right, nums);
                left++;
            }
        }

        return nums;

    }
}

class RemoveDuplicates {

    public static void main(String[] args) {
//        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums2 = new int[]{0,0,1,1,1,1,2,3,3};
//        int result = removeDuplicates(nums);
//        System.out.println("result : " + result);
//        int result2 = removeDuplicatesII(nums2);
//        System.out.println("result : " + result2);
//        for (int j : nums) {
//            System.out.println(j);
//        }


        List<Integer> numList = List.of(4,-10);
        int minimumSubArrayResult = minimumSumSubarray(numList,1,1);
        System.out.println(minimumSubArrayResult);

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static int removeDuplicatesII(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        for(int i = l;i<=r;i++){
            int curSum = 0;
            for(int j =0;j<i;j++){
                curSum += nums.get(j);
            }
            if(curSum>0){min = Math.min(min,curSum);}
            int low = 0, high = i;
            while(high<nums.size()){
                curSum-= nums.get(low);
                curSum+= nums.get(high);
                low++;high++;
                if(curSum>0){min = Math.min(min,curSum);}
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}
class uniqueCharacterString{

    public static void main(String[] args){
        String str = "qwertsssy";
        System.out.println("Has unique characters  = " + hasUniqueCharacters(str));
        System.out.println("Has unique characters with no extra DS  = " + isUnique(str));
    }

    public static boolean hasUniqueCharacters(String str){
        if(str ==null){return true;}
        Map<Character,Boolean> visited = new HashMap<>();
        for(Character c : str.toCharArray()){
            if(visited.get(c)!=null)
                return false;
            visited.put(c,true);
        }
        return true;
    }
    public static boolean isUnique(String s){
        if(s == null){return true;}
        int currIndex = 0;
        for(int i = 1;i<s.length();i++,currIndex++){
            char curr = s.charAt(currIndex);
            if(curr == s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}

class StringPermutation{
    public static void main(String[] args){
        String s1 = "1233";
        String s2 = "";
        System.out.println("is permutation  = " + isPermutation(s1,s2));
    }

    public static boolean isPermutation(String s1, String s2){
        if(s1 == null || s2 == null) return false;
        if(s1.isEmpty() || s2.isEmpty()) return true;
        Map<Character,Integer> characterMap = new HashMap<>();
        for(Character c: s1.toCharArray()){
            characterMap.put(c,characterMap.getOrDefault(c,0)+1);
        }
        for(Character c:s2.toCharArray()){
            if(characterMap.get(c) == null || characterMap.get(c) <=0){
                return false;
            }
            characterMap.put(c, characterMap.get(c) -1);
        }
        return true;
    }
}

class UrlFy{
    public static void main(String[] args){
        String s1 = "null null";
        System.out.println("urlfy  = " + urlfy(s1));
    }

    public static String urlfy(String str){
        if(str == null){return "";}
        StringBuilder strBuilder = new StringBuilder();
        String[] strArray = str.split(" ");
        for(int i =0; i<strArray.length;i++){
            strBuilder.append(strArray[i]);
            if(i!=strArray.length-1){
                strBuilder.append("%20");
            }
        }
        return strBuilder.toString();
    }
}

class PalindromePermutation{

    public static void main(String[] args){
        String s1 = "Tact Coa";
        System.out.println("Palindrome permutation  = " + isPalindromePermutation(s1));
    }

    public static boolean isPalindromePermutation(String str){
        if(str == null || str.isEmpty()) return true;
        int charCount = 0;
        String s = str.toLowerCase().replace(" ","");
        Map<Character,Integer> charMap = new HashMap<>();
        for(char c: s.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }
        for(char c:charMap.keySet()){
            if(charMap.get(c)%2 != 0){
                charCount++;
            }
        }
        if(charCount == 1){
            List<String> palindromeList = listPalindromes(s,charMap);
            palindromeList.forEach(System.out::println);
            return true;
        }
        return false;
    }

    public static List<String> listPalindromes(String s, Map<Character,Integer> charMap){
        List<String> palindromeList = new ArrayList<>();
        char middleChar;
        for(char c:charMap.keySet()){
            if(charMap.get(c)%2 != 0){
                middleChar = c;
                charMap.put(c, charMap.get(c)-1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        
        return palindromeList;
    }
}

class LongestSubString{
    public static void main(String[] args){
        String s = "abcbacbb";
        System.out.println("result = " + longestSubStringLength(s));
        System.out.println("result = " + longestSubString(s));

        int[] nums = {1,12,-5,-6,50,3};
        System.out.println("Max average in array = " + findMaxAverage(nums,4));
    }
    public static int longestSubStringLength(String s){
        int left = 0, right = 0 , max = 0;
        while(right<s.length()){
            char c = s.charAt(right);

            for(int i = left;i<right;i++){
                if(s.charAt(i) == c){
                    left = i+1;
                    break;
                }
            }
            max = Math.max(max, right-left+1);
            right++;
        }

        return max;
    }

    public static String longestSubString(String s){
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0, max =0, curMax = 0, maxLeft = 0, maxRight = 0;
        for(;right<s.length();right++){
            char ch = s.charAt(right);
            while(window.contains(ch)){
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            max = Math.max(max, right-left+1);
            if(max!=curMax){
                curMax = max;
                maxLeft = left;
                maxRight = right;
            }
        }
        return s.substring(maxLeft,maxRight+1);
    }

    public static double findMaxAverage(int[] nums, int k) {
       int left = 0, right = k-1;
       double max = Integer.MIN_VALUE,avg,sum = 0;
       for(int i = 0;i<right;i++){
           sum = sum +nums[i];
       }

       while(right<nums.length){
           sum =sum+nums[right];
           max= Math.max(max,sum);
           sum = sum -nums[left];
           left++; right++;
       }
       return max/k;
    }
}

class FindFirstPalindrome{
    public static void main(String[] args) {
//        String[] words = {"abc","car","ada","racecar","cool"};
//        System.out.println(firstPalindrome(words));


        System.out.println(isIntegerPalindrome(10));


    }

    public static String firstPalindrome(String[] words){
        return Arrays.stream(words).filter(FindFirstPalindrome::isPalindrome).findFirst().orElse(null);
    }

    public static boolean isPalindrome(String s){
        char[] charArray = s.replace("[^a-ZA-Z0-9]","").toLowerCase().toCharArray();
        int start = 0 , end = charArray.length - 1;
        while(start<end){
            if(charArray[start] == charArray[end]){
                start++;end--;
            }
            else
                return false;

        }
        return true;
    }

    public static boolean validPalindrome(String s){
        return isPalindrome(s, 0, s.length() - 1, false);
    }
    public static boolean isPalindrome(final String s, int leftIndex, int rightIndex, final boolean isCharacterDeleted){

        while(leftIndex < rightIndex){

            if(s.charAt(leftIndex) != s.charAt(rightIndex)){

                if(isCharacterDeleted){
                    return false;
                }
                return isPalindrome(s, leftIndex + 1, rightIndex, true) || isPalindrome(s, leftIndex, rightIndex - 1, true);
            }

            ++leftIndex;
            --rightIndex;

        }

        return true;
    }

    public static boolean isIntegerPalindrome(int x){
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

class SortingAndSearching{
    public static void main(String[] args) {
        int[] nums = {2,4,6,9,11, 12,14,20,36,48};
        System.out.println(binarySearch(nums,1));
    }

    public static void bubbleSort(int[] nums){
        int len = nums.length;
        for(int i = 0;i<len-1;i++){
            for(int j = 1; j<len;j++){
               //
            }
        }
    }

    public static int binarySearch(int[] nums, int target){
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        return binarySearch(nums, start, end,target);

    }
    private static int binarySearch(int[] nums, int start, int end,int target){
        int middle = start + (end -start)/2;
        if(start > end) return -1;
        if(nums[middle]> target) return binarySearch(nums, start, middle -1 , target);
        else if(nums[middle]< target){return binarySearch(nums, middle +1 ,end,target);}
        else return middle;
    }
}