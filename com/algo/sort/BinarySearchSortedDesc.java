package com.algo.sort;

public class BinarySearchSortedDesc 
{
	public static void main(String args[])
	{
		int a[] = {8, 7, 5, 3, 1};
		binarySearchSortedDesc(a, 5, 0, a.length);
	}
	
	public static void binarySearchSortedDesc(int a[], int x, int start, int end)
	{
		if (x > a[start + ((end-start)/2)])
		{
			binarySearchSortedDesc(a, x, start, start + ((end-start)/2));
		}
		else if (x == a[start + ((end-start)/2)])
		{
			System.out.print(x + " Found at a[" + (start + ((end-start)/2)) + "]");
		}
		else
		{
			binarySearchSortedDesc(a, x, start + ((end-start)/2 + 1), end);
		}
	}

}
