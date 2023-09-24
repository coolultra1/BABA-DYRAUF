package de.emilius123;

import java.util.Arrays;

/***
 * @author Hausmuffel
 */
public class komischeZahlen {

	public static int[] whatDivider(int number){
		if(number > 0) {
			
			//int a[] = new int[number];
			int arrayLength = 0;
		
			for(int divider = 1; divider < number; divider++){
				if(number % divider == 0){
					arrayLength++;
				}
			}
		
			int array[] = new int[arrayLength];
			int arrayStelle = 0;
			
			for(int divider = 1; divider < number; divider++){
				if(number % divider == 0){
					array[arrayStelle] = divider;
					arrayStelle++;
				}
			}
			//System.out.println("Teiler von " + number + " sind: " + Arrays.toString(array));
			
			return array;
		}
		return null;
		
	}
	public static boolean isPerfectNumber(int isPerfect){
		if(isPerfect > 0 && isPerfect % 2 == 0) {
			
			//int a[] = new int[number];
			int arrayLength = 0;
		
			for(int divider = 1; divider < isPerfect; divider++){
				if(isPerfect % divider == 0){
					arrayLength++;
				}
			}
		
			int array[] = new int[arrayLength];
			int arrayStelle = 0;
			
			for(int divider = 1; divider < isPerfect; divider++){
				if(isPerfect % divider == 0){
					array[arrayStelle] = divider;
					arrayStelle++;
				}
			}
			int coolVariable = 0;
			for(int counter = 0; counter < array.length; counter++) {
				coolVariable += array[counter];
			if(coolVariable == isPerfect) {
				return true;
			}
			}
		}
		return false;
	}
	
	
	public static void print(String entry) {
		System.out.println(entry);
	}
	
	public static int isSublimeNumber(int isSublime) {
		
		int arraySublimeDividerMissing[];
		arraySublimeDividerMissing = whatDivider(isSublime);
		int arraySublimeDividerLength = arraySublimeDividerMissing.length + 1;
		//print(Integer.toString(arraySublimeDividerLength));
		int arraySublimeDivider[] = new int[arraySublimeDividerLength];
		//print(Arrays.toString(arraySublimeDivider));
		
		
		for(int counter = 0; counter <= arraySublimeDividerLength - 2; counter++) {
			arraySublimeDivider[counter] = arraySublimeDividerMissing[counter];
		}
		arraySublimeDivider[arraySublimeDividerLength - 1] = isSublime;
		System.out.println(Arrays.toString(arraySublimeDivider));
		int sumDivider = 0;
		
		for(int counter = 0; counter < arraySublimeDividerLength; counter++) {
			sumDivider += arraySublimeDivider[counter];
		}
		System.out.println("Summe der Teiler: " + sumDivider);
		int dividerAmount = arraySublimeDividerLength;
		
		boolean isSumDividerPerfect = isPerfectNumber(sumDivider);
		boolean isDividerAmountPerfect = isPerfectNumber(dividerAmount);
		
		//print("Teiler von " + Integer.toString(isSublime) + " sind " + Arrays.toString(arraySublimeDivider));
		//print("Teilersumme von " + Integer.toString(isSublime) + " ist " + Integer.toString(sumDivider));
		//print("Die Teileranzahl von " + Integer.toString(isSublime) + " ist " + Integer.toString(dividerAmount));
		
		int amountIsSublime = 0;
		int NotSublime = 0;
		
		if(isSumDividerPerfect == true && isDividerAmountPerfect == true) {
			print("Die Zahl " + Integer.toString(isSublime) + " ist erhaben");
			amountIsSublime += 1;
			return amountIsSublime;
		}
		else {
			print("Die Zahl " + Integer.toString(isSublime) + " ist langweilig");
			return NotSublime;
		}
	}
	
	public static void main(String[] args) {
		print("Vollkommene Zahlenabteil: ");
		whatDivider(0);
		boolean answer = isPerfectNumber(0);
		if(answer == true) {
			print("Die Zahl ist Vollkommen!");
		}
		else{
			print("Die Zahl ist langweilig.");
		}
		print("Erhabene Zahlenabteil: ");
		//isSublimeNumber(12);
		
		int oneToMaximum = 1;
		int Maximum = 660;
		int amountIsSublimeNumber = 0;
		
		while(oneToMaximum <= Maximum) {
			amountIsSublimeNumber += isSublimeNumber(oneToMaximum);
			oneToMaximum++;
		}
		print("Anzahl erhabener Zahlen: " + Integer.toString(amountIsSublimeNumber));
	}

}
