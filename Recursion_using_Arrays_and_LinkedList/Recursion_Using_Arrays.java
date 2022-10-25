
//Java code to find the sum of array elements using recursion.

// We import the package java.util.* 
import java.util.*;  

// Create class Recursion_Using_Arrays 
public class Recursion_Using_Arrays {
	//static int Array[] = { 1, 2, 3, 4, 5 };

	// Return the sum of elements in Array[0..N-1] using recursion.
	static int findSum(int Array[], int N)
	{
		// When N is less than or equal to zero.
		if (N <= 0) {
			// Return zero
			return 0;
	    }
		else {

			//else, we call findSum function recursively to all the digits except the last digit.
			//The last digit gets added to the result of the recursive call of the remaining previous digits.
		    return (findSum(Array, N - 1) + Array[N - 1]);
		}
	}

	// Main method
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		// Creating a variable N
		int N;  
		
		// Creating a scanner object
		Scanner sc =new Scanner(System.in);
		
		// Printing the statement "Enter the number of elements you want to find the sum of:"
		System.out.print("Enter the number of elements you want to find the sum of: ");  
		
		//Reading the number of elements from the that we want to enter  
		N=sc.nextInt();  
		
		//Creates an array in the memory of length N
		int[] Array = new int[N];  
		
		// Printing the statement "Enter the numbers whose sum we want to calculate:"
		System.out.println("Enter the numbers whose sum we want to calculate: ");  
		
		// For loop to read array elements from the user and storing in the array
		for(int i=0; i< N; i++)  {  
			
		Array[i]=sc.nextInt();  
		
		}  

		// Printing the statement "The sum of the integers (array elements) using recursion is: "
		System.out.print("The sum of the integers (array elements) using recursuion is: "); 
		
		// We call the findSum function giving the array as the input and the array length as input and then we print the result.
		System.out.println(findSum(Array, Array.length));
	}

}