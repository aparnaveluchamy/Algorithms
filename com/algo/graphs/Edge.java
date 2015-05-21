package com.algo.graphs;

public class Edge 
{
	private int _V1, _V2;
	public Edge(int V1, int V2)
	{
		_V1 = V1;
		_V2 = V2;
	}
	
	public int getV1()
	{
		return _V1;
	}
	
	public int getV2()
	{
		return _V2;
	}	
	
	public void setV1(int V1)
	{
		_V1 = V1;
	}
	
	public void setV2(int V2)
	{
		_V2 = V2;
	}
}
