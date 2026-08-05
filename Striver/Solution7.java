
import java.util.ArrayList;
import java.util.Comparator;

class Solution7 {
    public ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> ans1 = new ArrayList<Integer>();
        
        for(int i=1;i*i<=n;i++){
            if(n%i == 0){
                ans.add(i);
                if(i != n/i){
                    ans1.add(n/i);
                }
            }
        }
        ans1.sort(Comparator.naturalOrder());
        ans.addAll(ans1);
        
        return ans;
    }
}


/*  All divisors of a Number

Given an integer n, return all the divisors of n in the ascending order.
 
Examples:

Input : n = 20
Output: 1 2 4 5 10 20
Explanation: 20 is completely divisible by 1, 2, 4, 5, 10 and 20.
Input: n = 21191
Output: 1 21191
Explanation: As 21191 is a prime number, it has only 2 factors(1 and the number itself).
Constraints:
1 ≤ n ≤ 109 */