import java.util.Arrays;

class Solution207 {
    private static final int INF = 10000;
    private int[][] memo;
    private int[][] cost;

    private int solve(int idx, int k, int n) {
        if (idx == n || k == 0) return (idx == n && k == 0) ? 0 : INF;
        if (memo[idx][k] != -1) return memo[idx][k];
        int res = INF;
        for (int len = 2; idx + len <= n; len++) {
            res = Math.min(res, cost[idx][len] + solve(idx + len, k - 1, n));
        }
        return memo[idx][k] = res;
    }

    public int minimumChanges(String s, int k) {
        int n = s.length();
        memo = new int[n + 1][k + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        cost = new int[n + 1][n + 1];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE / 2);

        for (int d = 1; d <= n / 2; d++) {
            int[][] tmp = new int[n + 1][n + 1];
            for (int len = 2 * d; len <= n; len += d) {
                for (int idx = 0; idx + len <= n; idx++) {
                    int ops = 0;
                    for (int o = 0; o < d; o++) {
                        if (s.charAt(idx + o) != s.charAt(idx + len - d + o)) ops++;
                    }
                    tmp[idx][len] = ops + tmp[idx + d][len - 2 * d];
                    cost[idx][len] = Math.min(cost[idx][len], tmp[idx][len]);
                }
            }
        }
        return solve(0, k, n);
    }
}



/*  2911. Minimum Changes to Make K Semi-palindromes

Given a string s and an integer k, partition s into k substrings such that the letter changes needed to make each substring a semi-palindrome are minimized.

Return the minimum number of letter changes required.

A semi-palindrome is a special type of string that can be divided into palindromes based on a repeating pattern. To check if a string is a semi-palindrome:​

Choose a positive divisor d of the string's length. d can range from 1 up to, but not including, the string's length. For a string of length 1, it does not have a valid divisor as per this definition, since the only divisor is its length, which is not allowed.
For a given divisor d, divide the string into groups where each group contains characters from the string that follow a repeating pattern of length d. Specifically, the first group consists of characters at positions 1, 1 + d, 1 + 2d, and so on; the second group includes characters at positions 2, 2 + d, 2 + 2d, etc.
The string is considered a semi-palindrome if each of these groups forms a palindrome.
Consider the string "abcabc":

The length of "abcabc" is 6. Valid divisors are 1, 2, and 3.
For d = 1: The entire string "abcabc" forms one group. Not a palindrome.
For d = 2:
Group 1 (positions 1, 3, 5): "acb"
Group 2 (positions 2, 4, 6): "bac"
Neither group forms a palindrome.
For d = 3:
Group 1 (positions 1, 4): "aa"
Group 2 (positions 2, 5): "bb"
Group 3 (positions 3, 6): "cc"
All groups form palindromes. Therefore, "abcabc" is a semi-palindrome.
 

Example 1:

Input:
String s = "abcac";
int k = 2;


Output: 1

Explanation: Divide s into "ab" and "cac". "cac" is already semi-palindrome. Change "ab" to "aa", it becomes semi-palindrome with d = 1.

Example 2:

Input:
String s = "abcdef";
int k = 2;


Output: 2

Explanation: Divide s into substrings "abc" and "def". Each needs one change to become semi-palindrome.

Example 3:

Input:
String s = "aabbaa";
int k = 3;


Output: 0

Explanation: Divide s into substrings "aa", "bb" and "aa". All are already semi-palindromes.

 

Constraints:

2 <= s.length <= 200
1 <= k <= s.length / 2
s contains only lowercase English letters. */