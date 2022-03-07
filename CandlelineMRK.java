/*Chapter 12
Date: 12/1/2018
Programmer: Michael Kartavich
Filename: CandlelineMRK.java
Purpose: Using exception handling in a shipping program.
*/

import java.util.*;
import java.text.DecimalFormat;

public class CandlelineMRK {
  public static void main(String[] args) {

  System.out.println("Shipping Cost Calculator");
  System.out.println();

  double candleCost, shippingCost, totalCost;
  int shippingType;


  candleCost = getCandleCost();
  System.out.println();
  shippingType = getShippingType();
  System.out.println();
  shippingCost = getShippingCost(candleCost, shippingType);
  System.out.println();
  output(candleCost, shippingCost);
}



//methods
public static double getCandleCost()
{
  double candleCost = 0.0;
  boolean done = false;
  Scanner input = new Scanner(System.in);
  do {
    try {
      System.out.print("Enter the cost of the candle: ");
      candleCost = input.nextDouble();
      if (candleCost <= 0) throw new InputMismatchException();
      done = true;
    }
    catch(InputMismatchException e)
    {
      System.out.println("Error, enter a dollar amount greater than zero.");
      input.nextLine();
    }
  }

  while(!done);
  return candleCost;
}


public static int getShippingType()
{
int shippingType = 0;
boolean done = false;
Scanner input = new Scanner(System.in);
do {
  try {
    System.out.println("What type of shipping would you like? Enter 1 for Standard. 2 for Express. 3 for Priority ");
    input.nextInt();
    if(shippingType <= 0 || shippingType > 3)
    done = true;
  }
  catch(InputMismatchException e)
  {
    System.out.println("Error! Enter 1, 2 or 3.");
    input.nextLine();
  }
}
while (!done);

return shippingType;
}

public static double getShippingCost(double canCost, int shipType) {
if(shipType == 1) return 16.95;
else if (shipType == 2) return 13.95;
else if ((shipType == 3) && (canCost < 100.00)) return 7.95;
return 0.0;
}

public static void output(double candleCost, double shippingCost)
{
  DecimalFormat twoDigits = new DecimalFormat("$#,###.00");
  System.out.println();
  System.out.println("The cost of your order is " + twoDigits.format(candleCost) + " plus a shipping cost of " + twoDigits.format(shippingCost) + " for a total cost of " + twoDigits.format(candleCost + shippingCost));
}
}
