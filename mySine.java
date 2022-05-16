import java.util.Scanner;

public class MY_SINE 
{

	public static void main(String[] args) 
	{
		//declaring scanner
		Scanner kb = new Scanner(System.in);

		// prompting user for x
		System.out.print("Input x (radians):");
		double x = kb.nextDouble();	
		//prompting user for positive odd exponent
		System.out.print("Input maximum exponent (positive odd exponent): ");
		int oddExponent = kb.nextInt();
		// validating oddExponent input
		do 
		{
			if(oddExponent % 2 == 0 || oddExponent < 1) 
			{
				System.out.println("Sorry, your exponent must be a positive "
						+ "odd integer.");
				System.out.print("Input maximum exponent (positive odd exponent):"
						+ " ");
				oddExponent = kb.nextInt();
			}
			else if (oddExponent > 11) 
			{
				System.out.println("Sorry, your maximum exponent may not be greater "
						+ "than 11.");
				System.out.print("Input maximum exponent (positive odd exponent): ");
				oddExponent = kb.nextInt();
			}
		}
		while(oddExponent % 2 == 0 || oddExponent < 1 || oddExponent > 11);
		double degrees = x * (180/Math.PI);		// converting radians to degrees		

		System.out.printf("The angle is %.1f radians or %.1f degrees.\n", 
				x, degrees);		// rounding to 1 decimal for full credit
		System.out.println("The approximate Sine Value is: " + mySine(x, //calling mySine() 
				oddExponent));	

		kb.close(); 	//closing Scanner
	}
	// mySine method
	public static double mySine(double x, int oddExponent) 
	{
		// declaring double that will be returned
		double sum = 0.0;	
		int power = 1;		// power variable will be increased by two (but starts at 1)
		double rad = x;

		for (int i = 1; i <= (oddExponent+2)/2; i++) // for loop will loop through odd exponents
		{
			double term = 0;
			if (i % 2 == 0) // if i is an even number, its subtract it
			{
				term = -Math.pow(rad, power)/ factorial(power);
			}
			else 			// otherwise, make it positive
			{
				term = (Math.pow(rad, power)/factorial(power));
			}
			sum = sum + term;	//adding term to the sum
			power = power + 2;	//power increased by 2
		}	
		return sum;
	}



	public static int factorial(double x) 
	{
		// for loop will calculate factorial of input factorial
		int factorial = 1;
		for (int i = 1; i <= x; i++) 
		{
			factorial = factorial * i;
		}


		return factorial;
	}

}
