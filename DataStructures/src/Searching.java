import java.util.Arrays;

public class Searching {

    static void main(String[] args) {

        int[] binarySearchNums = {2,4,6,9,11,12,14,20,36,48};
        int indexOfElement = binarySearch(binarySearchNums,36);
        System.out.println("Binary Search - element found at index: " + indexOfElement);

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
    }}
