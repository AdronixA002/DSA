import java.util.Arrays;

class Solution211 {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] firstChild = new int[n], nextSibling = new int[n];  // children as a linked list in two int arrays
        Arrays.fill(firstChild, -1);
        for (int x = n - 1; x > 0; x--) {
            nextSibling[x] = firstChild[parent[x]];
            firstChild[parent[x]] = x;
        }
        int[] size = new int[n], above = new int[n], last = new int[26], stack = new int[2 * n];  // last[c]: the deepest node with letter c on the path from the root
        Arrays.fill(size, 1);
        Arrays.fill(last, -1);
        int top = 0;
        stack[top++] = 0;  // x enters x, ~x leaves it: no recursion
        while (top > 0) {
            int x = stack[--top];
            if (x >= 0) {
                int c = s.charAt(x) - 'a';
                above[x] = last[c];  // the closest ancestor with the same letter, or -1
                last[c] = x;
                stack[top++] = ~x;  // leave x after all its children
                for (int child = firstChild[x]; child != -1; child = nextSibling[child])
                    stack[top++] = child;
            } else {
                x = ~x;
                last[s.charAt(x) - 'a'] = above[x];
                if (x > 0)  // the root has no parent
                    size[above[x] >= 0 ? above[x] : parent[x]] += size[x];
            }
        }
        return size;
    }
}



/*  3331. Find Subtree Sizes After Changes

You are given a tree rooted at node 0 that consists of n nodes numbered from 0 to n - 1. The tree is represented by an array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.

You are also given a string s of length n, where s[i] is the character assigned to node i.

We make the following changes on the tree one time simultaneously for all nodes x from 1 to n - 1:

Find the closest node y to node x such that y is an ancestor of x, and s[x] == s[y].
If node y does not exist, do nothing.
Otherwise, remove the edge between x and its current parent and make node y the new parent of x by adding an edge between them.
Return an array answer of size n where answer[i] is the size of the subtree rooted at node i in the final tree.

 

Example 1:

Input: parent = [-1,0,0,1,1,1], s = "abaabc"

Output: [6,3,1,1,1,1]

Explanation:


The parent of node 3 will change from node 1 to node 0.

Example 2:

Input: parent = [-1,0,4,0,1], s = "abbba"

Output: [5,2,1,1,1]

Explanation:


The following changes will happen at the same time:

The parent of node 4 will change from node 1 to node 0.
The parent of node 2 will change from node 4 to node 1.
 

Constraints:

n == parent.length == s.length
1 <= n <= 105
0 <= parent[i] <= n - 1 for all i >= 1.
parent[0] == -1
parent represents a valid tree.
s consists only of lowercase English letters. */