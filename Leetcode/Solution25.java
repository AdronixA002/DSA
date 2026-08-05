
import java.util.HashSet;
import java.util.Set;

class Solution25 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i=0;
        Set<Character> l = new HashSet<>();

        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            while(l.contains(c)){
                l.remove(s.charAt(i));
                i++;
            }
            max = Math.max(max, j+1-i);
            l.add(c);
        }
        return max;
    }
}


/*   Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without duplicate characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces. */