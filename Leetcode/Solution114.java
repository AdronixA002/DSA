class Solution114 {
    public int maximumLengthSubstring(String s) {
        int[] ref = new int[27];
        int ans = 1, max = 0;

        for(int i=0;i<s.length();i++){
            int temp = s.charAt(i) - 'a';
            ref[temp]++;
            max++;

            while(ref[temp]>2){
                max--;
                ref[s.charAt(i-max) - 'a']--;
            }
            ans = Math.max(ans, max);
        }

        return ans;
    }
}



/*  3090. Maximum Length Substring With Two Occurrences

Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
 

Example 1:

Input: s = "bcbbbcba"

Output: 4

Explanation:

The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".
Example 2:

Input: s = "aaaa"

Output: 2

Explanation:

The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".
 

Constraints:

2 <= s.length <= 100
s consists only of lowercase English letters. */