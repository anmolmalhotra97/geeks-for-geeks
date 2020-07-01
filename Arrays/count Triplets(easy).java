/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays; 

class GFG {
    
    public int findTriplets(int[] arr, int size)
    {
        Arrays.sort(arr);
        int ans = 0;
        for(int i = size-1; i>=0 ; i--)
        {
           int j = 0;
           int k = i-1;
           while(j<k)
           {
               if(arr[i] == (arr[j] + arr[k]))
               {
                    ans++;
                    j++;
                    k--;
               }
               else if (arr[i] < (arr[j] + arr[k]))
               {
                   k--;
               }
               else
               {
                   j++;
               }
           }
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