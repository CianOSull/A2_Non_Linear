/*
 * Author: Cian O'Sullivan
 */

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RobotMoving {
	// Arrays
	double[] c1 = {1.5, 1.2, 100};
	double[] c2 = {1.1, 1.3, 2.5};
	double[] d;
	double[][] t;
	String[][] path;
	ArrayList<String> pathTaken;
	
	int l;
	double cost = 0;
	String surname;
	
	public RobotMoving(int n, String surnameLetter) {
		// Making the matrixes
		this.t = new double[n][n];
		this.path = new String[n][n];
		path[0][0] = "-";
		
		this.l = n;
		this.surname = surnameLetter;
		this.pathTaken = new ArrayList<String>();
		// This sets which costs will be used
		d = c1;
		
	}
	
	// This function compares the three directions and returns the one minimum of the three and updates the path matrix 
	public double min(double n1, double n2, double n3, int p1, int p2) {
		if(n1 < n2 && n1 < n3) {
			path[p1][p2] = "r";
			return n1;
		}
		else if(n2 < n1 && n2 < n3) {
			path[p1][p2] = "b";
			return n2;
		}
		else {
			path[p1][p2] = "d";
			return n3;
		}
	}
	
	/*
	 * This method start at the end of the path matrix and then looks at each value and
	 * works its way up through the matrix, finding the path backwards
	 */
	public void findPath() {
		int p1 = t.length-1; 
		int p2 = t.length-1;
		String message = "";
		while(p1 != -1 && p2 != -1){
			if(path[p1][p2] == "r") {
				p2--;
				message = "We reached (" + p1 + ", " + p2 + ") from (" + p1 + ", " + (p2+1) + ") with cost " +  d[0] + 
						". Cost accumalated = " + t[p1][p2+1];
				pathTaken.add(message);
			}
			else if(path[p1][p2] == "b") {
				p1--;
				message = "We reached (" + p1 + ", " + p2 + ") from (" + (p1+1) + ", " + p2 + ") with cost " +  d[1] + 
						". Cost accumalated = " + t[p1+1][p2];
				pathTaken.add(message);
			}
			else {
				p1--;
				p2--;
				if(p1 != -1 && p2 != -2) {
					message = "We reached (" + p1 + ", " + p2 + ") from (" + (p1+1) + ", " + (p2+1) + ") with cost " +  d[2] + 
							". Cost accumalated = " + t[p1+1][p2+1];
					pathTaken.add(message);
				}
				
			}
		}
		
	}
	
	/*
	 * How this works is that you find the cost ot each of the points
	 * in the first row and first column, and then compare those values with the diagonal for each point in the next row and column
	 */
	public void solve() {
		// TODO Auto-generated method stub
		t[0][0] = 0;
		for(int j = 1; j < l; j++) {
			t[0][j] = t[0][j-1] + d[0];
			path[0][j] = "r";
		}
		
		for(int i = 1; i < l; i++) {
			t[i][0] = t[i-1][0] + d[1];
			path[i][0] = "b";
			for(int j = 1; j < l; j++) {
				t[i][j] = min(
						t[i][j-1] + d[0],
						t[i-1][j] + d[1],
						t[i-1][j-1] + d[2],
						i, j
						);
			}
		}
		cost = t[l-1][l-1];
	}
	
	public void printSol() {
 		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#0.0");
		
		for (int row = 0; row < t.length; row++){
			for (int col = 0; col < t.length; col++){
                System.out.print(df.format(t[row][col]) + " ");
            }
            System.out.println();
      	}
		System.out.println("\nPath matrix");
		for (int row = 0; row < path.length; row++){
			for (int col = 0; col < path.length; col++){
                System.out.print(path[row][col] + " ");
            }
            System.out.println();
      	}
		
		System.out.println("\n---Solution Explanation:---\n"
				+ "Total cost from source (0, 0) to target (" + l + 
				"," + l + ") = " + df.format(cost));
		findPath();
		for(int i = pathTaken.size()-1; 0 <= i; i--) {
			System.out.println(pathTaken.get(i));
		}
	}
}
