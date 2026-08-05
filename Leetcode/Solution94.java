class Solution94 {
    public int maxProduct(int n) {
        String ref = Integer.toString(n);
        int ans = 1;

        if (ref.length() == 2)
            return Character.getNumericValue(ref.charAt(0)) * Character.getNumericValue(ref.charAt(1));

        int[] val = new int[10];

        for (int i = 0; i < ref.length(); i++) {
            val[Character.getNumericValue(ref.charAt(i))]++;
        }

        for (int i = 9; i >= 0; i--) {
            if (val[i] > 0) {
                if (ans == 1 && val[i] >= 2) {
                    ans = i * i;
                    break;
                } else if (ans > 1) {
                    ans *= i;
                    break;
                } else {
                    ans *= i;
                }
            }
        }

        return ans;
    }
}



/*  3536. Maximum Product of Two Digits

You are given a positive integer n.

Return the maximum product of any two digits in n.

Note: You may use the same digit twice if it appears more than once in n.

 

Example 1:

Input: n = 31

Output: 3

Explanation:

The digits of n are [3, 1].
The possible products of any two digits are: 3 * 1 = 3.
The maximum product is 3.
Example 2:

Input: n = 22

Output: 4

Explanation:

The digits of n are [2, 2].
The possible products of any two digits are: 2 * 2 = 4.
The maximum product is 4.
Example 3:

Input: n = 124

Output: 8

Explanation:

The digits of n are [1, 2, 4].
The possible products of any two digits are: 1 * 2 = 2, 1 * 4 = 4, 2 * 4 = 8.
The maximum product is 8.
 

Constraints:

10 <= n <= 109 */