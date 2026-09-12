import java.util.Arrays;
import java.util.List;

class Solution141 {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] iv = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int c = 0; c < 3; c++) iv[i][c] = intervals.get(i).get(c);

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> iv[a][1] - iv[b][1]);
        int[] rights = new int[n];
        for (int p = 0; p < n; p++) rights[p] = iv[order[p]][1];

        long[] prevScore = new long[n + 1];
        int[][] prevIds = new int[n + 1][0];
        for (int k = 0; k < 4; k++) {
            long[] curScore = new long[n + 1];
            int[][] curIds = new int[n + 1][0];
            for (int p = 1; p <= n; p++) {
                int i = order[p - 1];  // take next interval
                int l = iv[i][0], w = iv[i][2];
                int lo = 0, hi = n;  // lower_bound: intervals ending before l
                while (lo < hi) { 
                    int mid = (lo + hi) >>> 1; 
                    if (rights[mid] < l) lo = mid + 1; 
                    else hi = mid; 
                }

                long takeScore = prevScore[lo] + w;
                int[] takeIds = insertSorted(prevIds[lo], i);
                if (better(takeScore, takeIds, curScore[p - 1], curIds[p - 1])) {
                    curScore[p] = takeScore; 
                    curIds[p] = takeIds;
                } else {
                    curScore[p] = curScore[p - 1]; 
                    curIds[p] = curIds[p - 1];
                }
            }
            prevScore = curScore; prevIds = curIds;
        }
        return prevIds[n];
    }

    private static boolean better(long s1, int[] a, long s2, int[] b) {
        if (s1 != s2) return s1 > s2;  // higher score wins
        int m = Math.min(a.length, b.length);
        for (int i = 0; i < m; i++)
            if (a[i] != b[i]) return a[i] < b[i];  // then lexicographically smaller
        return a.length < b.length;
    }

    private static int[] insertSorted(int[] ids, int x) {
        int[] out = new int[ids.length + 1];
        int i = 0;
        while (i < ids.length && ids[i] < x) { 
            out[i] = ids[i]; 
            i++; 
        }
        out[i] = x;
        for (; i < ids.length; i++) 
            out[i + 1] = ids[i];
        return out;
    }
}



/*  3414. Maximum Score of Non-overlapping Intervals

You are given a 2D integer array intervals, where intervals[i] = [li, ri, weighti]. Interval i starts at position li and ends at ri, and has a weight of weighti. You can choose up to 4 non-overlapping intervals. The score of the chosen intervals is defined as the total sum of their weights.

Return the lexicographically smallest array of at most 4 indices from intervals with maximum score, representing your choice of non-overlapping intervals.

Two intervals are said to be non-overlapping if they do not share any points. In particular, intervals sharing a left or right boundary are considered overlapping.

 

Example 1:

Input: intervals = [[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]

Output: [2,3]

Explanation:

You can choose the intervals with indices 2, and 3 with respective weights of 5, and 3.

Example 2:

Input: intervals = [[5,8,1],[6,7,7],[4,7,3],[9,10,6],[7,8,2],[11,14,3],[3,5,5]]

Output: [1,3,5,6]

Explanation:

You can choose the intervals with indices 1, 3, 5, and 6 with respective weights of 7, 6, 3, and 5.

 

Constraints:

1 <= intevals.length <= 5 * 104
intervals[i].length == 3
intervals[i] = [li, ri, weighti]
1 <= li <= ri <= 109
1 <= weighti <= 109 */