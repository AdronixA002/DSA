import java.util.ArrayList;
import java.util.List;

class Solution166 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        fwd(s, res, 0, 0);

        return res;
    }

    private void fwd(String s, List<String> res, int li, int lj) {
        int bal = 0;

        for (int i = li; i < s.length(); i++) {
            if (s.charAt(i) == '(') bal++;
            if (s.charAt(i) == ')') bal--;

            if (bal >= 0) continue;

            for (int j = lj; j <= i; j++)
                if (s.charAt(j) == ')' && (j == lj || s.charAt(j - 1) != ')'))
                    fwd(s.substring(0, j) + s.substring(j + 1), res, i, j);

            return;
        }

        bwd(s, res, s.length() - 1, s.length() - 1);
    }

    private void bwd(String s, List<String> res, int ri, int rj) {
        int bal = 0;

        for (int i = ri; i >= 0; i--) {
            if (s.charAt(i) == ')') bal++;
            if (s.charAt(i) == '(') bal--;

            if (bal >= 0) continue;

            for (int j = rj; j >= i; j--)
                if (s.charAt(j) == '(' && (j == rj || s.charAt(j + 1) != '('))
                    bwd(s.substring(0, j) + s.substring(j + 1), res, i - 1, j - 1);

            return;
        }

        res.add(s);
    }
}


/*  301. Remove Invalid Parentheses

Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

 

Example 1:

Input: s = "()())()"
Output: ["(())()","()()()"]
Example 2:

Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
Example 3:

Input: s = ")("
Output: [""]
 

Constraints:

1 <= s.length <= 25
s consists of lowercase English letters and parentheses '(' and ')'.
There will be at most 20 parentheses in s. */