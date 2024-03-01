package coding.pattern.cyclic.sort;

import java.util.Arrays;

public class CyclicSort {

    /*
        when to use cyclic sort
            - problem will say a range e.g. (0-N), (1-N)
     */

    public static void sort(int [] nums) {
        int i = 0;

        while (i < nums.length) {
            int correctIdx = nums[i] - 1;

            if(i != correctIdx) {
                int temp = nums[i];
                nums[i]  = nums[correctIdx];
                nums[correctIdx] = temp;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,4,3,5,2};
        sort(nums);
        Arrays.stream(nums).forEach(n -> System.out.println(n +" "));
    }
}
