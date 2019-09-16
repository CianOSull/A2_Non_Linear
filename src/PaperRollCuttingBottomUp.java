/*
 * Author: Cian O'Sullivan
 */

import java.util.Arrays;

public class PaperRollCuttingBottomUp {
	
	private int rodLength;
	private double p[]; // potential cuts
	private boolean c[]; // check
	private double r[]; // revenue
	private int s[]; // slices
	
	public PaperRollCuttingBottomUp(int n) {
		this.rodLength = n;
		/*
		 * This makes this generalized for any number. 
		 * Need the first if statement or else doesn't properly work for numbers below 5
		 */
		if (n < 5) {
			this.p = new double[6];
			this.c = new boolean[6];
		}
		else {
			this.p = new double[rodLength+1];
			this.c = new boolean[rodLength+1];
		}
		
		// This sets which positions can be cut
		this.p[2] = 3;
		this.p[3] = 500;
		this.p[5] = 1000;
		
		// This makes them generalized
		this.r = new double[rodLength+1];
		this.s = new int[rodLength+1];
		
		// This sets the check array so that it will only cut at a position with true
		for(int i = 0; i < 6; i++) {
			if(i != 4) {
				this.c[i] = true;
			}
		}
			
	}
	
	public void solve() {
		double q;
		// A cut of zero obviously returns 0
		r[0] = 0;
		
		for(int j = 1; j <= rodLength; j++) {
			q = Integer.MIN_VALUE;
			for(int i = 1; i <= j; i++) {
				// This checks to see if i is equal to a cutting legnth
				if(c[i]) {
					// if it is then it will check if a new cut is greater than the previous cuts
					if(q < p[i] + r[j-i]) {
						// if it is continure and set q to it
						q = p[i] + r[j-i];
						// Stores hte cuts done
						s[j] = i;			
					}
				}
			}
			// Sets the revenue
			r[j] = q;
		}
	}
	
	public void printArrays()
	{
		System.out.println("r="+Arrays.toString(r));
		System.out.println("s="+Arrays.toString(s));
	}
	
	public void printSol() {
		printArrays(); 
		System.out.println("\nBEST PRICE= " + r[rodLength] + " for a rod of length " + rodLength);
		
		int length = rodLength;
		System.out.println("\nPIECES CUTTED:");
		while (length > 0) {
			int item = s[length];
			System.out.println("a piece of length " + item + " with price " + p[item] );
			length -= item;
			//length = 0;
		}
		printArrays();
	}
}