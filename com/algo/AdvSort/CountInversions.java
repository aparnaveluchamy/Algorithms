package com.algo.AdvSort;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.algo.common.ReadFileToArray;

public class CountInversions 
{
	static long _count = 0;
	public static void main(String args[])
	{
		ReadFileToArray reader = new ReadFileToArray();
		ArrayList<Integer> numbers = reader.readFile(new File("C:/Users/IBM_ADMIN/Desktop/Worklight/Projects/Algorithms/data/IntegerArray.txt"));
		countSortInversions(numbers, 0 , numbers.size()-1);
		System.out.println("Number of Inversions:" + _count);
	}

	private static ArrayList<Integer> countSortInversions(ArrayList<Integer> numbers, int start, int end) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (end-start >= 1)
		{
			List<Integer> a = countSortInversions(numbers, start, start + ((end-start)/2));
			List<Integer> b = countSortInversions(numbers, start +((end-start)/2) + 1, end);
			result = splitInversions(a, b);
		}
		else
		{
			result.add(numbers.get(start));
		}

		return result;
	}
	
	private static ArrayList<Integer> splitInversions(List<Integer> a, List<Integer> b)
	{
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		if (a != null || b != null)
		{
			int cLength = a.size()+ b.size();
			int ai = 0;
			int bi= 0;
			for (int i = 0; i< cLength ; i++)
			{
				if (ai < a.size() && bi < b.size() && a.get(ai) < b.get(bi))
				{
					sorted.add(a.get(ai));
					ai++;				
				}
				else if (ai < a.size() && bi < b.size() && a.get(ai) > b.get(bi))
				{
					sorted.add(b.get(bi));
					bi++;
					_count += a.size() - ai;
				}
				else if (ai < a.size())
				{
					sorted.add(a.get(ai));
					ai++;
				}
				else if (bi < b.size())
				{
					sorted.add(b.get(bi));
					bi++;
				}
			}
		}
		return sorted;
	}
}
