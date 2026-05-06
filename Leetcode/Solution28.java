
import java.util.Arrays;

class Solution28 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int indx = len1+len2;
        double val1 = 0;

        nums1 = Arrays.copyOf(nums1, indx);

        for(int i=0;i<len2;i++){
            nums1[len1+i] = nums2[i];
        }

        Arrays.sort(nums1);

        if(indx%2==0){
            val1 += nums1[indx/2]+nums1[(indx/2)-1];
        }else{
            return val1 = nums1[indx/2];
        }

        val1 = val1/2;

        return val1;
    }
}


/*   Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 */