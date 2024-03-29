package leet.code.top150.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
Description:
    - Used counting sort technique
    - Stored the count of each elements in a map
    - LinkedHashMap is used to maintain the order
    - While putting the elements in the array, I am considering the
    - elemement upto 2, that is the reason Math.min function is used
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int n : nums) {
            int v = map.getOrDefault(n, 0) + 1;
            map.put(n, v);
        }
        int k = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for(int i = 0; i < Math.min(entry.getValue(), 2); i++) {
                nums[k++] = entry.getKey();
            }
        }
        return k;
    }

    public int removeElementSpaceOptimized(int [] nums) {
        int count = 1;
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }

            if (count < 3) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
