package leet.code.top150.easy;

import java.util.Arrays;

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
        while(i <= j) {
            if(nums[j] == val) {
                j--;
            } else if (nums[i] == val) {
                nums[i++] = nums[j--];
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int [] nums = {0,1,2,2,3,0,4,2};
        int l = removeElement.removeElement(nums, 2);

        Arrays.stream(nums)
                .limit(l)
                .forEach(e -> System.out.print(e +" "));
    }
}
