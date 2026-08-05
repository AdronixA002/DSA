class Solution21 {
    int missingNumber(int arr[]) {
        for(int i=0;i<arr.length;i++){
            if(arr[i] != i+1){
                return i+1;
            }else if(i == arr.length-1){
                return arr[i]+1;
            }
        }
        
        return 0;
    }
}



/*  Missing Number in Sorted Array of Natural Numbers

Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Find the missing integer.

Examples:

Input: arr[] = [1, 2, 3, 4, 6, 7, 8]
Output: 5
Explanation: The missing integer in the array is 5.

Input: arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output: 7
Explanation: The missing integer in the array is 7.

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ arr.size()+1 */