package Problems;

class RemoveElement {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 2, 3};
        int[] result = removeElement(nums1, 3);
        for (int x : result) {
            System.out.println(x);
        }
    }

    public static void swapElements(int idx1, int idx2, int nums[]) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static int[] removeElement(int[] nums, int val) {
        int n = nums.length;

        int left = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                swapElements(left, right, nums);
                left++;
            }
        }

        return nums;

    }
}
