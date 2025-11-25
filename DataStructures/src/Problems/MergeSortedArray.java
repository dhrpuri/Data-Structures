package Problems;

class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int[] result = mergeArray(nums1, 3, nums2, 3);
        for (int x : result) {
            System.out.println(x);
        }
    }

    private static int[] mergeArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int cur = m + n - 1;
        while (i >= 0 && j >= 0) {
            int a = nums1[i], b = nums2[j];
            if (a >= b) {
                nums1[cur] = a;
                i--;
            } else if (a < b) {
                nums1[cur] = b;
                j--;
            }
            cur--;
        }
        while (j >= 0) {
            int b = nums2[j];
            nums1[cur] = b;
            cur--;
            j--;
        }
        return nums1;
    }
}
