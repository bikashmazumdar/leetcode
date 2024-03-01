package coding.pattern.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class FindCorruptPair {

    /*
        Refs -
            1. https://leetcode.com/problems/set-mismatch/
            2. https://thecodingsimplified.com/find-currupt-pair/

     */
    private void swap(int [] nums, int i, int j) {
        int temp = nums[j];
        nums[j]  = nums[i];
        nums[i]  = temp;
    }

    public List<Integer> corruptPair(int [] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int idx = nums[i] - 1;

            if (nums[i] != nums[idx]) {
                swap(nums, i, idx);
            } else {
                i++;
            }
        }

        /* After sorting the corrupted number will be in missing number's place */
        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(i + 1);
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindCorruptPair findCorruptPair = new FindCorruptPair();
        System.out.println(findCorruptPair.corruptPair(new int[] {4,3,4,5,1}));
    }
}
