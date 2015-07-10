package com.algo.simple;

public class Exponents 
{
	private static int count =0;
	public static void main(String args[])
	{
		System.out.println(power(2,25));
		System.out.println(count);
	}
	
	public static int power(int a, int b)
	{
		
		if (b == 0)
		{
			return 1;
		}
		
		if (b < 0)
		{
			b= Math.abs(b);
		}
		int result = pow(a,b);
		if (b<0)
		{
			result = 1/result;
		}
		
		return result;
	}
	
	public static int pow(int a, int b)
	{
		int result = 1;
		if (b == 0)
		{
			return 1;
		}
		if (b%2 == 0)
		{
			result = pow(a,b/2);
			result = result * result;
			//result = result * a * a * pow(a, b-2);
			count++;
		}
		else
		{
			result = a * pow(a, b-1);
			//result = result * a * pow(a,b-1);
			count++;
		}
		return result;
	}
}
