package Problems;

public class FindDuplicateNumber {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,7,5,6,7};
        int[] nums2 = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate(nums2));
    }

    /**
     * Floyd’s (Cycle Detection) algorithm applied to find the duplicate number in the array.
     * Array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     * There is only one repeated number in nums, return this repeated number.
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        // Step 1: Find intersection
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Step 2: Find cycle entry
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
