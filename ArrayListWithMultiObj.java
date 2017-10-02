/**
 * This class asks the user for number of rows and columns 
 * and then prints out a matrix accordingly.
 * The programs then displays an operations menu from which the user chooses an operation 
 * to be performed on the matrix. 
 * The program then performs the chosen operation on the given matrix.
 * 
 * @author Alisha Sonawalla
 * @version 04/20/2017
 */

package hw23;

import java.util.ArrayList;

/*
 *  This class stores a variety of types in an ArrayList, something we could 
 *  not achieve with arrays.
 *  
 *  This program outputs the following:
 *   
 *     Add 3 circles to the ArrayList.
 *     Add 1 string to the ArrayList.
 *     Add 2 matrices to the ArrayList.
 *     Add 1 Tic-Tac-Toe board to the ArrayList.
 * 
 *     Print out what is at each index in the ArrayList:
 *       0: Circle radius = 3, area = 28.274333882308138
 *       1: Circle radius = 5, area = 78.53981633974483
 *       2: Circle radius = 7, area = 153.93804002589985
 *       3: String = Sydney
 *       4: 2 X 5 matrix
 *       5: 1 X 4 matrix
 *       6: 3 X 3 matrix
 */

public class ArrayListWithMultiObj_Skeleton {

	public static void main(String[] args) {
		// Create an ArrayList that can hold multiple object types:
		ArrayList<Object> myObjects = new ArrayList<>();

		// Create three circles:
		int numCircles = 3;
		System.out.println("Add " + numCircles + " circles to the ArrayList.");
		for (int i = 0; i < numCircles; i++) {
			// Create a circle with a random radius
			final int min = 1;
			final int max = 10;
			int rad = (int) (Math.floor(Math.random() * (max - min)) + min);
			Circle tmpC = new Circle(rad);

			// Add the circle to the ArrayList
			myObjects.add(tmpC);
		}

		// Add a string to the ArrayList
		System.out.println("Add 1 string to the ArrayList.");
		String tmpStr = "Sydney";
		myObjects.add(tmpStr);

		// Add two matrices to the ArrayList
		System.out.println("Add 2 matrices to the ArrayList.");
		Matrix tmpM1 = new Matrix(2, 5);
		Matrix tmpM2 = new Matrix(1, 4);
		myObjects.add(tmpM1);
		myObjects.add(tmpM2);

		// Add two matrices to the ArrayList
		System.out.println("Add 1 Tic-Tac-Toe board to the ArrayList.");
		TicTacToe tmpT = new TicTacToe();
		myObjects.add(tmpT);

		System.out.println("\nPrint out what is at each index in the ArrayList:");

		// Iterate over the ArrayList and print info about the object stored
		// there
		for (int i = 0; i < myObjects.size(); i++) {
			Object currObj = myObjects.get(i);

			System.out.print("  " + i + ": ");
			if (currObj instanceof Circle) {
				Circle c = (Circle) currObj;
				System.out.println(c);
			} else if (currObj instanceof String) {
				String s = (String) currObj;
				System.out.println("String = " + s);
			} else if (currObj instanceof Matrix) {
				Matrix m = (Matrix) currObj;
				System.out.println(m);
			} else if (currObj instanceof TicTacToe) {
				TicTacToe t = (TicTacToe) currObj;
				System.out.println(t);
			} else {
				System.out.println("Error, unexpected type encountered");
			}
		}
	}
}

/**
 * This class creates circle objects with radius and area.
 */
class Circle {
	protected int radius;

	// Create a constructor using the radius
	public Circle(int radius) {
		this.radius = radius;
	}

	/**
	 * This method returns the area of the circle
	 */
	public double getArea() {
		return radius * radius * (double) Math.PI;
	}

	/**
	 * This method returns the area of the circle
	 */
	public String toString() {
		return String.format("Circle radius = " + this.radius + ", area = " + this.getArea());
	}
}

/**
 * This class creates 2D matrix objects.
 */
class Matrix {
	int[][] inputMatrix;

	// Constructor that creates the matrix
	Matrix(int row, int column) {
		inputMatrix = new int[row][column];
	}

	/**
	 * This method returns a formatted matrix
	 * 
	 * @return this method returns a string representation of the matrix
	 */
	public String toString() {
		return inputMatrix.length + " X " + inputMatrix[0].length + " matrix";
	}
}

/**
 * This class creates TicTacToe using the matrix class
 */
class TicTacToe extends Matrix {
	TicTacToe() {
		super(3, 3);
	}
}
