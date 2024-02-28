package leet.code.top150.medium;

/*
    Ref - https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    /*
        used two pointer approach
        steps:
            1. Take the minimum between left and right value
            2. Take the difference between right and left
            3. Calculate the area = height * length
            4. update the max
            5. Move the left pointer if left value is greater than right otherwise
               move right pointer
     */
    public int maxArea(int[] height) {
        int output = 0;
        int left = 0, right = height.length - 1;

        while( left < right) {

            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            output = Math.max(output, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }
}
