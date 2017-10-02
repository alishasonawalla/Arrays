/**
 * This class uses OOP to transpose, reverse rows, sum columns values, 
 * quit and print a matrix.
 * 
 * @author Alisha Sonawalla
 * @version 03/15/2017
 */

import java.util.Scanner;

public class matrixWithOOP {
	
	/**
	 * The main method asks the user for number of rows and columns. It then
	 * validates the input and provides the user with a 2D array. The program
	 * then displays a menu of operations the user can choose from.
	 */
    public static void main(String[] args){
        
    	//Take in scanner input
        Scanner input = new Scanner(System.in);
        int rows;
        int cols;
        boolean badInputs = false;
        
        //Get rows and columns
        do {
            badInputs = false;
            System.out.println("\nHow many rows in your matrix? (Between 1 and 5 rows).\n");
            rows = input.nextInt();
            
            System.out.println("How many columns in your matrix? (Between 1 and 5 columns).");
            cols = input.nextInt();
            
            if (rows < 1 || rows > 5 || cols < 1 || cols > 5) {
                badInputs = true;
                System.out.println("\nThe number of rows and/or the number of columns is < 1 or > 5. Please try again.\n");
            }
        } while (badInputs);

            
        Matrix m1 = new Matrix(rows, cols);
        m1.printMatrix();

        String userInput = " ";
        do {
            printMenu();
            userInput = input.next().toUpperCase();

            switch(userInput) {
            case("T"): 
                m1.transpose();
                break; 
            case("C"): 
                m1.columnSum();
                break; 
            case("R"): 
                m1.reverseRows();
                break; 
            case("P"): 
                m1.printMatrix();
                break;
            case("Q"): 
                input.close();
                break;
            default:
                System.out.println("\nError, invalid input. Enter: T, C, R, P, or Q\n");
                break;
            }
        } while (!userInput.equals("Q"));
    }
    
    /**
	 * This method prints the menu.
	 */
    public static void printMenu() {
        System.out.println("\n");
        System.out.println("T transpose   - Rows become colums (and vice versa)");
        System.out.println("C columnSum   - Caclulate the sum of the values in each column");
        System.out.println("R reverseRows - Reverse all elements in every row of the matrix");
        System.out.println("P printMatrix - Print the original matrix");
        System.out.println("Q quit        - Exit the program");
        System.out.println("\n");
    }    
}





/**
 * This class creates a matrix object and contains data fields and methods
 * to print matrix, transpose the matrix, reverse rows, sum columns
 */
class Matrix  {
    int[][] myMatrix;
    
    // Constructor that initializes the matrix to 0 1 2, then 10 11 12, then 20 21 22, ...
    Matrix(int row, int column) {
        myMatrix = new int [row][column];
        myMatrix = new int[row][column]; 
        int rowval = 0;
        for (int i = 0; i < row; i++) {
       	 int colval=0;
       	 for (int j = 0; j < column; j++) {
       		 int element = colval+rowval;
       		 myMatrix[i][j] = element;
       		 colval+=1;	
       	 }    	
       	rowval+=10;
        }
    
    }
    
    // Constructor that initializes the entire matrix to the value passed in.
    Matrix(int row, int column, int value) {
        myMatrix = new int [row][column];
        for (int i=0; i<row; i++) {
        	for(int j =0; j<column; j++) {
        		myMatrix[i][j] = value;
        	}
        }
    }
      
    /**
     * This method prints a 2D matrix that is right aligned
     */
    void printMatrix() {
    	    for (int row = 0; row < myMatrix.length; row++) {
    	        for (int col = 0; col < myMatrix[row].length; col++) {
    	            System.out.printf("%3d", myMatrix[row][col]);
    	        }
    	        System.out.println();
    	    }
    	}
    
    /**
     * This method takes a row by column matrix and converts
     * it into a column by row matrix
     */
    void transpose() {
        Matrix mtran = new Matrix(myMatrix[0].length, myMatrix.length);
        for (int i = 0; i < myMatrix[0].length; i++){
            for (int j = 0; j < myMatrix.length; j++){
                mtran.myMatrix[i][j] = myMatrix[j][i];
            }
	}

        mtran.printMatrix();
    }
    
    /**
     * This method sums all elements of the i’th column in the original matrix. 
     */
    void columnSum() {
        Matrix columnSum = new Matrix(1, myMatrix[0].length, 0);	    
        for (int c = 0; c < myMatrix[0].length; c++){
        	int total = 0;
        	for (int r = 0; r < myMatrix.length; r++){
        		total +=myMatrix[r][c];
        		columnSum.myMatrix[0][c] = total;
            	}
            }
        columnSum.printMatrix();
    }
  
    /**
     * This method reverses the rows of the of a matrix
     */ 
    void reverseRows() {
        Matrix mrev = new Matrix(myMatrix.length, myMatrix[0].length, 0);
    		int rows = myMatrix.length;
            int cols = myMatrix[0].length;
            for(int i = 0; i<rows; i++) {
                for(int j = 0; j <cols; j++) {
                    mrev.myMatrix[i][cols-1-j] = myMatrix[i][j];
                }
                }
                System.out.println();
        mrev.printMatrix();
    }
}

