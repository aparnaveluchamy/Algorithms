package com.algo.sort;

public class HeapSort 
{
	public static void main(String args[])
	{
		HeapSort sort = new HeapSort();
		int a[] = {2,5,4,1,3};
		int n = a.length;
		sort.heapify(a, n);
		while(n>0)
		{
			System.out.println(sort.extractMin(a, n));
			n--;
		}
	}
	
	private int[] heapify(int[] a, int n)
	{
		for (int i = n-1; i > 0; i--)
		{
			if (a[i] < a[(i-1)/2])
			{
				int t = a[(i-1)/2];
				a[(i-1)/2] = a[i];
				a[i] = t;
			}
		}
		return a;
	}
	
	private int extractMin(int[] a, int n)
	{
		int min = a[0];
		a[0] = a[n-1];
		a[n-1] = 0;
		heapify(a, n-1);
		return min;
	}
}
