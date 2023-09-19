package de.emilius123;

import java.util.Random;

public class ArrayShittery {
	private static final String SEED = "Chabos wissen, wer der Babo ist (Herr Dyrauf)";
	
	public static void babaKrasseArrayUebung() {
		int[] krasserArray = new int[20];
		tankstelle(krasserArray);
		printArray(krasserArray, false);
		printArray(krasserArray, true);
		
		System.out.println("\n------------------------------");
		System.out.println("Größte Zahl im Array: " + findLargest(krasserArray));
		System.out.println("Kleinste Zahl im Array: " + findSmallest(krasserArray));
		
		isEven(420);
	}
	
	public static boolean isEven(int number) {
		System.out.print("Ist " + number + " gerade? Die Antwort ist, überraschenderweise: ");
		if(number % 2 == 0) {
			// Gerade Zahl
			System.out.print("Ja");
			return true;
		}
		
		System.out.print("Nein");
		return false;
	}
	
	public static void changeArray(int[] array, int newNumber, int newNumberSlot) {
		if(newNumberSlot <= array.length) {
			array[newNumberSlot] = newNumber;
		} else {
			System.out.println("Alter, bist du lost.");
		}
	}
	
	public static int findLargest(int[] array) {
		int largest = -69;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > largest) {
				// Found new largest
				largest = array[i];
			}
		}
		
		return largest;
	}
	
	public static int findSmallest(int[] array) {
		int smallest = 50000;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < smallest) {
				// Found new largest
				smallest = array[i];
			}
		}
		
		return smallest;
	}
	
	public static void printArray(int[] array, boolean backwards) {
		if(!backwards) {
			// Vorwärts
			System.out.println("\nMach vorwärts, die Scheiße");
			for(int i = 0; i < array.length; i++) {
				System.out.print(array[i] + ",");
			}
		} else {
			// Print backwards
			System.out.println("\nLESSGO! Rückwärts!");
			int okBrudiMongo = array.length - 1;
			
			for(int i = 0; i < array.length; i++) {
				//System.out.println("Array size: " + array.length + "; i: " + i + "; Gemacht wird: " + (array.length - i));
				
				System.out.print(array[okBrudiMongo-i] + ",");
			}
		}
	}
	
	/**
	 * Füllt die Scheiße auf, wie ne Gülletankstelle
	 * @param array Array, der vollzutanken ist (Super Bleifrei)
	 */
	public static void tankstelle(int[] array) {
		long seed = (long) SEED.hashCode();
		Random random = new Random();
		random.setSeed(seed);

		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(101);
		}
	}
}
