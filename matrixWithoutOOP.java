/**
 * This class asks the user for number of rows and columns 
 * and then prints out a matrix accordingly.
 * The programs then displays an operations menu from which the user chooses an operation 
 * to be performed on the matrix. 
 * The program then performs the chosen operation on the given matrix.
 * 
 * @author Alisha Sonawalla
 * @version 03/15/2017
 */


import java.util.Scanner;

public class matrixWithoutOOP {

	/**
	 * The main method asks the user for number of rows and columns. It then
	 * validates the input and provides the user with a 2D array. The program
	 * then displays a menu of operations the user can choose from.
	 */
	public static void main(String[] args) {
		// Create a matrix
		int matrix[][];

		// Create a Scanner named input
		Scanner input = new Scanner(System.in);

		// Ask user for number of rows
		System.out.print("Enter number of rows in matrix (between 1 and 5): ");
		int row = input.nextInt();
		// Trap the user unless the user inputs legal values
		while (row < 1 || row > 5) {
			System.out.print("Please enter number of rows between 1 and 5: ");
			row = input.nextInt();
		}

		// Ask user for number of columns
		System.out.print("Enter number of columns (between 1 and 5): ");
		int column = input.nextInt();
		// Trap the user unless the user inputs legal values
		while (column < 1 || column > 5) {
			System.out.println("");
			System.out.println("Please enter number of columns between 1 and 5: ");
			System.out.println("");
			column = input.nextInt();
		}

		System.out.println();

		// Populate the matrix
		matrix = new int[row][column];
		int rowval = 0;
		for (int i = 0; i < row; i++) {
			int colval = 0;
			for (int j = 0; j < column; j++) {
				int element = colval + rowval;
				matrix[i][j] = element;
				colval += 1;
			}
			rowval += 10;
		}
		printMatrix(matrix);

		// Display operations menu to the user
		System.out.println("");
		System.out.println("T transpose - Rows become columns (and vice versa)");
		System.out.println("C columnSum - Calculate the sum of the values in each column");
		System.out.println("R reverseRows - Reverse all elements in every row of the matrix");
		System.out.println("Q quit - Exit the program");

		System.out.println("");
		System.out.println("Please choose from the menu below or hit 'Q' to quit:");
		System.out.println("");

		// Take input from user and convert to lower case
		String operation = input.next().toLowerCase();

		// Initializing a loop called menuLoop which executes operations until
		// the user hits quit
		menuLoop: while (true) {

			switch (operation) {
			case "t":
				printMatrix(transpose(matrix));
				break;
			case "c":
				int[] sum = columnSum(matrix);
				for (int i = 0; i < sum.length; i++) {
					System.out.print(sum[i] + " ");
				}
				break;
			case "r":
				printMatrix(reverseRows(matrix));
				break;
			case "q":
				break menuLoop;

			default:
				System.out.println("\nInvalid Choice");
				break;
			}

			// Ask user for input again
			System.out.println("");
			System.out.println("Please choose from the menu below or hit 'Q' to quit:");
			System.out.println("");

			// Take input from user and convert to lower case
			operation = input.next().toLowerCase();
		}

		// Exit the program
		System.out.println("\n Thank you for using this program. Goodbye!");

		// Close Scanner
		input.close();
	}

	/**
	 * This method prints a formatted 2D array as a matrix
	 * 
	 * @param matrix this method takes in a 2D matrix
	 */
	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.printf("%3d", matrix[row][col]);
			}
			System.out.println();
		}
	}

	/**
	 * This method takes a row by column matrix and converts it into a column by
	 * row matrix
	 * 
	 * @param matrix this method takes in a 2D matrix
	 * @return transposedMatrix returns a 2D transposed matrix
	 */
	public static int[][] transpose(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] transposedMatrix = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				transposedMatrix[j][i] = matrix[i][j];
			}
		}
		return transposedMatrix;
	}

	/**
	 * This method returns a one dimensional array of numbers such that the
	 * value at index i is the sum of all elements of the i’th column in the
	 * original matrix.
	 * 
	 * @param matrix this method takes in a 2D matrix
	 * @return sum returns a 1D array
	 */
	public static int[] columnSum(int[][] matrix) {
		int sum[] = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				sum[j] += matrix[i][j];
			}
		}
		return sum;
	}

	/**
	 * This method returns a new matrix the same size as the old but the
	 * elements of each row are reversed.
	 * 
	 * @param matrix this method takes in a 2D matrix
	 * @return reversedMatrix returns a 2D array with the rows in reversed order
	 */
	public static int[][] reverseRows(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] reversedMatrix = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				reversedMatrix[i][cols - 1 - j] = matrix[i][j];
			}
		}
		System.out.println();
		return reversedMatrix;
	}
}
