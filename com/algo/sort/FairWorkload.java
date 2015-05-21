package com.algo.sort;

/*
 * In the problem, a number of workers need to examine a number of filing cabinets. 
 * The cabinets are not all of the same size and we are told for each cabinet how many folders it contains. 
 * We are asked to find an assignment such that each worker gets a sequential series of cabinets to go through and 
 * that it minimizes the maximum amount of folders that a worker would have to look through. 
 */
public class FairWorkload 
{
  public boolean could( int[] folders, int workers, int max )
  {
    int cur = 0;
    for ( int i = 0; i < folders.length; i++ )
    {
      cur += folders[i];
      if ( cur > max ) 
      {
        cur = folders[i];
        workers--;
      }
      if ( cur > max ) 
      {
        return false;
      }
    }
    return workers > 0;
  }
  
  public int getMostWork(int[] folders, int workers) 
  {
    for ( int i = 0; true; i++ )
    {
      if ( could( folders, workers, i ) ) 
      {
        return i;
      }
    }
  }
  
}
 