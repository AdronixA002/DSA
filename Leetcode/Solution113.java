// TLE

//class Solution {
//     public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//         int n = queryIndices.length, ans = 1;
//         StringBuilder sb = new StringBuilder(s);
//         int[] result = new int[n];

//         for(int i=0;i<n;i++){
//             sb.setCharAt(queryIndices[i], queryCharacters.charAt(i));
//             int temp = 1, j = 1;
//             while(j<sb.length()){
//                 if(sb.charAt(j)==sb.charAt(j-1)){
//                     temp++;
//                 }else{
//                     temp = 1;
//                 }
//                 ans = Math.max(ans, temp);
//                 j++;
//             }
//             result[i] = ans;
//             ans = 1;
//         }

//         return result;
//     }
// }



class Solution113 {
    static class Node {char leftChar; char rightChar; int length; int prefix; int suffix;
int best;
        Node(char leftChar, char rightChar, int length, int prefix, int suffix, int best) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.length = length;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
        }
    }

    private Node[] tree;

    private Node merge(Node left, Node right) {
        int length = left.length + right.length;
        int prefix = left.prefix;

        if (left.rightChar == right.leftChar && left.prefix == left.length) {
            prefix = left.length + right.prefix;
        }

        int suffix = right.suffix;

        if (left.rightChar == right.leftChar && right.suffix == right.length) {
            suffix = right.length + left.suffix;
        }

        int best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {
            best = Math.max(best, left.suffix + right.prefix);
        }

        return new Node(left.leftChar, right.rightChar, length, prefix, suffix, best);
    }

    private void build( int node, int start, int end, String s) {
        if (start == end) {
            tree[node] = new Node( s.charAt(start), s.charAt(start), 1, 1, 1, 1);
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid, s);
        build(node * 2 + 1, mid + 1, end, s);

        tree[node] = merge(tree[node * 2],tree[node * 2 + 1]
        );
    }

    private void update( int node, int start, int end, int index, char ch) {
        if (start == end) {
            tree[node] = new Node(ch, ch, 1, 1, 1, 1);
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, end, index, ch);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        tree = new Node[4 * n];
        build(1, 0, n - 1, s);
        int[] answer = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            answer[i] = tree[1].best;
        }

        return answer;
    }
}



/*  2213. Longest Substring of One Repeating Character

You are given a 0-indexed string s. You are also given a 0-indexed string queryCharacters of length k and a 0-indexed array of integer indices queryIndices of length k, both of which are used to describe k queries.

The ith query updates the character in s at index queryIndices[i] to the character queryCharacters[i].

Return an array lengths of length k where lengths[i] is the length of the longest substring of s consisting of only one repeating character after the ith query is performed.

 

Example 1:

Input: s = "babacc", queryCharacters = "bcb", queryIndices = [1,3,3]
Output: [3,3,4]
Explanation: 
- 1st query updates s = "bbbacc". The longest substring consisting of one repeating character is "bbb" with length 3.
- 2nd query updates s = "bbbccc". 
  The longest substring consisting of one repeating character can be "bbb" or "ccc" with length 3.
- 3rd query updates s = "bbbbcc". The longest substring consisting of one repeating character is "bbbb" with length 4.
Thus, we return [3,3,4].
Example 2:

Input: s = "abyzz", queryCharacters = "aa", queryIndices = [2,1]
Output: [2,3]
Explanation:
- 1st query updates s = "abazz". The longest substring consisting of one repeating character is "zz" with length 2.
- 2nd query updates s = "aaazz". The longest substring consisting of one repeating character is "aaa" with length 3.
Thus, we return [2,3].
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
k == queryCharacters.length == queryIndices.length
1 <= k <= 105
queryCharacters consists of lowercase English letters.
0 <= queryIndices[i] < s.length */