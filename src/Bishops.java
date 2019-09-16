/*
 * Author: Cian O'Sullivan
 */

public class Bishops {
	
	int size;
	int solutions = 0;
	
	public Bishops(int n) {
		size = n;
	}
	
	// This function checks if there is 1 in any of the diagonals of the space we are trying to put a 1 in  
    public boolean isSafe(int markedAreas[][], int row, int col) 
    { 
        int i, j; 
        
        /* Check upper diagonal on right side */
        for (i = row, j = col;  0 <= i && j < size; i--, j++) {
            if (markedAreas[i][j] == 1) {
                return false; 
            }
        }
        
        // check lower diagonal on the right
        for (i = row, j = col; 0 <= i  && 0 <= j ; i--, j--) {
            if (markedAreas[j][i] == 1) {
                return false;
            }
        }
        
        /* Check upper diagonal on left side */
        for (i = row, j = col; 0 <= i && 0 <= j ; i--, j--) {
            if (markedAreas[i][j] == 1) {
                return false; 
            }
        }
  
        /* Check lower diagonal on left side */
        for (i = row, j = col; 0 <= j && i < size; i++, j--) { 
            if (markedAreas[i][j] == 1) {
                return false; 
            }
        }
  
        return true; 
    } 
    
    public boolean solveByCol(int markedAreas[][], int row) {
    	boolean res = false;
    	
    	// If a solution is found then it will print it
    	if (size <= row) {
	    	 printSol(markedAreas);
	    	 solutions++;
	         return true; 
	     }
    	
    	for(int j = 0; j < size; j++) {
    	 if (isSafe(markedAreas, j, row)) { 
        	 markedAreas[row][j] = 1; 

             // Recurs to play all the bishops
             if (solveByRow(markedAreas, row + 1)) {
            	 res = true;
             }

             markedAreas[row][j] = 0; // This line starts the back tracking if a solution hasnt been found 
         } 
       }
		return res;
    }
    
	 boolean solveByRow(int markedAreas[][], int col) { 
		 
		 boolean res = false;

	     if (size <= col) {
	    	 printSol(markedAreas);
	    	 solutions++;
	         return true; 
	     }
	
	     for (int i = 0; i < size; i++) { 
	         if (isSafe(markedAreas, i, col)) { 
	        	 markedAreas[i][col] = 1; 
	
	             if (solveByCol(markedAreas, col + 1)) {
	            	 res = true;
	             }
	
	             markedAreas[i][col] = 0; 
	         } 
	     } 
	     return res; 
	 } 

	
	public void solve() {
		int[][] markedAreas = new int[size][size];
		
	     if (!solveByCol(markedAreas, 0)) 
	     { 
	         System.out.println("Solution does not exist for columns"); 
	     }
	     if (!solveByRow(markedAreas, 0)) 
	     { 
	         System.out.println("Solution does not exist for rows"); 
	     }
	     
	     System.out.println("Number of possible solutions that were found >>>: " + solutions);
	    
	     
	}
	
	public void printSol(int markedAreas[][]) {
		System.out.println("-------------------- Solutions found --------------------");
		for (int row = 0; row < size; row++){
			for (int col = 0; col < size; col++){
				if(markedAreas[row][col] == 1) {
                	System.out.print("B ");
                }
                else {
                	System.out.print("* ");
                }
            }
            System.out.println();
      	}	
	}
}
