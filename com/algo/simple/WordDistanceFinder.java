package com.algo.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 * WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 * assert(finder.distance("fox","the") == 3);
 * assert(finder.distance("quick", "fox") == 1);

 */
public class WordDistanceFinder 
{
	String[] _words;
	public WordDistanceFinder(List<String> words)
	{
		_words = (String[]) words.toArray();
	}
	
	public int findDistance(String a, String b)
	{
		if (a.equals(b))
		{
			return 0;
		}
		ArrayList<Integer> indexOfStringA = new ArrayList<Integer>();
		ArrayList<Integer> indexOfStringB = new ArrayList<Integer>();
		for (int i=0; i< _words.length;i++)
		{
			String word = _words[i];
			if (word.equals(a))
			{
				indexOfStringA.add(i);
			}
			else if (word.equals(b))
			{
				indexOfStringB.add(i);
			}
		}
		
		// findMin
		int distance = 100000;
		for (int i=0;i<indexOfStringA.size(); i++)
		{
			for (int j=0;j<indexOfStringB.size(); j++)
			{
				if (distance > Math.abs(indexOfStringA.get(i) - indexOfStringB.get(j)))
				{
					distance = Math.abs(indexOfStringA.get(i) - indexOfStringB.get(j));
				}
			}
		}
		if (distance < 100000)
			return distance;
		else
			return -1;
	}
	
	public static void main(String args[])
	{
		 WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
		 finder.findDistance("quick", "fox");
	}
}
