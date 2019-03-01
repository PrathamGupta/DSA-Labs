package Ds;

import java.util.*;

class MergeSort 
{ 
	long count=0;
    void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i];
        
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
            	count=count+(n1-i);
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 

        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
  
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            merge(arr, l, m, r); 
        } 
    }
    void countpr() {
    	System.out.println(count);
    	count=0;
    }
    
} 

public class Answer_2{
	
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	 static Scanner sc=new Scanner(System.in);
	 static MergeSort ob = new MergeSort();
	 public static void main(String args[]) 
	    {
		 	int t=sc.nextInt();
		 	while(t>0) {
		 		int n=sc.nextInt();
		 		int[] arr=new int[n];
		 		for(int i=0; i<n; i++)
		 		{
		 			arr[i]=sc.nextInt();
		 		}
		 		ob.sort(arr, 0, arr.length-1); 
	  
		 		t--;
		 		ob.countpr();
		 	}
		 	
	    } 
}