package leet.code.top150.easy;

import java.util.ArrayList;
import java.util.List;

/*
    Ref - https://leetcode.com/problems/summary-ranges/
 */
public class SummaryChanges {

    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        List<String> result = new ArrayList<>();

        while (i < nums.length) {
            int j = i;
            while ((j + 1 < nums.length) && nums[j+1] - nums[j] == 1) {
                j++;
            }
            if (i == j) {               // one number
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(nums[i] +"->" +nums[j]);
            }
            i = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {0,1,2,4,5,7};
        SummaryChanges summaryChanges = new SummaryChanges();
        System.out.println(summaryChanges.summaryRanges(nums));
    }
}
