package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = merge(intervals);
        System.out.println(Arrays.deepToString(merged));
    }

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        for(int[] cur:intervals){
            if(res.isEmpty() || res.get(res.size()-1)[1] <cur[0]){
                res.add(new int[]{cur[0],cur[1]});
            }
            else{
                int[] last = res.get(res.size()-1);
                last[1] = Math.max(last[1],cur[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
