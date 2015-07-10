package com.algo.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals implements Comparator<Interval>
{
	public static void main(String args)
	{
		MergeOverlappingIntervals sorter = new MergeOverlappingIntervals();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(-2, 3));
		intervals.add(new Interval(9, 10));
		intervals.add(new Interval(7,8));
		Collections.sort(intervals, sorter);
		
		for (int i=1; i < intervals.size(); i++)
		{
			if (intervals.get(i).start <= intervals.get(i).end)
			{
				
			}
		}
	}
	public int compare(Interval i1, Interval i2)
	{
		if (((Interval)i1).start > ((Interval)i1).start)
			return 1;
		else
			return -1;
	}
}

class Interval 
{
	int start;
	int end;
	
	Interval(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
}