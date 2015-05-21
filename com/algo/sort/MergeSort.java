package com.algo.sort;


public class MergeSort 
{
	public static void main(String args[])
	{
		int[] A = {7, 4, 3, 8, 1, 2, 9, 6, 5};		
		int[] sortedA = sort(A, 0, A.length - 1);
		System.out.println(sortedA);
	}
	
	public static int[] sort(int[] a, int start, int end)
	{
		int[] result = new int[(end-start) + 1];
		if ((end-start) >= 1)
		{
			int b[] = sort(a, start, start + ((end-start)/2));
			int c[] = sort(a, start +((end-start)/2) + 1, end);
			result = merge(b,c);
		}
		
		if (end == start)
		{
			result[0]= a[start];
		}
		return result;
		
	}
	
	private static int[] merge(int[] a, int[] b)
	{
		int cLength = a.length + b.length;
		int[] c = new int[cLength];
		int ai = 0;
		int bi= 0;
		for (int i = 0; i< cLength ; i++)
		{
			if (ai < a.length && bi < b.length && a[ai] < b[bi])
			{
				c[i] = a[ai++];				
			}
			else if (bi < b.length)
			{
				c[i] = b[bi++];
			}
			else if (ai < a.length)
			{
				c[i] = a[ai++];
			}
		}
		return c;
	}
}
