/**
 * This class creates an array and then calculates its average and sum
 * 
 * @author Alisha Sonawalla
 * @version 03/30/2017
 */

public class challenge1 {
	public static void main(String[] args) {

		// Create an array with  numbers
		int[] array = { 54, 40, 37, 64, 81, 15, 65, 72, 61, 57, 83, 3, 67, 12, 30, 54, 11, 51, 3, 78, 48, 31, 68, 77,
				64, 68, 95, 68, 35, 82, 57, 26, 67, 41, 47, 80, 36, 88, 5, 9, 55, 87, 77, 8, 65, 31, 7, 79, 49, 22, 32,
				94, 34, 12, 20, 30, 91, 12, 57, 77, 37, 96, 22, 29, 17, 76, 36, 56, 80, 33, 20, 65, 57, 40, 50, 97, 20,
				92, 25, 14, 19, 84, 12, 62, 20, 42, 99, 52, 88, 29, 75, 48, 27, 73, 46, 72, 48, 84, 19, 55 };

		// Calculate the sum
		int sum = 0;
		// Track the number of elements
		int elements = 0;
		for (int i : array) {
			sum += i;
			elements += 1;
		}

		// Calculate the average
		double average = (double) sum / elements;
		System.out.println("Sum is: " + sum);
		System.out.println("Average is: " + average);
	}
}
