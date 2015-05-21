package com.algo.sort;

import java.io.File;
import java.util.ArrayList;

import com.algo.common.ReadFileToArray;

public class QuickSort
{
	static int count = 0;
	public static void main(String args[])
	{
		//int A[] = {3,8,2,5,1,4,7,9,6,0};
		ReadFileToArray reader = new ReadFileToArray();
		ArrayList<Integer> numbers = reader.readFile(new File("C:/Users/IBM_ADMIN/Desktop/Worklight/Projects/Algorithms/data/QuickSort.txt"));
		quickSort(numbers, 0, numbers.size()-1);
		//for(Integer a: sortedA)
		{
			System.out.print(count);
		}//
	}

	private static ArrayList<Integer> quickSort(ArrayList<Integer> a, int left, int right)
	{
		if (right-left > 0)
		{
			count += right - left;
			int pivotIndex = getMedian(a, left, left + (right-left)/2, right);
			int temp = a.get(pivotIndex);
			a.set(pivotIndex, a.get(left));
			a.set(left, temp);
			int pivot = a.get(left);
			int i = left + 1;
			for (int j = i; j <= right; j++)
			{
				if(a.get(j) > pivot)
				{
					//
				}
				else if (a.get(j) < pivot)
				{
					temp = a.get(i);
					a.set(i, a.get(j));
					a.set(j, temp);
					i++;
				}
			}
			a.set(left, a.get(i-1));
			a.set(i-1, pivot);
			
			quickSort(a, left, i-2);
			quickSort(a, i, right);
		}

		return a;
	}

	private static int getMedian(ArrayList<Integer> a, int left, int i, int right) 
	{
		int b[] = {a.get(left), a.get(i), a.get(right)};
		b = MergeSort.sort(b, 0, 2);
		
		if (b[1] == a.get(left))
		{
			return left;
		}
		else if (b[1] == a.get(i))
		{
			return i;
		}
		return right;
	}
}
