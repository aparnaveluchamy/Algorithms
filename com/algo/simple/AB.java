package com.algo.simple;

import java.util.ArrayList;

public class AB 
{
	public static void main(String args[])
	{
		AB ab = new AB();
		ab.findAllCombinations("", 10);
		
		System.out.println(ab.createString(10, 5));
	}
	
	private ArrayList<String> list = new ArrayList<String>();
	
	void findAllCombinations(String prefix, int N)
	{
		if (N == 1)
		{
			list.add(prefix + "A");
			list.add(prefix + "B");
		}
		else if (N>1)
		{
			findAllCombinations(prefix + "A", N-1);
			findAllCombinations(prefix + "B", N-1);
		}
	}
	
	String createString(int N, int K)
	{
		if (K>((N*N)/4))
		{
			return "";
		}
		
		int i;
		for (i=1;i<=N; i++)
		{
			if (K <= i*(N-i))
			{
				break;
			}
		}
		
		int end = N;
		boolean found = false;
		if (K < i*(N-i))
		{
			for (int j=1;j<(N-i);j++)
			{
				if (K == i*(N-i-j))
				{
					end = end-j;
					found = true;
					break;
				}
			}
			if (! found)
			{
				return "";
			}
		}
		StringBuffer result = new StringBuffer("");
		for (int j=0;j<i;j++)
		{
			result.append("A");
		}
		for (int j=i;j<end;j++)
		{
			result.append("B");
		}
		for (int j=end;j<N;j++)
		{
			result.append("A");
		}
		return result.toString();
	}
	
}
