package leet.code.top150.easy;

/*
    Ref - https://leetcode.com/problems/happy-number/
 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    private int squareDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum = sum + (digit * digit);
            n = n/10;
        }
        return sum;
    }

    /*
        Steps:
            1. The utility function is used to compute the digits square sum
            2. The Set is used track the cycle
            3. If square sum of digits is 1 then return true
            4. If the square sum is present in the set indicates a cycle, return false
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n > 1) {
            set.add(n);
            n = squareDigitSum(n);
            if(n != 1 && set.contains(n)) {
                return false;
            }
        }
        return n == 1;
    }
}
