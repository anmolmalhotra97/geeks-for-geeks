/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public void findSubArrayWithSum(int[] arr, int n, int sum)
    {
        int curr_sum = arr[0], start = 0, i;
        for (i = 1; i <= n; i++) { 
            while (curr_sum > sum && start < i - 1) { 
                curr_sum = curr_sum - arr[start]; 
                start++; 
            } 
  
            if (curr_sum == sum) { 
                int p = i - 1; 
                System.out.println((start+1)+" "+(p+1)); 
                return;
            } 
              if (i < n) 
                curr_sum = curr_sum + arr[i]; 
        }
        
        System.out.println("-1");
    }
    
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = 0;
        testCases = sc.nextInt();
        while(testCases!=0)
        {
            int size = 0;
            size = sc.nextInt();
            int sum = 0;
            sum = sc.nextInt();
            int[] array = new int[size];
            for(int i = 0; i < size; i++)
            {
                array[i] = sc.nextInt();
            }
            GFG subArray = new GFG();
            subArray.findSubArrayWithSum(array, size, sum);
            testCases--;
        }
        
	}
}