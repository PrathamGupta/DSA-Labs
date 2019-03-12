package Lab;
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	public Node(int a) {
		data=a;
		left=null;
		right=null;
	}
}

class Tree{
	Node parent;
	
	public Tree() {
		parent=null;
	}
	
	public void setParent(int a) {
		Node root=new Node(a);
		if(parent==null)
		{
			parent=root;
		}
	}
	
	public Node searchParent(Node root, int target) {
		Node current=root;
		while(current!=null)
		{
			if(current.left.data==target || current.right.data==target) {
				return current;
			}
			else if(current.data>target)
			{
				return searchParent(current.left, target);
			}
			else {
				return searchParent(current.right, target);
			}
		}
		return null;
	}
}

public class Thurs {
	static Scanner sc=new Scanner(System.in);
	
	public static Node create(int[] ar, int l, int r)
	{
		if(r<=l)
		{
			System.out.println("Ended here");
			return null;
		}
		int m=(r-l)/2;
		System.out.println("m is "+m);
		Node root=new Node(ar[m]);
		root.left=create(ar, l, m);
		root.right=create(ar, m+1, r);
		return root;
	}
	
	public static void main(String[] args) {
		int n=sc.nextInt();
		Tree ob=new Tree();
		int[] arr=new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i]=sc.nextInt();		
		}
		ob.parent=create(arr, 0, n-1);
		for(int i=0; i<n; i++)
		{
			Node ans=ob.searchParent(ob.parent, arr[i]);
			System.out.println("Answer : "+ans.data);
		}
	}
	
}
