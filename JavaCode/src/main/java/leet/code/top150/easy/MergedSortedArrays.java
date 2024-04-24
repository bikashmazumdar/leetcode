package leet.code.top150.easy;


import java.util.Arrays;

/*
    https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

 */
public class MergedSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, idx = (n + m) - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        MergedSortedArrays ma = new MergedSortedArrays();
        int [] nums1 = {11,12,23,0,0,0,0};
        int [] nums2 = {10,20,30,40};
        ma.merge(nums1, 3, nums2, 4);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
