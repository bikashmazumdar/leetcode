package coding.pattern.cyclic.sort;

/*
    Ref - https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicateNumber {

    private void swap(int [] nums, int i, int j) {
        int temp = nums[j];
        nums[j]  = nums[i];
        nums[i]  = temp;
    }
    public int findDuplicate(int [] nums) {
        int i = 0;

        while (i < nums.length) {
            int idx = nums[i] - 1;

            if(nums[i] == nums[idx] && i != idx) {
                return nums[i];
            } else if (nums[i] != nums[idx]) {
                swap(nums, i, idx);
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDuplicateNumber duplicateNumber = new FindDuplicateNumber();
        System.out.println(duplicateNumber.findDuplicate(new int[] {1,3,4,2,2}));
        System.out.println(duplicateNumber.findDuplicate(new int[] {3,1,3,4,2}));
    }
}
