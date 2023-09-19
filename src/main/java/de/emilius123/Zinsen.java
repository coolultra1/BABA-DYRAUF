package de.emilius123;

import java.text.DecimalFormat;

public class Zinsen {
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public static void zinsesrechnung(){

		double kapital = 1000.0;
		double zinssatz = 0.02;
		double zinsen;
		int jahrDesGrossenRaubs = 2023;
		int laufzeit = 30;
		String kunde ="Herr Maier";

		for (int i = 1; i <= laufzeit; i++){
			zinsen = kapital * zinssatz;
			zinsen = ((int)(zinsen*100))/100.0;
			kapital = kapital + zinsen;
			System.out.println(kunde + ", sein Kapital " + i + " Jahre nach dem großen Raub (" + ((i+jahrDesGrossenRaubs)) + ") beträgt " + df.format(kapital) + "€");
		}

	}

}

// Aufgabe d):
// Um nur alle zwei Jahre Zinsen zu berechnen, muss man einfach die Jahresangaben * 2 nehmen == EZ