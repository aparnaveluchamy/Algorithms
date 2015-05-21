package com.algo.simple;

/*
 * Let's assume that there's an array that has nonzero natural numbers where all the numbers repeat
 *  an even number of times, except for one value that repeats an odd number of times. 
 *  Can you write me a function that takes this array, and returns the value that occurs the odd number of times? 

Ex : - [ 4, 7, 2, 2, 5, 3, 5, 7, 7, 3, 4, 5 ]
 */
public class FindOddOccuranceNumber
{
	public static void main(String args[])
	{
		int a[]= {4, 7, 2, 2, 5, 3, 5, 7, 7, 3, 4, 5};
		int num =0;
		for (int i=0; i<a.length;i++)
		{
			num=num^a[i];
		}
		System.out.println(num);
	}
	
}
