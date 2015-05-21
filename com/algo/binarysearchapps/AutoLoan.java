package com.algo.binarysearchapps;

/*
 * Auto dealerships frequently advertise tempting loan offers in order to make it easier 
 * for people to afford the "car of their dreams". A typical sales tactic is to show you various cars,
 * and then talk in terms of what your monthly payment would be, to say nothing of how much you are 
 * actually paying for the car, how much interest you pay, or how long you have to make payments.

A typical auto loan is calculated using a fixed interest rate, and is set up so that you make the 
same monthly payment for a set period of time in order to fully pay off the balance. 
The balance of your loan starts out as the sticker price of the car. 
Each month, the monthly interest is added to your balance, and the amount of your payment is subtracted from your balance. 
(The payment is subtracted after the interest is added.) The monthly interest rate is 1/12 of the yearly interest rate. 
Thus, if your annual percentage rate is 12%, then 1% of the remaining balance would be charged as interest each month.

You have been checking out some of the cars at your local dealership, TopAuto. 
An excited salesman has just approached you, shouting about how you can have the car you are 
looking at for a payment of only monthlyPayment for only loanTerm months! 
You are to return a double indicating the annual percentage rate of the loan, 
assuming that the initial balance of the loan is price.
 */

public class AutoLoan 
{
	public static void main(String args[])
	{		
		double price = 18000;
		double monthlyPayment = 334;
		int loanTerm = 60;
		System.out.println(compoundInterest(price, monthlyPayment, loanTerm));
	}
	
	public static double compoundInterest(double price, double monthlyPayment, int loanTerm)
	{
		double high = 100;
		double low = 0;
		double interestRate = 0, currentBalance = 0;
		//note 1e-9
		while (high - low > 1e-9)
		{
			interestRate = (high + low)/2;
			currentBalance = price;

			for (int i = 0; i < loanTerm; i++)
			{
				currentBalance = currentBalance + (currentBalance * (interestRate/1200)) - monthlyPayment;
			}

			if (currentBalance == 0)
			{
				return interestRate;
			}
			else
				if(currentBalance < 0)
				{
					low = interestRate;
				}
				else 
				{
					high = interestRate;
				}
		}
		
		return interestRate;
		
	}
}
