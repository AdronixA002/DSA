
import java.util.Arrays;

class Solution61 {

    private String s;
    private int n;
    private long[][][] memo_cnt;
    private long[][][] memo_sum;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long num) {

        if (num < 100) {
            return 0L;
        }
        s = Long.toString(num);
        n = s.length();

        memo_cnt = new long[16][10][10];
        memo_sum = new long[16][10][10];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(memo_cnt[i][j], -1);
                Arrays.fill(memo_sum[i][j], -1);
            }
        }

        long[] result = dfs(0, -1, -1, true, true);
        return result[1];
    }

    private long[] dfs(
        int pos,
        int prev,
        int curr,
        boolean isLimit,
        boolean isLeading
    ) {
        if (pos == n) {
            return new long[] { 1L, 0L };
        }
        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            if (memo_cnt[pos][prev][curr] != -1) {
                return new long[] {
                    memo_cnt[pos][prev][curr],
                    memo_sum[pos][prev][curr],
                };
            }
        }

        long cnt = 0;
        long sum = 0;
        int up = isLimit ? (s.charAt(pos) - '0') : 9;
        for (int digit = 0; digit <= up; ++digit) {
            boolean newLeading = isLeading && (digit == 0);
            int newPrev = curr;
            int newCurr = newLeading ? -1 : digit;
            long[] sub = dfs(
                pos + 1,
                newPrev,
                newCurr,
                isLimit && (digit == up),
                newLeading
            );
            long subCnt = sub[0];
            long subSum = sub[1];

            if (!newLeading && prev >= 0 && curr >= 0) {
                if (
                    (prev < curr && curr > digit) ||
                    (prev > curr && curr < digit)
                ) {
                    sum += subCnt;
                }
            }

            cnt += subCnt;
            sum += subSum;
        }

        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            memo_cnt[pos][prev][curr] = cnt;
            memo_sum[pos][prev][curr] = sum;
        }

        return new long[] { cnt, sum };
    }
}


/*   Total Waviness of Numbers in Range II

You are given two integers num1 and num2 representing an inclusive range [num1, num2].

The waviness of a number is defined as the total count of its peaks and valleys:

A digit is a peak if it is strictly greater than both of its immediate neighbors.
A digit is a valley if it is strictly less than both of its immediate neighbors.
The first and last digits of a number cannot be peaks or valleys.
Any number with fewer than 3 digits has a waviness of 0.
Return the total sum of waviness for all numbers in the range [num1, num2].
 

Example 1:

Input: num1 = 120, num2 = 130

Output: 3

Explanation:

In the range [120, 130]:

120: middle digit 2 is a peak, waviness = 1.
121: middle digit 2 is a peak, waviness = 1.
130: middle digit 3 is a peak, waviness = 1.
All other numbers in the range have a waviness of 0.
Thus, total waviness is 1 + 1 + 1 = 3.

Example 2:

Input: num1 = 198, num2 = 202

Output: 3

Explanation:

In the range [198, 202]:

198: middle digit 9 is a peak, waviness = 1.
201: middle digit 0 is a valley, waviness = 1.
202: middle digit 0 is a valley, waviness = 1.
All other numbers in the range have a waviness of 0.
Thus, total waviness is 1 + 1 + 1 = 3.

Example 3:

Input: num1 = 4848, num2 = 4848

Output: 2

Explanation:

Number 4848: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.

 

Constraints:

1 <= num1 <= num2 <= 1015​​​​​​​ */