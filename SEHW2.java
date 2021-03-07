/** Opening Comment:
Title: Fermat's Last Theorem
File name: 
External input files:
External output files: 
Programmers: Tim Deyell 
Email: deyellt@duq.edu 
Course info: COSC 445W
Submission date: 3/7/21
Program summary: The attempted goal of this program is
External resources: 
*/

import java.util.Scanner;
import java.lang.Math;

public class fermat{
	static void fermatTest(){
		Scanner input= new Scanner(System.in); //creates a way for the user to interact with the program
		System.out.println("Fermat's Final Theorem states that there is no natural numbers that satisfy the equation x^n + y^n = z^n when n>2.");
		System.out.println("Care to see if he's wrong?");
		System.out.println("Pick an exponent between 2 and 12");
		int n=input.nextInt();//creates a user generated exponent to test the theorem with
		if (n>12 | n<1) {// ensures the exponent is in the valid range
			System.out.println("Invalid exponent! Try again:");
			n=input.nextInt();
		}
		System.out.println("Pick a search range value greater than 10 ");
		int k=input.nextInt();//creates the search range value 
		if (k<10) {//validates the search range criteria
			System.out.println("Invalid value! Try again:");
			k=input.nextInt();
		}
		int x=10; int y=10;// initializes variables to begin our search
		
		for (int i=10;i<k;i++) {
			for(int j=10; j<k; j++) {
				double pair=(x^n)+(y^n);//creates the pair sum we are trying to approximate.
				double z=Math.pow(pair, 1/n);//approximates a z value 
				double zFloor=Math.floor(z);//creates a decimal that we'll raise to n
				double bound1=Math.pow(zFloor, n);//creates lower bound to test
				double bound2=Math.pow(zFloor+1,n);//creates upper bound to test
				double currentRatio=1.0; //intializes a variable used below
				
				double diff1=pair-bound1;//creates difference to compare
				double diff2=bound2-pair;//creates difference to compare
				double miss=Math.min(diff1, diff2);
				double missRatio=miss/pair;
				if (missRatio<currentRatio) {
					currentRatio=missRatio;
					double zFinal=miss;//holds which z-value is being used
				}
				y++;
			} 	
		x++;
		System.out.println("The current approximation values are: ");
		System.out.println("n= %d;x= %d ; y= %d ; z= %d",n, x,y,zFinal);
		System.out.println("The current miss ratio is "+ missRatio);
		System.out.println("Continue searching? ");
		String nextLine=input.next();//creates an executbale to keep the program running and let the user analyze the current scenario
		}
		
	
	}
	
	public static void main(String[] args) {
		fermatTest();
	}
}