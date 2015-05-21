package com.algo.simple;

/*
 * You run a gambling business in which people place bets on the margin of victory in a football game.
 *  At the end of the day, the company would like to know what the day's net gain has been. 
 *  Just as in any other betting system, people place certain amounts as their bets and if they guess correctly,
 *   they get their money back plus a pre-specified percentage of their bet; otherwise they lose the money they bet. 
 *   You are given a int[], amounts, the ith element of which is the number of dollars people have 
 *   placed on a victory margin of i (i = 0 refers to the first element). You are also given a int[], 
 *   centsPerDollar, the ith element of which is the number of cents the company has to pay for every dollar
 *    the people bet on a victory margin of i, if the final outcome is a victory margin of i.
 *    
 *     Finally, you are given an int, finalResult, which is the final margin of victory. 
 *     You have to determine what the net gain for the day was and return the amount in cents.
 */
public class BettingMoney 
{
	public static void main(String args[])
	{
		BettingMoney bMoney = new BettingMoney();
		System.out.println(bMoney.moneyMade(new int[] {10,20,30}, new int[] {20,30,40}, 1));
	}
	
	public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult)
	{
		int amountsFinalResult = amounts[finalResult];
		int moneyLost = (amountsFinalResult * (centsPerDollar[finalResult]));
		int totalMoney = 0;
		for (int i = 0; i < amounts.length; i++)
		{
			if (i != finalResult)
				totalMoney += amounts[i] * 100;
		}
		
		return (totalMoney - moneyLost);
	}
}
