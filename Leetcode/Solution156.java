import java.util.ArrayDeque;
import java.util.Deque;

class Solution156 { 
    public String reverseParentheses(String s) { 
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') st.push(i);
            else if (s.charAt(i) == ')') {
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0, dir = 1;
        while (i >= 0 && i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                dir = -dir;
            } else {
                res.append(s.charAt(i));
            }
            i += dir;
        }
        return res.toString();
    } 
}



/*   1190. Reverse Substrings Between Each Pair of Parentheses

You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 

Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced. */