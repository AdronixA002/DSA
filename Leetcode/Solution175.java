class Solution175 {
    long[] s, q, lz;

    void app(int o, int len, long k) {
        q[o] += 2 * k * s[o] + k * k * len;
        s[o] += k * len;
        lz[o] += k;
    }

    void upd(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) { app(o, r - l + 1, 1); return; }
        int m = (l + r) >> 1;
        if (lz[o] != 0) {
            app(2*o, m - l + 1, lz[o]);
            app(2*o+1, r - m, lz[o]);
            lz[o] = 0;
        }
        if (L <= m) upd(2*o, l, m, L, R);
        if (R > m) upd(2*o+1, m+1, r, L, R);
        s[o] = s[2*o] + s[2*o+1];
        q[o] = q[2*o] + q[2*o+1];
    }

    public int sumCounts(int[] nums) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;
        s = new long[4*n]; q = new long[4*n]; lz = new long[4*n];
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            upd(1, 0, n-1, last[nums[i]] + 1, i);
            last[nums[i]] = i;
            ans = (ans + q[1]) % MOD;
        }
        return (int) ans;
    }
}


/*  2916. Subarrays Distinct Element Sum of Squares II

You are given a 0-indexed integer array nums.

The distinct count of a subarray of nums is defined as:

Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
Return the sum of the squares of distinct counts of all subarrays of nums.

Since the answer may be very large, return it modulo 109 + 7.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,1]
Output: 15
Explanation: Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 + 22 + 22 + 22 = 15.
Example 2:

Input: nums = [2,2]
Output: 3
Explanation: Three possible subarrays are:
[2]: 1 distinct value
[2]: 1 distinct value
[2,2]: 1 distinct value
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 = 3.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105 */
