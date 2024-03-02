package coding.pattern.cyclic.sort;

import java.util.*;

public class FindNMissingPositives {

    private static void swap(int [] nums, int i, int j) {
        int temp = nums[j];
        nums[j]  = nums[i];
        nums[i]  = temp;
    }

    public static List<Integer> missingPositives(int [] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int idx = nums[i] - 1;
            if (idx < 0 || idx >= nums.length) {
                i++;
            } else if (nums[i] != nums[idx]) {
                swap(nums, i, idx);
            } else {
                i++;
            }
        }

        Set<Integer> otherNumbers = new HashSet<>();
        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(i + 1);
                otherNumbers.add(nums[i]);
            }
        }

        for (int j = nums.length; result.size() < k; j++) {
            if(!otherNumbers.contains(j + 1)) {
                result.add(j + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(missingPositives(new int[]{-1,11,1,-3,2,8,4}, 5));

    }
}
