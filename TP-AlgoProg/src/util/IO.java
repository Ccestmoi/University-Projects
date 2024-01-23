package util;

import java.util.Scanner;

// Fonctions d'entrées de base pour les TP d'algo et prog :
// lecture d'entiers, de flottant, de booléens, de chaine

public final class IO {
	
	private static Scanner entree = new Scanner(System.in);
	
	/**
	 * lit l'entier (type int) suivant sur l'entrée standard et le retourne
	 * @return l'entier lu
	 */
	public static int lireInt() {
		int lu = entree.nextInt();
		return lu;
	}
	/**
	 * lit le flottant (type double) suivant sur l'entrée standard et le retourne
	 * @return le double lu
	 */
	public static double lireDouble() {
		double lu = entree.nextDouble();
		return lu;
	}
	/**
	 * lit un caractère (le premier caractère du prochain mot lu)
	 * ce caractère ne peut être ni un espace, ni un passage à la ligne
	 * @return le caractère lu
	 */
	public static char LireChar() {
		char lu = entree.next(".").charAt(0);
		while (Character.isSpaceChar(lu)) {
			lu = entree.next(".").charAt(0);
		}
		return lu;
		
	}
	/** lit sur l'entrée standard et retourne le prochain mot
	 *  (entre espaces ou retour à la ligne) 
	 * @return le mot lu
	 */
	public static String lireString() {
		String lu = entree.next();
		return lu;
	}
	
	/** lit une ligne non vide 
	 * @return la ligne lue
	 */
	public static String lireLigne() {
		String lu = entree.nextLine();
		while (lu.isBlank()) {
			lu = entree.nextLine();
		}
		return lu;
	}
	
}