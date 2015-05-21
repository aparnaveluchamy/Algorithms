package com.algo.ds;

public class LinkedList 
{
	String _data;
	LinkedList _next;
	
	public LinkedList(String data)
	{
		_data = data;
	}
	
	public String getData()
	{
		return _data;
	}
	
	public LinkedList getNext()
	{
		return _next;
	}
	
	public void setNext(LinkedList next)
	{
		_next = next;
	}
}
