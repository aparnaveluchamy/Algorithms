package com.algo.stringmanipulation;

public class Quipu
{
	public static void main(String args[])
	{
		System.out.println(readKnots("-XX--XXXX---XXX-"));
	}
	
	public static int readKnots(String knots)
	{
		int number = 0;
		char prev = knots.charAt(knots.length()-1);
		int count = 1;
		int digit = 0;
		for (int i = knots.length() - 2; i >= 0; i--)
		{
			if (prev == knots.charAt(i))
			{
				count++;
			}
			else 
			{
				if (knots.charAt(i) == '-')
				{
					number += count * Math.pow(10, digit);
					digit++;
				}
				else
				{
					if (count > 1)
					{
						digit += count - 1;
					}
				}
				count = 1;
			}
			prev = knots.charAt(i);
		}
		return number;
	}
}
