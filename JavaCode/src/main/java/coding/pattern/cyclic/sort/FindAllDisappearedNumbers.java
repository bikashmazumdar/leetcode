package coding.pattern.cyclic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Ref - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int idx = nums[i] - 1;
            if (idx < nums.length && nums[i] != nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if(nums[i] != (i+1)) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDisappearedNumbers fad =  new FindAllDisappearedNumbers();
        System.out.println(fad.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
