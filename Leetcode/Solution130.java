class Solution130 {
    public boolean isValid(String s) {
        int i = 1;
        StringBuilder sb = new StringBuilder(s);

        while(i<sb.length()){
            if(i>0 && ((int)sb.charAt(i)==(int)sb.charAt(i-1)+1 || (int)sb.charAt(i)==(int)sb.charAt(i-1)+2)){
                sb.delete(i-1,i+1);
                i--;
            }else  i++;
        }

        return sb.length()==0;
    }
}



/*  20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'. */