package leet.code.top150.medium;

/*
    Ref - https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {
    /*
        nums = [1,2,3,4,5,6,7] k = 3
        steps -
            1. reverse the first half i.e. 0 to (len - k - 1)
                nums = [4,3,2,1,5,6,7] -> 0 to (7 - 3 - 1) = 3
            2. reverse the second half i.e (length - k , length - 1)
                nums = [4,3,2,1,7,6,5] -> 4 to 6
            3. reverse the complete array i.e. (0 to length - 1)
                nums = [5,6,7,1,2,3,4] -> 0 to 6
     */
    private void reverse(int [] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums.length < 2) return;

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length-1);
    }
}
