class Solution66 {
    public int reverse(int x) {
        long temp = 0;
        boolean neg = false;

        if(x<0){
            x = Math.abs(x);
            neg = true;
        }

        while(x>0){
            temp*=10;
            temp += x%10;
            x /= 10;
        }

        if(neg){
            temp = -temp;
        }

        if(temp <= Integer.MAX_VALUE && temp >= Integer.MIN_VALUE){
            return (int)temp;
        }else return 0;
    }
}


/*  Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1 */