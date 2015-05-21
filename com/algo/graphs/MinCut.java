package com.algo.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class MinCut
{
	HashMap<Integer, Edge> _edges = new HashMap<Integer, Edge>();
	HashMap<Integer, ArrayList<Integer>> _adjList = new HashMap<Integer, ArrayList<Integer>>();
	int _numberOfEdges;
	
	public void printEdges()
	{
		for (int i = 1; i < _numberOfEdges + 1; i++)
		{
			if (_edges.get(i) != null)
			{
				System.out.print("[" + _edges.get(i).getV1() +", " + _edges.get(i).getV2() + "]");
			}
		}
		System.out.println();
	}
	
	public void printAdjacency()
	{
		for (int key : _adjList.keySet())
		{
			System.out.print(key + "-->" + _adjList.get(key).toString());
		}
		System.out.println();
	}
	
	public int findMinCut(HashMap<Integer, ArrayList<Integer>> adjList, HashMap<Integer, Edge> edges)
	{
		_numberOfEdges = edges.size();
		_edges.clear();
		_edges.putAll(edges);
		_adjList.clear();
		_adjList.putAll(adjList);
		
		while (_adjList.keySet().size() > 2)
		{
			//printEdges();
			//printAdjacency();
			int index = pickAnEdge();
			Edge edge = _edges.get(index);
			//System.out.println("Selected Edge: " + edge.getV1() + ", " + edge.getV2());
			merge(edge);
			_edges.remove(index);
			removeDuplicates(edge);
			removeReverse(edge);
			adjustEdges(edge);
			removeCycles();
		}
		//printEdges();
		//printAdjacency();
		return (_edges.size());
	}
	
	private void removeCycles() 
	{
		//remove duplicates
		for (int i = 1; i <= _numberOfEdges; i++)
		{
			if (_edges.get(i) != null)
			{
				Edge edge = _edges.get(i);
				if (edge.getV1() == edge.getV2())
				{
					_edges.remove(i);
				}
			}
		}

	}

	private void removeDuplicates(Edge selectedEdge)
	{
		//remove duplicates
		for (int i = 1; i <= _numberOfEdges; i++)
		{
			if (_edges.get(i) != null)
			{
				Edge edge = _edges.get(i);
				if (edge.getV1() == selectedEdge.getV1() && edge.getV2() == selectedEdge.getV2())
				{
					_edges.remove(i);
				}
			}
		}

	}

	private void removeReverse(Edge selectedEdge)
	{
		//remove reverse incidence
		for (int i = 1; i <= _numberOfEdges; i++)
		{
			if (_edges.get(i) != null)
			{
				Edge edge = _edges.get(i);
				if (edge.getV1() == selectedEdge.getV2() && edge.getV2() == selectedEdge.getV1())
				{
					_edges.remove(i);
				}
			}
		}

	}

	private void adjustEdges(Edge selectedEdge)
	{
		//adjust edges for merged vertices
		for (int i = 1; i <=_numberOfEdges; i++)
		{
			if (_edges.get(i) != null)
			{
				Edge edge = _edges.get(i);
				if (edge.getV1() == selectedEdge.getV2())
				{
					edge.setV1(selectedEdge.getV1());
				}
				else if (edge.getV2() == selectedEdge.getV2())
				{
					edge.setV2(selectedEdge.getV1());
				}
			}
		}
	}

	private void merge(Edge selectedEdge) 
	{
		//System.out.println("Selected Edge: " + selectedEdge.getV1() + ", " + selectedEdge.getV2());
		ArrayList<Integer> merged = new ArrayList<Integer>();
		for (int v1 : _adjList.get(selectedEdge.getV1()))
		{
			if (v1 == selectedEdge.getV2())
			{
				//remove the selected edge
			}
			else
			{
				merged.add(v1);
			}
		}
		if (_adjList.get(selectedEdge.getV2()) == null)
		{
			System.out.println("test");
		}
		for (int v2 : _adjList.get(selectedEdge.getV2()))
		{
			if (v2 == selectedEdge.getV1())
			{
				//remove cycle
			}
			else
			{
				merged.add(v2);
			}
		}
		_adjList.put(selectedEdge.getV1(), merged);
		_adjList.remove(selectedEdge.getV2());
	}

	private int pickAnEdge()
	{
		while(true)
		{
			int rand = (int)(Math.random() * (_numberOfEdges));
			if (_edges.get(rand) != null)
			{
				return rand;
			}
		}
	}
	
}
