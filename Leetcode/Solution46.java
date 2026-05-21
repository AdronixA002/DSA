class Solution46 {
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            int left = i;
            int right = i;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {

                if ((right - left + 1) > ans.length()) {
                    ans = s.substring(left, right + 1);
                }

                left--;
                right++;
            }

            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {

                if ((right - left + 1) > ans.length()) {
                    ans = s.substring(left, right + 1);
                }

                left--;
                right++;
            }
        }

        return ans;
    }
}


/*   Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters. */