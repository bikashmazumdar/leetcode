package coding.pattern.slidingwindow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FirstNegativeNumber {

    public static List<Integer> negativeNumbers(int [] nums, int target) {
        int i = 0, j = 0;
        List<Integer> negativeList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        while (j < nums.length) {

            if (nums[j] < 0) {
                negativeList.add(nums[j]);
            }
            if (j - i + 1 == target) {
                int value = 0;

                if (!negativeList.isEmpty()) {
                    value = negativeList.getFirst();
                    if (value == nums[i]) {
                        negativeList.removeFirst();
                    }
                }
                result.add(value);
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {12, -1, 7, 8, -15, 30, 16, 28};
        System.out.println(negativeNumbers(nums, 3));
    }
}
