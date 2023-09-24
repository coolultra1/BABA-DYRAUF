package de.emilius123;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static Logger logger = Logger.getLogger("Babageiles Programm");
	private static final File BABAGEILE_TEXTDATEI = new File("babaPrimzahlen.txt");
		
	public static void main(String[] args) throws IOException {
		//Zinsen.zinsesrechnung();
		//vergessen();
		//zahlenDing();
		
		//findPrimeNumbers(10000000);
		//ArrayShittery.babaKrasseArrayUebung();

		// Start Dyraufs krasser Aufgabe
		//System.out.println("100: " + matheDing(100, false));
		//System.out.println("1000: " + matheDing(1000, false));
		//System.out.println("50: " + matheDing(50, false));
		// Ende Dyraufs krasser Aufgabe
		
		// Anfang AB Vollkommene + Erhabene Zahlen
		//System.out.println(Arrays.toString(UebelKrassesMatheZeugUtil.teilerGetten(28)));
		//System.out.println(UebelKrassesMatheZeugUtil.isVollkommen(new BigInteger("28")));
		System.out.println(UebelKrassesMatheZeugUtil.findVollkommeneZahlen(100000, true));

		//Beginn Mirkos Kram
		//System.out.println(Arrays.toString(komischeZahlen.whatDivider(12)));
		//komischeZahlen.isSublimeNumber(12);

		//UebelKrassesMatheZeugUtil.findVollkommeneZahlen(10000, true);
		//UebelKrassesMatheZeugUtil.isSublime(12);
		
		//executeSkillDetector();
	}
	
	private static boolean isPrimeNumber(int number) {
		for(int i  = 2; i <number; i++) {
			if(number % i == 0) {
				//System.out.println("Cleaner Teiler " + i + " f�r " + number + " gefunden. Abbrechen.");
				// Ist ein cleaner Teiler, brich ab durch return
				return false;
			}
		
		}
		
		// Sind alle Zahlen durchgelaufen, return true, da ja kein Teiler gefunden wurde
		return true;
	}
	
	private static void findPrimeNumbers(int ende) throws IOException {
		FileWriter writer = new FileWriter(BABAGEILE_TEXTDATEI);
		writer.write("DIE GEILSEN PRIMZAHLEN DES JAHRHUNDERTS:\n");
		writer.write("2 - " + ende + "\n\n");
		
		ArrayList<Integer> babaPrimzahlen = new ArrayList<>();
		
		for(int i = 2; i<=ende; i++) {
			if(isPrimeNumber(i)) {
				System.out.println("Primzahl gefunden: " + i);
				writer.write(String.valueOf(i) + "\n");
				babaPrimzahlen.add(i);
			}
		}
		
		writer.close();
	}
	
	/**
	 * Das hier ist irgendwie kacke. 
	 * Ich wei� jedoch nicht, wieso.
	 * Immerhin funktioniert es.
	 */
	private static void zahlenDing() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Leak eine Zahl: ");
	
		
		int number;
		try {
			number = Integer.valueOf(scanner.nextLine());
			
			if(number < 1) {
				throw new NumberFormatException();
			}
		} catch(NumberFormatException ex) {
			logger.log(Level.SEVERE, "Alter, bist du dumm.");
			return;
		}
		

		System.out.println("Ergebnis: " + matheDing(number, true) + " - EZ!");
	}
	
	/**
	 * Eine einfache Summenfunktion
	 * Auch irgendwie schei�e
	 * 
	 * @param iterations Die Zahl, mit der die Summenfunktion gemacht werden soll
	 * @param spamLog Ob der Log zugesprayt werden soll
	 */
	private static int matheDing(int iterations, boolean spamLog) {
		int epic = 0;
		for(int i = 1; i <= iterations; i++) {
			if(spamLog) {
				System.out.println("Zwischenwert nach " + i + " Iterationen: " + epic);
			}
			epic = epic + i;
		}
		
		return epic;
	}
	
	/**
	 * Hat keinen Sinn
	 */
	private static void vergessen() {
		float geil = 420.69f;
		System.out.print(geil);
		
		if(1+1 == 2) {
			System.out.println(": GEIL");
		}
	}
	
	/**
	 * Bitte ausf�hren und "Skill" testen
	 */
	private static void executeSkillDetector() {
		System.out.print("Gib deinen Namen ein: ");
		String name = new Scanner(System.in).nextLine();
		logger.log(Level.SEVERE, "Keine Bitches bei " + name + " gefunden!");
	}

}
