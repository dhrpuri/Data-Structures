package Problems;

import java.util.List;

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

        List<Integer> numList = List.of(4, -10);
        int minimumSubArrayResult = minimumSumSubarray(numList, 1, 1);
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
        for (int i = l; i <= r; i++) {
            int curSum = 0;
            for (int j = 0; j < i; j++) {
                curSum += nums.get(j);
            }
            if (curSum > 0) {
                min = Math.min(min, curSum);
            }
            int low = 0, high = i;
            while (high < nums.size()) {
                curSum -= nums.get(low);
                curSum += nums.get(high);
                low++;
                high++;
                if (curSum > 0) {
                    min = Math.min(min, curSum);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
