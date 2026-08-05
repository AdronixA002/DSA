import java.util.Arrays;

class Solution95 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;

        if(nums[n-1]>0 && nums[n-n]<0 && nums[n-(n-1)]<0 && nums[n-n]*nums[n-(n-1)] > nums[n-3]*nums[n-2]){
            ans = nums[n-n]*nums[n-(n-1)]*nums[n-1];
        }else{
            ans = nums[n-1]*nums[n-2]*nums[n-3];
        }

        return ans;
    }
}


/*  628. Maximum Product of Three Numbers

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000 */