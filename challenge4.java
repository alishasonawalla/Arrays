/**
 * This class converts a string into integers and finds the total of the string.
 * It then subtracts the total from each number in an array of 7 numbers and
 * finally converts the new array to a string.
 * 
 * @author Alisha Sonawalla
 * @version 03/30/2017
 */

public class challenge4 {
	public static void main(String[] args) {
		String code = "treasurelieswithinthischest";

		// Initialize a sum variable
		int sum = 0;

		// Convert the string to ascii and subtract 97 to get a=0, b=1 c=2 etc.
		for (int i = 0; i < code.length(); i++) {
			char c = code.charAt(i); // c='a'
			sum += (int) c - 97;
		}
		System.out.println("The sum is: " + sum);

		// Subtract 19 from the array below and convert the array to a string
		int[] arr = { 323, 331, 323, 336, 319, 330, 322 };
		String password = "";
		for (int i = 0; i < 7; i++) {
			arr[i] -= sum;
			password += (char) (arr[i] + 97);
		}
		System.out.print("The password is " + password + ".");
	}
}