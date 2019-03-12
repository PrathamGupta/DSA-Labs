import java.util.Scanner;

class Node
{
	int data;
	Node left , right;

	public Node(int d)
	{
		data = d;
		left = null;
		right = null;
	}
}

public class Lab8_SecA
{
	Node root;

	public int showParent(int d)
	{
		if(root.data == d)
			return 0;
		Node tr = root;
		Node parent;
		while(true)
		{
			parent = tr;
			if(tr.left.data == d || tr.right.data == d)
				return parent.data;
			else if(d < tr.data)
				tr = tr.left;
			else
				tr = tr.right;
		}
	}

	public void addNode(int d)
	{
		Node add = new Node(d) ;
		if(root == null)
		{
			root = add;
			return ;
		}
		else
		{
			Node tr = root;
			Node parent;
			while(true)
			{
				parent = tr;
				if(d < tr.data)
				{	tr = tr.left;
					if(tr == null)
					{
						parent.left = add;
						return ;
					}
				}
				else
				{
					tr = tr.right;
					if(tr == null)
					{
						parent.right = add;
						return ;
					}
				}
			}
		}
	}

	public static void makeTree(Lab8_SecA tree , int a[] , int s , int e)
	{
		if(s == e)
			return ;
		int mid = (int) (s+e)/2;
		tree.addNode(a[mid]);
		makeTree(tree , a , s , mid);
		makeTree(tree , a , mid+1 , e);
	}

	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int a[] = new int[n];
		for(int i=0 ; i<n ; i++)
			a[i] = cin.nextInt();

		Lab8_SecA tree = new Lab8_SecA();
		makeTree(tree , a , 0 , n);
		for(int i=0 ; i<n ;i++)
			System.out.print(tree.showParent(a[i]) + " ");
	}
}
