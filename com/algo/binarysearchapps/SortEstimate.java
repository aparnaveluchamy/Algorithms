package com.algo.binarysearchapps;

/*
 * 	You have implemented a sorting algorithm that requires exactly c*n*lg(n) nanoseconds to sort n integers.
 *  Here lg denotes the base-2 logarithm. Given time nanoseconds, return the largest double n such that c*n*lg(n) <= time.
 */
public class SortEstimate 
{
	public static void main(String args[])
	{
		SortEstimate srtEst = new SortEstimate();
		System.out.println(srtEst.howMany(5, 100));
	}

	public double howMany(int c, int time)
	{
		double mid = 0;
		double low = 0;
		double high = time;
		double prevMid = 0;
		while (high - low >= 1e-9)
		{
			mid = (high + low)/2;
			double val = (c * mid * (Math.log(mid)/Math.log(2)));
			if (time == val)
			{
				return mid;
			}
			else if (val < time)
			{
				low = mid;
			}
			else
			{
				high = mid;
			}
			
			if (prevMid == mid)
				return mid;
			System.out.println(mid);
			prevMid = mid;
		}
		return mid;
	}
}
