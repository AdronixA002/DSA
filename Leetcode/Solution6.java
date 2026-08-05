import java.util.ArrayList;
import java.util.List;

class Solution6 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> answer = new ArrayList<>();
        int[] ref = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ref[nums[i]-1] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (ref[i] == 0) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
}



/* Q3. Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n */