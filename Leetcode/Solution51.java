public class Solution51 {
    public int numberOfSpecialChars(String word) {
        int[] a = new int[26];
        int[] b = new int[26];
        int n = word.length();

        for(int i=0;i<n;i++){
            char t = word.charAt(i);
            if(!Character.isUpperCase(t)){
                a[t - 'a']++;
            }else{
                b[t - 'A']++;
            }
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(a[i]>0 && b[i]>0){
                count++;
            }
        }

        return count;
    }
}


/*   Count the Number of Special Characters I

You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters in word are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

No character in word appears in uppercase.

Example 3:

Input: word = "abBCab"

Output: 1

Explanation:

The only special character in word is 'b'.

 

Constraints:

1 <= word.length <= 50
word consists of only lowercase and uppercase English letters. */
