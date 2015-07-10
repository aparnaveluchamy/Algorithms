package com.algo.Tree;

import java.util.LinkedList;
/* 

Tree: 
1 
/ \ 
3 5 
/ \ \ 
2 4 7 
/ \ \ 
9 6 8 

========== 
Expected Output: 
1 
35 
247 
968 
*/ 
class PrintBST { 

	static class Node 
	{ 
		int value; 
		Node left; 
		Node right; 
		public Node(int value, Node left, Node right) 
		{ 
			this.value = value; 
			this.left = left; 
			this.right = right; 
		} 
	} 

	public void printLevelOrderTree(Node root)
	{ 
		// implementation here
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		LinkedList<Node> children = new LinkedList<Node>();
		while (! list.isEmpty())
		{
			Node node = list.remove();
			System.out.print(node.value);
			if (node.left != null)
			{
				children.add(node.left);
			}
			if (node.right != null)
			{
				children.add(node.right);
			}
			if (list.isEmpty())
			{
				if (! children.isEmpty())
				{
					System.out.println();
					list = children;
					children = new LinkedList<Node>();
				}
			}
		}
	}	
	
	public static void main(String args[])
	{
		Node root = new Node(1, new Node(3, new Node(2, new Node(9,null,null), new Node(6,null,null)), new Node(4, null, new Node(8,null,null))), new Node(5, null, new Node(7, null, null)));
		PrintBST printBST = new PrintBST();
		printBST.printLevelOrderTree(root);
	}
}