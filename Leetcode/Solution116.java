import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {

        List<Integer> ref = new ArrayList<>();
        ref.add(1);
        res.add(ref);
        triangle(ref, numRows-1);

        return res;

    }

    public void triangle(List<Integer> l, int len){
        if(len == 0){
            return;
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(1);
        for(int i=1;i<l.size();i++){
            ans.add(l.get(i-1)+l.get(i));
        }
        ans.add(1);

        res.add(ans);

        triangle(ans, len-1);
    }
}


/*  118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30 */