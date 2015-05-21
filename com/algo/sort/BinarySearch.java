package com.algo.sort;

public class BinarySearch
{
	public static void main(String args[])
	{
		int a[] = { 1, 3, 5, 7, 8};
		binarySearch(a, 8, 0, a.length);
	}
	
	public static void binarySearch(int a[], int x, int start, int end)
	{
		if (x < a[start + ((end-start)/2)])
		{
			binarySearch(a, x, start, start + ((end-start)/2));
		}
		else if (x == a[start + ((end-start)/2)])
		{
			System.out.print(x + " Found at a[" + (start + ((end-start)/2)) + "]");
		}
		else
		{
			binarySearch(a, x, start + ((end-start)/2 + 1), end);
		}
	}
}
