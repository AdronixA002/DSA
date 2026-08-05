import java.util.Arrays;

class Solution88 {
    public long gcdSum(int[] nums) {
        int max = 0, n = nums.length;
        long ans = 0;
        int[] ref = new int[n];

        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
            ref[i] = gcd(nums[i], max);
        }

        Arrays.sort(ref);
        for(int i=0;i<n/2;i++){
            ans += gcd(ref[i], ref[n-1-i]);
        }

        return ans;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}



/*  3867. Sum of GCD of Formed Pairs

You are given an integer array nums of length n.

Construct an array prefixGcd where for each index i:

Let mxi = max(nums[0], nums[1], ..., nums[i]).
prefixGcd[i] = gcd(nums[i], mxi).
After constructing prefixGcd:

Sort prefixGcd in non-decreasing order.
Form pairs by taking the smallest unpaired element and the largest unpaired element.
Repeat this process until no more pairs can be formed.
For each formed pair, compute the gcd of the two elements.
If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.
Return an integer denoting the sum of the GCD values of all formed pairs.

The term gcd(a, b) denotes the greatest common divisor of a and b.
 

Example 1:

Input: nums = [2,6,4]

Output: 2

Explanation:

Construct prefixGcd:

i	nums[i]	mxi	prefixGcd[i]
0	2	2	2
1	6	6	6
2	4	6	2
prefixGcd = [2, 6, 2]. After sorting, it forms [2, 2, 6].

Pair the smallest and largest elements: gcd(2, 6) = 2. The remaining middle element 2 is ignored. Thus, the sum is 2.

Example 2:

Input: nums = [3,6,2,8]

Output: 5

Explanation:

Construct prefixGcd:

i	nums[i]	mxi	prefixGcd[i]
0	3	3	3
1	6	6	6
2	2	6	2
3	8	8	8
prefixGcd = [3, 6, 2, 8]. After sorting, it forms [2, 3, 6, 8].

Form pairs: gcd(2, 8) = 2 and gcd(3, 6) = 3. Thus, the sum is 2 + 3 = 5.

 

Constraints:

1 <= n == nums.length <= 105
1 <= nums[i] <= 10​​​​​​​9 */