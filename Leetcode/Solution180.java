class Solution180 {
    public int minOperations(String s) {
        int n = s.length();
        char min = s.charAt(0), max = s.charAt(0);
        boolean isSorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) isSorted = false;
            if (s.charAt(i) < min) min = s.charAt(i);
            if (s.charAt(i) > max) max = s.charAt(i);
        }

        if (isSorted) return 0;
        if (n == 2) return -1;
        if (s.charAt(0) == min || s.charAt(n - 1) == max)
            return 1;

        for (int i = 1; i < n - 1; i++)
            if (s.charAt(i) == min || s.charAt(i) == max)
                return 2;

        return 3;
    }
}

/*  3863. Minimum Operations to Sort a String

You are given a string s consisting of lowercase English letters.

In one operation, you can select any substring of s that is not the entire string and sort it in non-descending alphabetical order.

Return the minimum number of operations required to make s sorted in non-descending order. If it is not possible, return -1.

 

Example 1:

Input: s = "dog"

Output: 1

Explanation:​​​​​​​

Sort substring "og" to "go".
Now, s = "dgo", which is sorted in ascending order. Thus, the answer is 1.
Example 2:

Input: s = "card"

Output: 2

Explanation:

Sort substring "car" to "acr", so s = "acrd".
Sort substring "rd" to "dr", making s = "acdr", which is sorted in ascending order. Thus, the answer is 2.
Example 3:

Input: s = "gf"

Output: -1

Explanation:

It is impossible to sort s under the given constraints. Thus, the answer is -1.
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters. */