
import java.util.ArrayList;

class Solution20 {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n = a.length, n1 = b.length;
        int len = Math.max(n, n1);
        int[] ref = new int[Math.max(a[n-1], b[n1-1])+1];
        
        for(int i=0;i<len;i++){
            if(i<n){
                ref[a[i]]++;
            }
            if(i<n1){
                ref[b[i]]++;
            }
        }
        
        ArrayList<Integer> l = new ArrayList<>();
        
        for(int i=0;i<ref.length;i++){
            if(ref[i]>0){
                l.add(i);
            }
        }
        
        return l;
    }
}


/*  Union of 2 Sorted Arrays

Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the elements in the union of the two arrays in sorted order.

Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.

Examples:

Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: [1, 2, 3, 4, 5, 6, 7]
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.

Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
Output: [1, 2, 3, 4, 5]
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.

Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
Output: [1, 2]
Explanation: Distinct elements including both the arrays are: 1 2.

Constraints:
1  ≤  a.size(), b.size()  ≤  10^5
-10^9 ≤ a[i], b[i] ≤10^9 */
