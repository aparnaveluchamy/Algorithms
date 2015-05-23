package com.algo.simple;

//TopCoder SRM 144 Division 1 
/*
 * Problem Statement
    
Let's say you have a binary string such as the following:
011100011
One way to encrypt this string is to add to each digit the sum of its adjacent digits. For example, the above string would become:
123210122
In particular, if P is the original string, and Q is the encrypted string, then Q[i] = P[i-1] + P[i] + P[i+1] for all digit positions i. Characters off the left and right edges of the string are treated as zeroes.
An encrypted string given to you in this format can be decoded as follows (using 123210122 as an example):
Assume P[0] = 0.
Because Q[0] = P[0] + P[1] = 0 + P[1] = 1, we know that P[1] = 1.
Because Q[1] = P[0] + P[1] + P[2] = 0 + 1 + P[2] = 2, we know that P[2] = 1.
Because Q[2] = P[1] + P[2] + P[3] = 1 + 1 + P[3] = 3, we know that P[3] = 1.
Repeating these steps gives us P[4] = 0, P[5] = 0, P[6] = 0, P[7] = 1, and P[8] = 1.
We check our work by noting that Q[8] = P[7] + P[8] = 1 + 1 = 2. Since this equation works out, we are finished, and we have recovered one possible original string.
Now we repeat the process, assuming the opposite about P[0]:
Assume P[0] = 1.
Because Q[0] = P[0] + P[1] = 1 + P[1] = 1, we know that P[1] = 0.
Because Q[1] = P[0] + P[1] + P[2] = 1 + 0 + P[2] = 2, we know that P[2] = 1.
Now note that Q[2] = P[1] + P[2] + P[3] = 0 + 1 + P[3] = 3, which leads us to the conclusion that P[3] = 2. However, this violates the fact that each character in the original string must be '0' or '1'. Therefore, there exists no such original string P where the first digit is '1'.
Note that this algorithm produces at most two decodings for any given encrypted string. There can never be more than one possible way to decode a string once the first binary digit is set.
Given a String message, containing the encrypted string, return a String[] with exactly two elements. The first element should contain the decrypted string assuming the first character is '0'; the second element should assume the first character is '1'. If one of the tests fails, return the string "NONE" in its place. For the above example, you should return {"011100011", "NONE"}.
 */

public class BinaryCode 
{
	public static void main(String args[])
	{
		BinaryCode code = new BinaryCode();
		String arr[] = code.decode("22111");
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
			
			if (i>0 && (decode.charAt(i) + decode.charAt(i-1) - 96) == (message.charAt(i)-48))
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
