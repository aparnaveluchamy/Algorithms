package com.algo.simple;

public class SudokuSwap 
{
	int swapPairs[][] = new int[2][2];
	
	public static void main(String args[])
	{
		
	}
	
	public void findSwap(int a[][])
	{
		int swapPairs[][] = new int[4][2];
		int c1=0;
		Boolean found[] = new Boolean[9];
		// row-wise
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if (found[a[i][j]] == true)
				{
					if (checkColumn(a, a[i][j],j))
					{
						swapPairs[c1][0] = i;
						swapPairs[c1][j] = j;
						c1++;
					}
					else if (checkGrid(a, a[i][j], i, j))
					{
						
					}
					else
					{
						for (int k=0;k<j;k++){
							if (a[i][k] == a[i][j]){
								if (checkColumn(a, a[i][k], k)){
									swapPairs[c1][0] = i;
									swapPairs[c1][j] = j;
									c1++;
								}
								else if (checkGrid(a, a[i][j], i, j))
								{
									
								}
							}

						}
					}
				}
				else
				{
					found[a[i][j]] = true;
				}
			}
		}
		
		// column-wise
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if (found[a[j][i]] == true)
				{
					checkGrid(a, a[j][i], -1, j);
				}
				else
				{
					found[a[j][i]] = true;
				}
			}
		}
		
		//grid-wise
		
	}
	
	public boolean checkRow()
	{
		return false;
	}
	
	public boolean checkColumn(int a[][], int element, int column)
	{
		Boolean found[] = new Boolean[9]; 
		for (int i=0; i<9; i++)
		{
			if (found[a[i][column]] == true && a[i][column] == element)
			{
				return true;
			}
			else
			{
				found[a[i][column]] = true;
			}
		}
		return false;
	}
	
	public boolean checkGrid(int a[][], int element, int row, int column)
	{
		Boolean found[] = new Boolean[9]; 
		for (int i= row/3; i<=row/3+3; i++){
			for (int j=0; j<column/3+3; j++){
				if (found[a[i][j]] == true && a[i][j] == element)
				{
					return true;
				}
				else
				{
					found[a[i][j]] = true;
				}
			}
		}
		return false;
	}
}
