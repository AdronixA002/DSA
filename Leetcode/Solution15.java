class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];

            if (y == 0) pos[i] = x;
            else if (x == side) pos[i] = side + y;
            else if (y == side) pos[i] = 2L * side + (side - x);
            else pos[i] = 3L * side + (side - y);
        }

        Arrays.sort(pos);

        long[] ext = new long[2 * n];
        for (int i = 0; i < n; i++) {
            ext[i] = pos[i];
            ext[i + n] = pos[i] + 4L * side;
        }

        long left = 0, right = 2L * side, ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (can(ext, n, k, mid, side)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean can(long[] ext, int n, int k, long d, int side) {
        long perimeter = 4L * side;

        for (int start = 0; start < n; start++) {
            int count = 1;
            long first = ext[start];
            long last = first;
            int idx = start;

            while (count < k) {
                int next = lowerBound(ext, idx + 1, start + n, last + d);
                if (next == -1) break;

                last = ext[next];
                idx = next;
                count++;
            }

            if (count >= k && (perimeter - (last - first)) >= d) {
                return true;
            }
        }

        return false;
    }

    private int lowerBound(long[] arr, int l, int r, long target) {
        int res = -1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) {
                res = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}


/* Maximize the Distance Between Points on a Square

You are given an integer side, representing the edge length of a square with corners at (0, 0), (0, side), (side, 0), and (side, side) on a Cartesian plane.

You are also given a positive integer k and a 2D integer array points, where points[i] = [xi, yi] represents the coordinate of a point lying on the boundary of the square.

You need to select k elements among points such that the minimum Manhattan distance between any two points is maximized.

Return the maximum possible minimum Manhattan distance between the selected k points.

The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.

 

Example 1:

Input: side = 2, points = [[0,2],[2,0],[2,2],[0,0]], k = 4

Output: 2

Explanation:



Select all four points.

Example 2:

Input: side = 2, points = [[0,0],[1,2],[2,0],[2,2],[2,1]], k = 4

Output: 1

Explanation:



Select the points (0, 0), (2, 0), (2, 2), and (2, 1).

Example 3:

Input: side = 2, points = [[0,0],[0,1],[0,2],[1,2],[2,0],[2,2],[2,1]], k = 5

Output: 1

Explanation:



Select the points (0, 0), (0, 1), (0, 2), (1, 2), and (2, 2).

 

Constraints:

1 <= side <= 109
4 <= points.length <= min(4 * side, 15 * 103)
points[i] == [xi, yi]
The input is generated such that:
points[i] lies on the boundary of the square.
All points[i] are unique.
4 <= k <= min(25, points.length) */