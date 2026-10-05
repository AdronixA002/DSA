import java.util.ArrayList;
import java.util.List;

class Solution164 {
    public int scoreOfParentheses(String s) {
        int left = 0, count = 0;
        boolean flag = true;
        List<Integer> l = new ArrayList<>();

        if(s.length()<=4) return s.length()/2;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
                flag = true;
            }else{
                left--;
                if(flag){
                    l.add(left);
                    flag = false;
                }
            }
        }

        for(int i=0;i<l.size();i++){
            count += Math.pow(2, l.get(i));
        }

        return count;
    }
}



/*  856. Score of Parentheses

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
 

Constraints:

2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string. */