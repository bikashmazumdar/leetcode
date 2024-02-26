package leet.code.top150.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Ref - https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    private List<Integer> getElementList(int[][] intervals, int i) {
        List<Integer> elements = new ArrayList<>();
        elements.add(intervals[i][0]);
        elements.add(intervals[i][1]);
        return elements;
    }
    private List<Integer> getElementList(int[][] intervals, int start, int end) {
        List<Integer> elements = new ArrayList<>();
        elements.add(start);
        elements.add(end);
        return elements;
    }


    /*
        steps:
            1. Sorted the intervals based on start
            2. Added the first interval in the list and performed comparison
            3. Used list because the intervals may merge multiple times
            4. if start of current interval is less than end of previous interval
                then we need to merge the intervals
                we should consider the minimum of start and max of end
                between two intervals
            5. finally, 2D array is formed to return the output.
     */
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<List<Integer>> result = new ArrayList<>();
        result.add(getElementList(intervals, 0));

        for (int i = 1; i < intervals.length; i++) {
            int size = result.size() - 1;

            if(result.get(size).get(1) <  intervals[i][0]) {
                result.add(getElementList(intervals, i));
            } else {
                int start = Math.min(result.get(size).get(0), intervals[i][0]);
                int end = Math.max(result.get(size).get(1), intervals[i][1]);
                result.set(size, getElementList(intervals, start, end));
            }
        }
        int [][] resultArray = new int[result.size()][2];
        for (int i = 0 ; i < result.size(); i++) {
            resultArray[i][0] = result.get(i).get(0);
            resultArray[i][1] = result.get(i).get(1);
        }
        return resultArray;
    }

    public int[][] mergeMethod2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int j = 0;
        for(int i = 1; i < intervals.length; i++) {
            if (result.get(j)[1] >= intervals[i][0]) {
                int [] updated = new int[] {result.get(j)[0], Math.max(intervals[i][1], result.get(j)[1])};
                result.set(j, updated);
            } else {
                result.add(intervals[i]);
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

    }
}
