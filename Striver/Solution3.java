class Solution3 {
    public int reverseNumber(int n) {
        int ans = 0;
        while(n>0){
            int t = n%10;
            ans = ans*10+t;
            n /=10;
        }
        return ans;
    }
}


/*   Reverse a number

You are given an integer n. Return the integer formed by placing the digits of n in reverse order.


Example 1

Input: n = 25

Output: 52

Explanation: Reverse of 25 is 52.

Example 2

Input: n = 123

Output: 321

Explanation: Reverse of 123 is 321.

Input: n = 54

Output: 45

Constraints

0 <= n <= 5000
n will contain no leading zeroes except when it is 0 itself. */