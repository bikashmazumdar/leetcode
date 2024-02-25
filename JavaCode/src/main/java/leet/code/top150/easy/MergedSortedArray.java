package leet.code.top150.easy;

import java.util.Arrays;

/*
88. Merge Sorted Array : https://leetcode.com/problems/merge-sorted-array/
 */

public class MergedSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int idx = nums1.length - 1;
        System.out.println(" m =" +m + " n=" + n);
        if (nums1[0] == 0 && nums1.length == 1) {
            nums1[0] = nums2[0];
        }

        while(j >= 0 && idx >= 0) {
            //System.out.println("i" + i +", j = " +j +" idx = " + idx +" num1[i]="+ nums1[i] + " nums2[j]="+ nums2[j]);
            if (i >= 0 && nums1[i] == nums2[j]) {
                nums1[idx--] = nums2[j];
                nums1[idx--] = nums1[i];
                i--;
                j--;
            } else if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[idx--] = nums1[i];
                i--;
            } else if (i < 0 || nums1[i] < nums2[j]) {
                nums1[idx--] = nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int [] nums1 = {0,0,3,0,0,0,0,0,0};
        int [] nums2 = {-1,1,1,1,2,3};

        MergedSortedArray mergedSortedArray = new MergedSortedArray();
        mergedSortedArray.merge(nums1, 3, nums2, nums2.length);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
