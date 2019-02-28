import java.util.*;


public class Answer_Part1 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int n=sc.nextInt();
		int[] ar=new int[n];
		int k=sc.nextInt();
		for(int i=0; i<n; i++)
		{
			ar[i]=sc.nextInt();
		}
		long min=0;
		long sum=0;
		for(int i=0; i<k; i++)
		{
			sum+=ar[i];
		}
		min=sum;
		int st=0,ed=k;
		while(ed<n)
		{
//			ed++;
			sum-=ar[st];
			sum+=ar[ed];
			st++;
			ed++;
			if(sum<min)
			{
				min=sum;
			}
		}
		System.out.println(min);
	}
}
