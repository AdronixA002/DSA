class Solution160 {
    int count = 0;

    public int subarraySum(int[] nums, int k) {

        check(0,nums,k);

        return count;
    }

    public void check(int a, int[] arr, int ref){
        if(a>arr.length){
            return;
        }

        int sum = 0;

        for(int i=a;i<arr.length;i++){
            sum += arr[i];

            if(sum == ref)
                count++;
        }

        check(++a, arr, ref);
    }
}



/*  560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107 */