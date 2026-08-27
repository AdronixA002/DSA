class Solution126 {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (char ch : target.toCharArray()) {
            cnt[ch - 'a']--;
        }

        for (int i = target.length() - 1; i >= 0; i--) {
            int cur = target.charAt(i) - 'a';
            cnt[cur]++;

            boolean ok = true;
            for (int x : cnt) {
                if (x < 0) {
                    ok = false;
                    break;
                }
            }

            if (!ok) continue;

            int next = -1;
            for (int c = cur + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    next = c;
                    break;
                }
            }

            if (next == -1) continue;

            cnt[next]--;

            StringBuilder ans = new StringBuilder(target.substring(0, i));
            ans.append((char) ('a' + next));

            for (int c = 0; c < 26; c++) {
                while (cnt[c]-- > 0) {
                    ans.append((char) ('a' + c));
                }
            }

            return ans.toString();
        }

        return "";
    }
}



/*  3720. Lexicographically Smallest Permutation Greater Than Target

You are given two strings s and target, both having length n, consisting of lowercase English letters.

Return the lexicographically smallest permutation of s that is strictly greater than target. If no permutation of s is lexicographically strictly greater than target, return an empty string.

A string a is lexicographically strictly greater than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b.

 

Example 1:

Input: s = "abc", target = "bba"

Output: "bca"

Explanation:

The permutations of s (in lexicographical order) are "abc", "acb", "bac", "bca", "cab", and "cba".
The lexicographically smallest permutation that is strictly greater than target is "bca".
Example 2:

Input: s = "leet", target = "code"

Output: "eelt"

Explanation:

The permutations of s (in lexicographical order) are "eelt", "eetl", "elet", "elte", "etel", "etle", "leet", "lete", "ltee", "teel", "tele", and "tlee".
The lexicographically smallest permutation that is strictly greater than target is "eelt".
Example 3:

Input: s = "baba", target = "bbaa"

Output: ""

Explanation:

The permutations of s (in lexicographical order) are "aabb", "abab", "abba", "baab", "baba", and "bbaa".
None of them is lexicographically strictly greater than target. Therefore, the answer is "".
 

Constraints:

1 <= s.length == target.length <= 300
s and target consist of only lowercase English letters. */