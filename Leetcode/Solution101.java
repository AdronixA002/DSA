class Solution101 {
    public void sortColors(int[] nums) {
        int[] ref = new int[3];

        for(int i: nums){
            ref[i]++;
        }

        int j=0, indx = 0;

        while(j < 3){
            for(int i=0;i<ref[j];i++){
                if(j == 0){
                    nums[indx] = 0;
                }else if(j == 1){
                    nums[indx] = 1;
                }else{
                    nums[indx] = 2;
                }
                indx++;
            }
            j++;
        }
    }
}


/*  75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2. */