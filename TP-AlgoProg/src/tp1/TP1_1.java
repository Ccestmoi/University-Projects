package tp1;

import util.IO;

public class TP1_1 {

	/**
	 * Le programme demande le nom de l'utilisateur et affiche
	 * "Bonjour " suivi de ce nom.
	 * @param args (non utilisé)
	 */
	public static void main(String[] args) {
		Integer age;
		System.out.print("Entrez votre age : ");
		age = IO.lireInt();
		System.out.println("Vous avez "+age+" ans");
    }
}
