package com.algo.simple;

import java.util.*;

public class MedalTable 
{
	  class Country implements Comparable
	  {
	    String name;
	    int gold, silver, bronze;
	    Country(String name, int gold, int silver, int bronze)
	    {
	      this.name = new String(name);
	      this.gold = gold;
	      this.silver = silver;
	      this.bronze = bronze;
	    }
	    public int compareTo(Object o) 
	    {
	      Country c = (Country)o;
	      if (this.gold != c.gold) return c.gold - this.gold;
	      if (this.silver != c.silver) return c.silver - this.silver;
	      if (this.bronze != c.bronze) return c.bronze - this.bronze;
	      return this.name.compareTo(c.name);
	    }
	    public String toString() 
	    {
	      return name + " " + gold + " " + silver + " " + bronze;
	    }
	  }
	  
	  public String[] generate(String[] results) 
	  {
	    ArrayList al = new ArrayList();
	    for (int i = 0; i < results.length; i++)
	    {
	      StringTokenizer st = new StringTokenizer(results[i]);
	      while (st.hasMoreTokens()) 
	      {
	    	  String name = st.nextToken();
	    	  if (!al.contains(name)) 
	    	  {
	    		  al.add(name);
	    	  }
	      }
	    }
	    
	    Country [] cc = new Country[al.size()];
	    for (int i = 0; i < al.size(); i++) 
	    {
	      String name = (String)al.get(i);
	      cc[i] = new Country(name, 0, 0, 0);
	    }
	    
	    for (int i = 0; i < results.length; i++)
	    {
	      StringTokenizer st = new StringTokenizer(results[i]);
	      int curr = 0;
	      while (st.hasMoreTokens())
	      {
	        String name = st.nextToken();
	        int idx = al.indexOf(name);
	        if (curr == 0) cc[idx].gold++;
	        if (curr == 1) cc[idx].silver++;
	        if (curr == 2) cc[idx].bronze++;
	        curr++;
	      }
	    }
	    Arrays.sort(cc);
	    String [] r = new String[al.size()];
	    for (int i = 0; i < al.size(); i++)
	    {
	      r[i] = cc[i].toString();
	      System.out.print(r[i]);
	    }
	    return r;
	  }
	  
	  public static void main(String args[])
	  {
		  MedalTable mtable = new MedalTable();
		  mtable.generate(new String[]{"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"});
	  }
}
