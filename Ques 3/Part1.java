
import java.util.*;

public class Fri {
	static Scanner sc=new Scanner(System.in);

	public static long countBST(int n)  
	{
		if(n<2) {
			return 1;
		}
		else
		{
			long sum =0;
			for(int i=0; i<n; i++)
			{
				int x=n-i-1;
				long rightsubtree = countBST(x);
				long leftsubtree = countBST(i); 
				sum+=(leftsubtree*rightsubtree);
			}
			return sum;
		}
	}
	public static void main(String[] args) {
		int t=sc.nextInt();
		int[] a=new int[t];
		int j=0;
		while(j<t)
		{
			a[j]=sc.nextInt();
			j++;
		}
		System.out.println(countBST(t));
	}
}
