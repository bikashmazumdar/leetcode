package leet.code.top150.easy;

import java.util.*;

/*
https://leetcode.com/problems/majority-element/

*/
public class MajorityElements {

    /*
        Solved using HashMap
        Time Complexity - O(N)
        Space Complexity - O (N)
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        int key = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }
    /*
        Space complexity - O(1)
        Time complexity  - O(Nlog(N))
     */
    public int majorityElementOptimized(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /*
        The problem is solved using Moor's majority selection algorithm
        ref: https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
     */
    public int majorityElementMoorAlg(int[] nums) {
       int count = 0, candidateKey = nums[0];
       for (int n : nums) {
           if (n == candidateKey) {
               count++;
           } else {
               count = count - 1;
           }
           if(count == 0) {
               candidateKey = n;
               count = 1;
           }
       }
       return candidateKey;
    }

    public static void main(String[] args) {
        int [] nums = {6,6,6,7,7};
        MajorityElements majorityElements = new MajorityElements();
        System.out.println(majorityElements.majorityElement(nums));
        System.out.println(majorityElements.majorityElementOptimized(nums));
        System.out.println(majorityElements.majorityElementMoorAlg(nums));
    }
}
