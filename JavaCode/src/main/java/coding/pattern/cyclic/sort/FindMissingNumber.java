package coding.pattern.cyclic.sort;

/*
    https://leetcode.com/problems/missing-number/
 */
public class FindMissingNumber {

    private void swap(int [] nums, int i, int j) {
        int temp = nums[j];
        nums[j]  = nums[i];
        nums[i]  = temp;
    }
    public int missingNumber(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int idx = nums[i];

            if (idx >= nums.length) {
                i++;
            } else if (nums[i] != nums[idx]){
                swap(nums, i, idx);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i) return i;
        }
        return nums.length;
    }

    public int findMissingOptimized(int [] nums) {
        int i = 0, mIdx = nums.length;
        while (i < nums.length) {
            int idx = nums[i];

            if (idx >= nums.length) {
                mIdx = i;
                i++;
            } else if (nums[i] != nums[idx]) {
                swap(nums, i, idx);
                if (mIdx == idx) {
                    mIdx = i;
                }
            } else {
                i++;
            }
        }
        return mIdx;
    }

    public static void main(String[] args) {
        FindMissingNumber findMissingNumber = new FindMissingNumber();
        System.out.println("missing number:" + findMissingNumber.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println("missing number:" + findMissingNumber.findMissingOptimized(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
