package com.algo.simple;

/*
 * A group of people stands before you arranged in rows and columns. 
 * Looking from above, they form an R by C rectangle of people. 
 * Your job is to return 2 specific heights - the first is computed by finding the shortest person in each row, 
 * and then finding the tallest person among them (the "tallest-of-the-shortest"); 
 * and the second is computed by finding the tallest person in each column, 
 * and then finding the shortest person among them (the "shortest-of-the-tallest").
 */
public class TallPeople 
{
	public static void main(String args[])
	{
		TallPeople tallPeople = new TallPeople();
		String a[] = {"1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 4 5", "3 4 1 9 8 2 3 4 1 4 5 8 4 1 1 3 4 5 7 8 3 4 2"};
		int result[] = tallPeople.getPeople(a);
		System.out.println(result[0] + ", " + result[1]);
	}
	
	public int[] getPeople(String a[])
	{
		int result[] = new int[2];
		result[1] = 1001;
		int[] tallestColumns = new int[23];
		for (int i = 0; i < a.length; i++)
		{
			int shortest = 1001;
			int colJ = -1;
			for (int j = 0; j < a[i].length(); j++)
			{
				if (a[i].charAt(j) == (' '))
				{
					continue;
				}
				int number = (Integer.parseInt("" + a[i].charAt(j)));
				colJ++;
				if (shortest > number)
				{
					shortest = number;
				}
				if (tallestColumns[colJ] < number)
				{
					tallestColumns[colJ] = number;
				}
			}
			if (result[0] < shortest)
			{
				result[0] = shortest;
			}
		}
		for (int i = 0; i < tallestColumns.length; i++)
		{
			if (result[1] > tallestColumns[i] && tallestColumns[i] != 0)
			{
				result[1] = tallestColumns[i];
			}
		}
		return result;
	}
}
