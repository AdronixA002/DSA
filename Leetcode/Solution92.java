import java.util.ArrayList;
import java.util.List;

class Solution92 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        for (int i = 1; i <= k; i++) {
            grid = shift(grid);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int val : row) {
                list.add(val);
            }
            result.add(list);
        }

        return result;
    }

    public int[][] shift(int[][] a) {

        int temp = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = a[0].length - 1; j >= 0; j--) {

                if (i == a.length - 1 && j == a[0].length - 1) {
                    temp = a[i][j];
                } 
                else if (i == 0 && j == 0) {
                    if(a[0].length>1){
                        a[i][j+1] = a[i][j];
                    }else{
                        a[i+1][j] = a[i][j];
                    }
                    a[i][j] = temp;
                } 
                else if (j == a[0].length - 1) {
                    a[i + 1][0] = a[i][j];
                } 
                else {
                    a[i][j + 1] = a[i][j];
                }
            }
        }

        return a;
    }
}


/*  1260. Shift 2D Grid

Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

 

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
Example 2:


Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100 */