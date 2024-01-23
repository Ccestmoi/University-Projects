package tp2;

import util.IO;

public class TP2_1et2 {

	/** Exercice 1 : lire un entier n representant une   
	 * annee et ecrire a) le siecle en cours, b) si l'année est bissextile   
	 * c) le nombre d'annees bissextiles de 2000 a n (pour 2001<=n<=2099) 
	 * d) le nombre de jours entre le 1er janvier 2000 et le 31 décembre 
	 * de l'annee n  (pour 2001<=n<=2099) */
	public static void exercice1() {

	}

	/** Exercice 2 : traduction des algorithmes du TD : <br>    
	 * lire un entier n et afficher 1/2*n*(n+1), et lire deux reels a et b 
	 * et resoudre ax+b = 0 */
	public static void exercice2() {

	}


	/** Programme principal
	 * @param args (non utilisée)
	 */
	public static void main(String[] args) {
		boolean quitter=false;
		int choix;
		while (!quitter) {
			System.out.print("Exercice 1 ou 2 (0 pour quitter) : ");
			choix = IO.lireInt();
			if (choix==1) {
				exercice1();
			} else if (choix==2) {
				exercice2();
			} else if (choix==0) {
				quitter=true;
			} else {
				System.out.println("Numero invalide !");
			}
		}	 
	}

}
