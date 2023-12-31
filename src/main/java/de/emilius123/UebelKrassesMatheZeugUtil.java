package de.emilius123;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class UebelKrassesMatheZeugUtil {
	
		/**
		 * Gettet richtig clean alle Teiler. Bitte benutzen, ansonsten wird sie einsam.
		 * 
		 * @param baba Zahl, deren Teiler zu ermitteln sind
		 * @return Alle Teiler der Zahl
		 */
	
		public static int[] teilerGetten(int baba) {
			ArrayList<Integer> teiler = new ArrayList<>();
			
			for(int i = 1; i < baba; i++) {
				if(baba % i == 0) {
					// Ist ein cleaner Teiler
					teiler.add(i);
				}
			}
			
			Object[] babaArray = teiler.toArray(); // JRE 19 ist ein Spast
			return objectArrayToIntArray(babaArray);
		}

	public static ArrayList<BigInteger> teilerGetten(BigInteger baba) {
		ArrayList<BigInteger> teiler = new ArrayList<>();

		// Da es keine cleanen Teiler, die kleiner als 2 sind geben kann, loop nur bis die Hälfte + 1 (sodass die Hälfte noch drinnen ist)
		for(BigInteger i = BigInteger.ONE; !i.equals(baba.divide(BigInteger.TWO).add(BigInteger.ONE)); i = i.add(BigInteger.ONE)) {
			if(baba.remainder(i).equals(BigInteger.ZERO)) {
				System.out.println("Teiler gefunden: " + i.toString());

				teiler.add(i);
			}
		}

		return teiler;
	}
		
		/**
		 * Gettet, ob eine Zahl clean vollkommen ist oder halt nicht 
		 * 
		 * @param toCheck Die Zahl, deren Sauberkeit zu ermittelt ist
		 * @return Ob die Zahl �bel clean ist, oder nicht
		 */
		public static boolean isVollkommen(int toCheck) {
			int[] teiler = teilerGetten(toCheck);
			
			return addArrayValues(teiler) == toCheck;
		}

		public static boolean isVollkommen(BigInteger toCheck) {
			ArrayList<BigInteger> teiler = teilerGetten(toCheck);

			return addArrayValues(teiler).equals(toCheck);
		}
		
		public static int[] findVollkommeneZahlen(int range, boolean drecksKonsoleZuspammen) {
			ArrayList<Integer> found = new ArrayList<Integer>();
			
			for(int i = 2; i < range; i++) {
				if(drecksKonsoleZuspammen) {
					System.out.println("Überprüfe Vollkommenheit von " + i);
				}
				
				if(isVollkommen(i)) {
					found.add(i);
				}
			}
			
			int[] foundArray = objectArrayToIntArray(found.toArray());
			System.out.println("-- Leak vollkommener Zahlen von 2 - " + range + ": --");
			System.out.println(Arrays.toString(foundArray));
			
			return foundArray;
		}
		
		public static boolean isSublime(int zahl) {
			int[] teiler = teilerGetten(zahl);
			boolean isTeilerAnzahlVollkommen = isVollkommen(teiler.length + 1); // +1, da teilerGetten() die Zahl selbst, die theoretisch auch ein Teiler ist, nicht berücksichtigt
			boolean isTeilerSummeVollkommen = isVollkommen(addArrayValues(teiler) + zahl); // +zahl, da teiletGetten() die Zahl selbst nicht berücksichtigt
			
			boolean isSublime = (isTeilerAnzahlVollkommen && isTeilerSummeVollkommen);
			
			String insertion = "";
			if(!isSublime) insertion = "k";
			
			System.out.println(zahl + " ist " + insertion + "eine erhabene Zahl!");
			
			return isSublime;
		}
		
		private static int addArrayValues(int[] array) {
			int arraySumme = 0;
			
			for(int i = 0; i < array.length; i++) {
				arraySumme = arraySumme + array[i];
			}
			
			return arraySumme;
		}

		private static BigInteger addArrayValues(ArrayList<BigInteger> array) {
			BigInteger arraySumme = BigInteger.ZERO;

			for(BigInteger i = BigInteger.ZERO; !i.equals(BigInteger.valueOf(array.size())); i = i.add(BigInteger.ONE)) {
				arraySumme = arraySumme.add(array.get(Integer.valueOf(i.toString())));
			}

			return arraySumme;
		}
		
		/***
		 * Was ist denn mit Karsten los? Das sieht gar nicht gut aus.
		 */
		private static int[] objectArrayToIntArray(Object[] input) {
			int[] cool = new int[input.length];
			
			for(int i = 0; i < input.length; i++) {
				cool[i] = (int) input[i];
			}
			
			return cool;
		}
	
}
