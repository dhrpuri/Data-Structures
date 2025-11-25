import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {

        int[] bubbleSortNums = {5,4,3,2,1};
        bubbleSort(bubbleSortNums);
        System.out.println("Bubble Sort: "+ Arrays.toString(bubbleSortNums));

        int[] selectionSortNums = {5,4,3,2,1};
        selectionSort(selectionSortNums);
        System.out.println("Selection Sort: "+Arrays.toString(selectionSortNums));

        int[] insertionSortNums = {5,4,3,2,1};
        insertionSort(insertionSortNums);
        System.out.println("Insertion Sort: "+Arrays.toString(insertionSortNums));

        int[] mergeSortNums = {5,4,3,2,1};
        int[] sorted = mergeSortRecursive(mergeSortNums);
        System.out.println("Merge Sort Recursive: "+Arrays.toString(sorted));

        mergeSortInPlace(mergeSortNums,0,mergeSortNums.length);
        System.out.println("Merge sort In-place: " + Arrays.toString(mergeSortNums));

        int[] quickSortNums = {5,4,3,2,1};
        quickSort(quickSortNums,0,quickSortNums.length-1);
        System.out.println("Quick Sort : "+ Arrays.toString(quickSortNums));

    }

    public static void bubbleSort(int[] nums){
        int len = nums.length;boolean swapped = false;
        for(int i = 0;i<len;i++){
            for(int j = 1; j<len -i;j++){
                if(nums[j-1]>nums[j]){
                    swapElements(nums,j,j-1);
                    swapped =true;
                }
            }
            if(!swapped){
                return;
            }
        }
    }

    public static void selectionSort(int[] nums){
        int len = nums.length;
        for(int i = 0;i<len;i++){
            int last = len -i -1;
            int  maxIndex = 0;
            for(int j = 1; j<len-i;j++){
                if(nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
            }
            swapElements(nums,maxIndex,last);
        }
    }

    public static void insertionSort(int[] nums){
        int len = nums.length;
        for(int i = 0;i<len-1;i++){
            for(int j = i+1; j>0;j--){
                if(nums[j-1] > nums[j]) {
                    swapElements(nums,j,j-1);
                }
                else return;
            }
        }
    }

    //In-place Merge sort:Time complexity: O(n Log n) Space complexity: O(1)
    public static void mergeSortInPlace(int[] nums,int start, int end){
        if(end - start == 1) return;
        int mid = start + (end - start)/2;
        mergeSortInPlace(nums, start, mid);
        mergeSortInPlace(nums, mid, end);
        mergeInPlace(nums, start, mid, end);
    }

    private static void mergeInPlace(int[] nums, int start, int mid, int end) {
        int[] mix = new int[end-start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i<mid && j<end){
            if(nums[i] < nums[j]){
                mix[k] = nums[i];
                i++;k++;
            }
            else{
                mix[k] = nums[j];
                j++;k++;
            }
        }
        while(i<mid){
            mix[k] = nums[i];
            i++;k++;
        }
        while(j<end){
            mix[k] = nums[j];
            j++;k++;
        }

        System.arraycopy(mix, 0, nums, start, mix.length);
    }

    //Recursive merge sort: Time complexity: O(n Log n) Space complexity: O(n)
    public static int[] mergeSortRecursive(int[] nums){
        if(nums.length == 1) return nums;

        int mid = nums.length/2;
        int[] left = mergeSortRecursive(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSortRecursive(Arrays.copyOfRange(nums,mid,nums.length));

        return mergeRecursive(left,right);
    }

    private static int[] mergeRecursive(int[] first , int[] second) {
        int[] mix = new int[first.length+ second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<first.length && j<second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;k++;
            }
            else{
                mix[k] = second[j];
                j++;k++;
            }
        }
        while(i<first.length){
            mix[k] = first[i];
            i++;k++;
        }
        while(j<second.length){
            mix[k] = second[j];
            j++;k++;
        }
        return mix;
    }

    public static void quickSort(int[] nums, int low, int high){
        if(low>=high){
            return;
        }

        int s = low;
        int e = high;
        int m = s+(e-s)/2;//selection of pivot
        int pivot = nums[m];

        while(s <= e){
            //if it is already sorted it won't swap
            //Both start and end to move where the element is not sorted and needs to be swapped.
            while(nums[s] < pivot){
                s++;
            }
            while(nums[e] > pivot){
                e--;
            }

            if(s <= e){
                swapElements(nums,s,e);
                s++;
                e--;
            }
        }
        //pivot is at right position now, we sort the two halves of the array
        quickSort(nums,low,e);
        quickSort(nums,s,high);
    }


    private static void swapElements(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }


}