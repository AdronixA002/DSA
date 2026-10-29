import java.util.*;

class Solution {
    int N;
    int[] bit;
    int LOG;
    int[][] up;
    int[] depth;

    void add(int i, int x) {
        for (; i <= N + 1; i += i & -i) bit[i] ^= x;
    }

    int get(int i) {
        int r = 0;
        for (; i > 0; i -= i & -i) r ^= bit[i];
        return r;
    }

    void rangeXor(int l, int r, int x) {
        add(l, x);
        add(r + 1, x);
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) { int t = u; u = v; v = t; }
        int d = depth[u] - depth[v];
        for (int j = 0; j < LOG; j++) if (((d >> j) & 1) == 1) u = up[j][u];
        if (u == v) return u;
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) { u = up[j][u]; v = up[j][v]; }
        }
        return up[0][u];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        N = n;
        bit = new int[n + 2];
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[2 * n];
        int[] to = new int[2 * n];
        int cnt = 0;
        for (int[] e : edges) {
            to[cnt] = e[1]; nxt[cnt] = head[e[0]]; head[e[0]] = cnt++;
            to[cnt] = e[0]; nxt[cnt] = head[e[1]]; head[e[1]] = cnt++;
        }
        LOG = 1;
        while ((1 << LOG) < n) LOG++;
        up = new int[LOG][n];
        depth = new int[n];
        int[] tin = new int[n], tout = new int[n];
        int[] it = head.clone();
        int[] stack = new int[n];
        int sp = 0, timer = 1;
        stack[sp++] = 0;
        tin[0] = 1;
        while (sp > 0) {
            int u = stack[sp - 1];
            if (it[u] != -1) {
                int e = it[u];
                it[u] = nxt[e];
                int v = to[e];
                if (v == up[0][u]) continue;
                up[0][v] = u;
                depth[v] = depth[u] + 1;
                tin[v] = ++timer;
                stack[sp++] = v;
            } else {
                tout[u] = timer;
                sp--;
            }
        }
        for (int j = 1; j < LOG; j++)
            for (int v = 0; v < n; v++) up[j][v] = up[j - 1][up[j - 1][v]];

        char[] cs = s.toCharArray();
        for (int u = 0; u < n; u++) rangeXor(tin[u], tout[u], 1 << (cs[u] - 'a'));

        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);
                if (cs[u] != c) {
                    int x = (1 << (cs[u] - 'a')) ^ (1 << (c - 'a'));
                    rangeXor(tin[u], tout[u], x);
                    cs[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int l = lca(u, v);
                int m = get(tin[u]) ^ get(tin[v]) ^ (1 << (cs[l] - 'a'));
                res.add((m & (m - 1)) == 0);
            }
        }
        return res;
    }
}


/*  3841. Palindromic Path Queries in a Tree

You are given an undirected tree with n nodes labeled 0 to n - 1. This is represented by a 2D array edges of length n - 1, where edges[i] = [ui, vi] indicates an undirected edge between nodes ui and vi.

You are also given a string s of length n consisting of lowercase English letters, where s[i] represents the character assigned to node i.

You are also given a string array queries, where each queries[i] is either:

"update ui c": Change the character at node ui to c. Formally, update s[ui] = c.
"query ui vi": Determine whether the string formed by the characters on the unique path from ui to vi (inclusive) can be rearranged into a palindrome.
Return a boolean array answer, where answer[j] is true if the jth query of type "query ui vi"​​​​​​​ can be rearranged into a palindrome, and false otherwise.

 

Example 1:

Input: n = 3, edges = [[0,1],[1,2]], s = "aac", queries = ["query 0 2","update 1 b","query 0 2"]

Output: [true,false]

Explanation:

"query 0 2": Path 0 → 1 → 2 gives "aac", which can be rearranged to form "aca", a palindrome. Thus, answer[0] = true.
"update 1 b": Update node 1 to 'b', now s = "abc".
"query 0 2": Path characters are "abc", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.
Thus, answer = [true, false].

Example 2:

Input: n = 4, edges = [[0,1],[0,2],[0,3]], s = "abca", queries = ["query 1 2","update 0 b","query 2 3","update 3 a","query 1 3"]

Output: [false,false,true]

Explanation:

"query 1 2": Path 1 → 0 → 2 gives "bac", which cannot be rearranged to form a palindrome. Thus, answer[0] = false.
"update 0 b": Update node 0 to 'b', now s = "bbca".
"query 2 3": Path 2 → 0 → 3 gives "cba", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.
"update 3 a": Update node 3 to 'a', s = "bbca".
"query 1 3": Path 1 → 0 → 3 gives "bba", which can be rearranged to form "bab", a palindrome. Thus, answer[2] = true.
Thus, answer = [false, false, true].

 

Constraints:

1 <= n == s.length <= 5 * 104
edges.length == n - 1
edges[i] = [ui, vi]
0 <= ui, vi <= n - 1
s consists of lowercase English letters.
The input is generated such that edges represents a valid tree.
1 <= queries.length <= 5 * 104​​​​​​​
queries[i] = "update ui c" or
queries[i] = "query ui vi"
0 <= ui, vi <= n - 1
c is a lowercase English letter. */