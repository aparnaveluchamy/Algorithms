package com.algo.simple;

//TopCoder SRM 144 Division 1 
public class BinaryCode 
{
	public static void main(String args[])
	{
		BinaryCode code = new BinaryCode();
		String arr[] = code.decode("122");
		for (int i=0;i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public String[] decode(String message)
	{
		String result[] = new String[2];
		for (int j =0; j <=1; j++)
		{
			StringBuffer decode = new StringBuffer("" + j);
			int i;
			for (i=0;i<message.length()-1; i++)
			{
				int curr = message.charAt(i) - 48;
				int prev =0;
				if (i-1>=0)
				{
					prev = decode.charAt(i-1)-48;
				}
				int diff = curr - (decode.charAt(i)-48) - prev;
				int sum = prev + (decode.charAt(i)-48) + diff;
				if ((diff ==0 || diff ==1) && sum == curr)
				{
					decode.append("" + diff);
				}
				else
				{
					decode = new StringBuffer("NONE");
					break;
				}
			}
			
			if ((decode.charAt(i) + decode.charAt(i-1) - 96) == (message.charAt(i)-48))
			{
				result[j] = decode.toString();
			}
			else
			{
				result[j] = "NONE";
			}
		}
		return result; 
	}
}
