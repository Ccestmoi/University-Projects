package tp2;

import util.IO;

public class TP2_1et2 {

	/** Exercice 1 : lire un entier n representant une   
	 * annee et ecrire a) le siecle en cours, b) si l'année est bissextile   
	 * c) le nombre d'annees bissextiles de 2000 a n (pour 2001<=n<=2099) 
	 * d) le nombre de jours entre le 1er janvier 2000 et le 31 décembre 
	 * de l'annee n  (pour 2001<=n<=2099) */
	public static void exercice1() {
		int n, siecle,nbbis, jours;
		boolean bissextile;
		System.out.print("Entrez une année: ");
		n = IO.lireInt();
		siecle = (n+99)/100;
		System.out.println(siecle+"ème siècle.");
		bissextile = ((n%4==0)&&(n%100!=0)||(n%400==0));
		System.out.println(bissextile);
		nbbis = (n-2000)/4+1;
		System.out.println("Nombre d'années bissextiles: "+nbbis);
		jours = 365*(n-1999)+nbbis;
		System.out.println("Il ya "+jours);
	}

	/** Exercice 2 : traduction des algorithmes du TD : <br>    
	 * lire un entier n et afficher 1/2*n*(n+1), et lire deux reels a et b 
	 * et resoudre ax+b = 0 */
	public static void exercice2() {
		int n;
		Double a, b;
		System.out.print("Entrez un entier :");
		n = IO.lireInt();
		System.out.println( n*(n+1)/2);
		System.out.print("Entrez une valeur :");
		a = IO.lireDouble();
		System.out.print("Entrez une valeur :");
		b = IO.lireDouble();
		System.out.println(-b/a);
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
