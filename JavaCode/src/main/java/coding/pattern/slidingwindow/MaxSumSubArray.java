package coding.pattern.slidingwindow;

public class MaxSumSubArray {

    public static int maxSumSubArray(int [] nums, int target) {
        int i = 0 , j = 0, sum = 0 , max = 0;

        while (j < nums.length) {
            sum = sum + nums[j];

            if (j - i + 1 == target) {
                max = Math.max(max, sum);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums = {2,5,1,8,0,2,9,7};
        System.out.println(maxSumSubArray(nums, 3));
    }
}
