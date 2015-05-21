package com.algo.stringmanipulation;

public class Poetry 
{
	public static void main(String args[])
	{
		Poetry poem = new Poetry();
		System.out.println(poem.rhymeScheme(new String [] {"too bad   your",
				 "     solution went   sour"}));
	}
	
	public String rhymeScheme(String[] poem)
	{
		//assumes a pattern can repeat only contiguously
		//improvise it to detect patterns in any line
		String rhyme = "";
		String prevPattern = "";
		int rhymeScheme = 96;
		String pattern;
		for (String thisLine : poem)
		{
			thisLine = thisLine.trim();
			pattern = "";
			int last = thisLine.lastIndexOf(" ");
			String lastWord;
			if (last > 0)
			{
				lastWord = thisLine.substring(thisLine.lastIndexOf(" ") + 1);
			}
			else
			{
				lastWord = thisLine;
			}
			int i;
			boolean vowelFound = false;
			for (i = lastWord.length()-1; i >= 0; i--)
			{
				if (lastWord.charAt(i) == 'a' || lastWord.charAt(i) == 'e' ||
						lastWord.charAt(i) == 'i' || lastWord.charAt(i) == 'o' || lastWord.charAt(i) == 'u' || 
						(i > 0 && lastWord.charAt(i) == 'y') ||lastWord.charAt(i) == 'A' || lastWord.charAt(i) == 'E' ||
								lastWord.charAt(i) == 'I' || lastWord.charAt(i) == 'O' || lastWord.charAt(i) == 'U' || 
								(i > 0 && lastWord.charAt(i) == 'Y'))
				{
					vowelFound = true;
					break;
				}
			}
			
			if (vowelFound)
			{
				pattern = lastWord.substring(i);

				for (int j = i-1 ; j >= 0; j--)
				{
					if (lastWord.charAt(j) == 'a' || lastWord.charAt(j) == 'e' ||
							lastWord.charAt(j) == 'i' || lastWord.charAt(j) == 'o' || lastWord.charAt(j) == 'u' || 
							(j > 0 && lastWord.charAt(j) == 'y') || lastWord.charAt(j) == 'A' || lastWord.charAt(j) == 'E' ||
									lastWord.charAt(j) == 'I' || lastWord.charAt(j) == 'O' || lastWord.charAt(j) == 'U' || 
									(j > 0 && lastWord.charAt(j) == 'Y'))
					{
						pattern = lastWord.charAt(j) + pattern;
					}
					else
					{
						break;
					}
				}
			}
			
			if (pattern.length() == 0)
			{
				rhyme = rhyme + " ";
			}
			else if (pattern.equalsIgnoreCase(prevPattern))
			{
				rhyme = rhyme + (char)rhymeScheme; 
			}
			else
			{
				rhymeScheme++;
				if (rhymeScheme > 122)
				{
					rhymeScheme = 65;
				}
				rhyme = rhyme + (char) rhymeScheme;
			}
			prevPattern = pattern;
		}

		return rhyme;
	}
}
