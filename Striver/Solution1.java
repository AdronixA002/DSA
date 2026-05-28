class Solution1 {
    public void pattern22(int n) {

        for(int i=n;i>0;i--){
            for(int j=n;j>0;j--){
                if(j>i){
                    System.out.print(j);
                }else{
                    System.out.print(i);
                }
                System.out.print(" ");
            }
            for(int k=2;k<=n;k++){
                if(k>i){
                    System.out.print(k);
                }else{
                    System.out.print(i);
                }
                if(k!=n) System.out.print(" ");
            }
            System.out.println();
        }

        for(int i=2;i<=n;i++){
            for(int j=n;j>0;j--){
                if(j>i){
                    System.out.print(j);
                }else{
                    System.out.print(i);
                }
                System.out.print(" ");
            }
            for(int k=2;k<=n;k++){
                if(k>i){
                    System.out.print(k);
                }else{
                    System.out.print(i);
                }
                if(k!=n) System.out.print(" ");
            }
            System.out.println();
        }
    }
} 


/*   Pattern 22

Given an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:



5 5 5 5 5 5 5 5 5 
5 4 4 4 4 4 4 4 5 
5 4 3 3 3 3 3 4 5 
5 4 3 2 2 2 3 4 5 
5 4 3 2 1 2 3 4 5 
5 4 3 2 2 2 3 4 5 
5 4 3 3 3 3 3 4 5 
5 4 4 4 4 4 4 4 5 
5 5 5 5 5 5 5 5 5


Print the pattern in the function given to you.


Example 1

Input: n = 4

Output:



Example 2

Input: n = 2

Output:



Constraints

1 <= n <= 100 */