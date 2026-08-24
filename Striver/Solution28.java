import java.util.ArrayList;
import java.util.List;

class Solution28 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = -1, n = matrix.length, n1 = matrix[0].length;
        int remain = n*n1;
        List<Integer> l = new ArrayList<>();
        if(n==1 && n1==1){ 
            l.add(matrix[0][0]);
            return l;
        }

        while(remain>0){
            if(j-1>=0 && matrix[i][j-1]!=-101 && i>=n-1){
                j--;
            }else if(i-1>=0 && matrix[i-1][j]!=-101 && (j==0 || matrix[i][j-1]==-101)){
                i--;
            }else if(j+1<n1){
                j++;
            }else if(i+1<n){
                i++;
            }

            l.add(matrix[i][j]);
            matrix[i][j] = -101;
            remain--;

            if(i==n-1 && i>0 && matrix[i-1][j]==-101){
                n--;
            }else if(j==n1-1 && i!=n){
                n1--;
            }

        }

        return l;
    }
}


/*  54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100 */