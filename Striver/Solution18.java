class Solution18 {
    public void moveZeroes(int[] nums) {
        int count = 0, n = nums.length;

        if(n>1){
            for(int i=0;i<n;i++){
                if(nums[i] == 0){
                    count++;
                }else{
                    nums[i-count] = nums[i];
                    if(i-count != i){
                        nums[i] = 0;
                    }
                }
                if(i >= n-count) nums[i] = 0;
            }
        }
    }
}


/*  283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
  */