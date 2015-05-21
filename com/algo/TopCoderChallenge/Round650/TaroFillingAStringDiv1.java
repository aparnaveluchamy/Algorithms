package com.algo.TopCoderChallenge.Round650;

public class TaroFillingAStringDiv1 
{
	public static void main(String args[])
	{
		TaroFillingAStringDiv1 obj = new TaroFillingAStringDiv1();
		System.out.print(obj.getNumber(25, new int[]{23, 4, 8, 1, 24, 9, 16, 17, 6, 2, 25, 15, 14, 7, 13}, "ABBBBABABBAAABA"));
	}
	//TODO
	public int getNumber(int N, int[] position, String value)
	{
		StringBuilder newString = new StringBuilder();
		
		for (int i = 1; i <= N; i++)
		{
			int pos = findPosition(position, i);
			if (pos > 0)
			{
				newString.append(value.charAt(pos-1));
			}
			else
			{
				newString.append("X");
			}
		}
		
		
		return 0;
	}
	
	private int ugliness(String value)
	{
		int ugli = 0;
		char prev = value.charAt(0);
		for (int i = 1; i < value.length(); i++)
		{
			if (prev == value.charAt(i))
			{
				ugli++;
			}
			prev = value.charAt(i);
		}
		return ugli;
	}
	
	private int findPosition(int[] position, int pos)
	{
		for (int i = 0; i < position.length; i++)
		{
			if (position[i] == pos)
			{
				return i++;
			}
		}
		return -1;
	}
}
