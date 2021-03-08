/** Opening Comment:
Title: Fermat's Last Theorem
File name: Fermat.java
External input files: Fermat.java
External output files: NA
Programmers: Tim Deyell, Pavel Bogachenko, Kevin Chen, Ibrokhimkhuja Shokhujaev
Email: deyellt@duq.edu 
Course info: COSC 445W
Submission date: 3/7/21
Program summary: The attempted goal of this program is to create a method for approximating pairs of numbers that closely satisfy Fermat's Final Theorem.
External resources: NA
*/

import java.util.Scanner;
import java.lang.Math;

public class Fermat{
	public static void fermatTest(){
		Scanner input= new Scanner(System.in); //creates a way for the user to interact with the program
		
		System.out.println("Fermat's Final Theorem states that there is no natural numbers that satisfy the equation x^n + y^n = z^n when n>2.");
		System.out.println("Care to see if he's wrong?");
		System.out.println("Pick an exponent between 2 and 12: ");
		int n=input.nextInt();//creates a user generated exponent to test the theorem with
		while (n>12 || n<1) {// ensures the exponent is in the valid range
			System.out.println("Invalid exponent! Try again:");
			n=input.nextInt();
		}
		System.out.println("Pick a search range value greater than 10: ");
		int k=input.nextInt();//creates the search range value 
		while (k<10) {//validates the search range criteria
			System.out.println("Invalid value! Try again:");
			k=input.nextInt();
		}
		int x=10; int y=10;// initializes variables to begin our search
		double zFinal=0.0;//initializes variables that we call in the print
		double missRatio=10;//initializes variable that's used in for loop; large value given to ensure it is replaced easily
		
		for (int i=10;i<k;i++) {//double for loops to check for all x,y combinations in our bounded range
			for(int j=10; j<k; j++) {
				double pair=(i^n)+(j^n); //creates the pair sum we are trying to approximate
				double z=Math.pow(pair, 1/n);//approximates a z value
				double zFloor=Math.floor(z);//creates a decimal that we'll raise to n 
				double bound1=Math.pow(zFloor, n);//creates lower bound to test 
				double bound2=Math.pow(zFloor+1,n);//creates upper bound to test 
				double currentRatio=1.0; //initializes a variable used below 
				
				double diff1=pair-bound1;//creates difference to compare 
				double diff2=bound2-pair;//creates difference to compare 
				double miss=Math.min(diff1, diff2);//creates a minimum value to analyze which estimate is more accurate.
				missRatio=miss/pair;
				if (missRatio<currentRatio) {//checks if the new miss is closer than our last closest miss
					currentRatio=missRatio;
					zFinal=miss;//holds which z-value is being used 
					y=j;//saves the y-value for our new closer miss
					x=i;//saves the x-value for our new closer miss
					System.out.println("The current approximation values are: ");
					System.out.println("n= "+n+"; x= "+x+"; y= "+y+"; z= "+zFinal);
					System.out.println("The current miss ratio is "+ missRatio);
					System.out.println('\n');
				}
			} //end of inner for loop 
		}//end of outer for loop
		input.close();
	}
	public static void main(String[] args) {
		fermatTest();
	}
} 