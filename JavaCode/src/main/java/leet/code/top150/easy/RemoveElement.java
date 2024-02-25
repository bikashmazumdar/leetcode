package leet.code.top150.easy;

/*
https://leetcode.com/problems/remove-element/
- I have used two pointer approach
- i from 0 and j - from end
- increment i if nums[i] not val
- decrement j if num[j] == val
- if nums[i] == val the copy num[j], incr i and dec j to move to the next
- i <= j is required to handle edge cases, e.g. nums[] = {1} , val = 1
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        int k = 0;

        while (i <= j) {
            if(nums[j] == val) {
                j--;
                k++;
            }  else if (nums[i] == val) {
                nums[i++] = nums[j--];
                k++;
            } else {
                i++;
            }
        }
        return nums.length - k;
    }
}
