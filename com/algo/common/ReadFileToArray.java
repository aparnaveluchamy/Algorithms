package com.algo.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileToArray 
{
	public ArrayList<Integer> readFile(File file)
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		try
		{
			FileReader fs = new FileReader(file);
			BufferedReader br = new BufferedReader(fs);
			String number;
			while ((number = br.readLine()) != null)
			{
				numbers.add(Integer.parseInt(number));
			}
			br.close();
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numbers;
	}
}
