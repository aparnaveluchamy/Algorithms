package com.algo.graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RunMinCutMultipleTimes 
{
	static HashMap<Integer, Edge> _edges1 = new HashMap<Integer, Edge>();
	static HashMap<Integer, ArrayList<Integer>> _adjList1 = new HashMap<Integer, ArrayList<Integer>>();
	
	public static void main(String args[])
	{
		int N = 200;
		int min = 10000;
		
		readFile();
		for (int i = 0; i < N; i++)
		{	
			MinCut minC = new MinCut();
			int minCut = minC.findMinCut(_adjList1, _edges1);
			if (minCut < min)
			{
				min = minCut;
				//System.out.println(min);
			}
		}
		System.out.println("Overall min : " + min);
	}
	
	public static void readFile()
	{
		try 
		{
			FileReader fs = new FileReader(new File("C:/Users/IBM_ADMIN/Desktop/Worklight/Projects/Algorithms/data/kargerMinCut.txt"));
			BufferedReader br = new BufferedReader(fs);
			String line;
			int i = 1; 
			while ((line = br.readLine()) != null)
			{
				StringTokenizer strTkn = new StringTokenizer(line, "\t");
				int vertex = Integer.parseInt(strTkn.nextToken().replace(" ", "")); 
				ArrayList<Integer> incidentVertices = new ArrayList<Integer>(); 
				while (strTkn.hasMoreTokens())
				{
					int incidentVertex = Integer.parseInt(strTkn.nextToken());
					_edges1.put(i++, new Edge(vertex, incidentVertex));
					incidentVertices.add(incidentVertex);
				}
				_adjList1.put(vertex,  incidentVertices);
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
	}
	
}
