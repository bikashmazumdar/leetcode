package coding.pattern.cyclic.sort;

/*
    Ref - https://leetcode.com/problems/first-missing-positive/
 */
public class FindMissingPositive {

    private void swap(int [] nums, int i, int j) {
        int temp = nums[j];
        nums[j]  = nums[i];
        nums[i]  = temp;
    }

    public int findMissingPositve(int [] nums) {
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

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return (i + 1);
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        FindMissingPositive missingPositive = new FindMissingPositive();
        System.out.println(missingPositive.findMissingPositve(new int[] {7,8,9,11,12}));
    }
}
