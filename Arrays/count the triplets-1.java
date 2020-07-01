/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    //*
    // Count Triplets such that one of the numbers can be written as sum of the other two
    //*
    public int findTriplets(int[] arr, int size)
    {
        int max_val = 0;
        for(int i=0; i<size; i++)
        {
            if(arr[i] > max_val)
                max_val = arr[i];
        }
    
        int[] freq = new int[max_val+1];
        for(int i =0;i<size;i++)
            freq[arr[i]]++;
            
        int ans = 0;
        // Case 1: 0, 0, 0 
        ans += freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6; 
  
        // Case 2: 0, x, x 
        for (int i = 1; i <= max_val; i++) 
            ans += freq[0] * freq[i] * (freq[i] - 1) / 2; 
  
        // Case 3: x, x, 2*x 
        for (int i = 1; 2 * i <= max_val; i++) 
            ans += freq[i] * (freq[i] - 1) / 2 * freq[2 * i]; 
  
        // Case 4: x, y, x + y 
        // iterate through all pairs (x, y) 
        for (int i = 1; i <= max_val; i++) { 
            for (int j = i + 1; i + j <= max_val; j++) 
                ans += freq[i] * freq[j] * freq[i + j]; 
        } 
  
        return ans; 
    }
    
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases>0)
        {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for(int i = 0; i<size; i++)
            {
                arr[i] = sc.nextInt();
            }
            GFG gfg = new GFG();
            int count = gfg.findTriplets(arr, size);
            if(count>0)
                System.out.println(count);
            else
                System.out.println("-1");
            testCases--;
        }
	}
}