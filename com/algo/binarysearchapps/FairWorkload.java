package com.algo.binarysearchapps;

public class FairWorkload 
{
	public static void main(String args[])
	{
		int folders[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		int workers = 3;
		FairWorkload workLoad = new FairWorkload();
		System.out.println(workLoad.getMostWork(folders, workers));
	}
	
	public boolean could( int[] folders, int workers, int max )
	{
		int cur = 0;
		for ( int i = 0; i < folders.length; i++ )
		{
			System.out.print(cur + ":" + max +",");
			cur += folders[i];
			if ( cur > max ) 
			{
				cur = folders[i];
				workers--;
			}
			if ( cur > max ) 
			{
				return false;
			}
		}
		return workers > 0;
	}

	public int getMostWork(int[] folders, int workers) 
	{
		for ( int i = 0; true; i=i+10 )
		{
			if ( could( folders, workers, i ) ) 
			{
				return i;
			}
		}
	}
}
