import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the QuickSort Algorithm!");
		System.out.println("");
		
		boolean mainLoop = true;
		
		while(mainLoop) {
			System.out.println("What do you want to do next?");
			System.out.println("");
			System.out.println("1. Sort an Array.");
			System.out.println("2. Turn OFF the app.");
			System.out.println("");
			System.out.println("Enter your desired option's number:");
			
			int option = scan.nextInt();
			switch(option) {
				case 1:
					System.out.println("");		
					System.out.println("Enter the size of the array:");
					int size = scan.nextInt();
					int[] array = new int[size];
					System.out.println("Great! Now enter the elemnts one-by-one.");
					for(int i = 0; i < size; i++) {
						System.out.println("Enter the element: " + (i+1) + " of " + size + ".");
						array[i] = scan.nextInt();
					}
					System.out.println("The unsorted array is: " + Arrays.toString(array));
					quickSort(array, 0, array.length-1);
					System.out.println("");
					System.out.println("The sorted array is: " + Arrays.toString(array));
					break;
				case 2:
					System.out.println("");
					System.out.println("Turning OFF...");
					mainLoop = false;
			}		
		}
	}
	
	static void swap(int[] array, int value1, int value2) {
		int tempVal = array[value1];
		array[value1] = array[value2];
		array[value2] = tempVal;
		if (array[value1] != array[value2]) {
			System.out.println("The numbers: " + array[value1] + " and " + array[value2] + " have switched places.");
			System.out.println("The array now looks like this: " + Arrays.toString(array));
		}
	}
	
	static int partition(int[] array, int left, int right) {
		int pivot = left, border;
		for(border = left+1; border <= right; border++) {
			if(array[border] < array[left]) {
				swap(array, ++pivot, border);
			}
		}
		swap(array, left, pivot);
		return pivot;
	}
	
	static void quickSort(int[] array, int left, int right) {
		if(left < right) {
			int pivot = partition(array, left, right);
			quickSort(array, left, pivot-1);
			quickSort(array, pivot+1, right);
		}
	}
}