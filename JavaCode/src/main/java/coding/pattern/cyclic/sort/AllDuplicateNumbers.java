package coding.pattern.cyclic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllDuplicateNumbers {

    private void swap(int [] nums, int i, int j) {
        int temp = nums[j];
        nums[j]  = nums[i];
        nums[i]  = temp;
    }

    public List<Integer> allDuplicates(int [] nums) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int idx = nums[i] - 1;

            if(nums[i] != nums[idx]) {
                swap(nums, i, idx);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        //Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        AllDuplicateNumbers duplicateNumbers = new AllDuplicateNumbers();
        System.out.println(duplicateNumbers.allDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }
}
