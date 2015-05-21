package com.algo.simple;

/*
 * N tasks are written down in the form of a circular list, so the first task is adjacent to the last one. 
 * A number n is also given. Starting with the first task, move clockwise 
 * (from element 1 in the list to element 2 in the list and so on), counting from 1 to n. 
 * When your count reaches n, remove that task from the list and start counting from the next available task.
 *  Repeat this procedure until one task remains. Return it.
 * 
 */
public class BusinessTasks 
{
	public static void main(String args[])
	{
		String a[] = {"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp",
				"olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu",
				"qgcxjbfx","my","mlhy","bt","bo","q"};
		int n = 9000000;
		System.out.println("Task selected:" + getTask(a, n-1));
	}
	
	public static String getTask(String[] list, int n)
	{
		String task = null;
		int counter = 0;
		int i = 0;
		while (list.length > 1)
		{
			counter = 0;
			while (counter < n)
			{
				counter++;
				i++;
				if (i >= list.length)
				{
					i = 0;
				}
			}
			list = remove(list, i);
			if (i >= list.length)
			{
				i = 0;
			}
		}
		task = list[0];
		return task;
	}
	
	public static String[] remove(String[] list, int index)
	{
		String a[] = new String[list.length-1];
		int j = 0;
		for (int i = 0; i < list.length; i++)
		{
			if (i == index)
			{
				System.out.println("Removing: " + list[i]);
				continue;
			}
			a[j] = list[i];
			j++;
		}
		return a;
	}
}
