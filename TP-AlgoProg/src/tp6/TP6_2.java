package tp6;

import util.IO;

public class TP6_2 {

	/* code pour dechiffrer le chiffre de Cesar */
	/* la fonction doit modifier str     */
	/* ecrire la spécification "correcte" */
	public static void dechiffreCesar(char[] str, int decalage) {
	}

	/* dechiffrage du chiffre de Vigenere   */
	/* la fonction doit modifier str */
	public static void dechiffreVigenere(char[] str, char[] cle) {
	}


	/* chiffrage par permutation des lettres */
	/* la fonction doit remplir strcodee
     a partir de str et retourner la longueur utilisée */
	public static int chiffrePermut(char[] str, char[] strcodee, int n) {
		return 0; // code à modifier
	}

	/* dechiffrage par permutation de lettres */
	/* la fonction doit placer dans str le contenu de la chaine
	 * decodee à partir de strcodee et retourner la longueur */
	public static int dechiffrePermut(char[] strcodee, char[] str, int n) {
		   return 0; // code à modifier
	}


	/** fonction de test sur le déchiffrage de Cesar
	 */
	public static void testeDechiffreCesar()
	{
		String chaine1 = "GIGM IWX YRI GLEMRI HIGLMJJVII";
		char[] cchaine1= chaine1.toCharArray();
		int decalage1=4;
		String chaine2 = "CVJ JREXCFKJ CFEXJ UVJ MZFCFEJ UV C'RLKFDEV SCVJJVEK DFE TFVLI U'LEV CREXLVLI DFEFKFEV";
		char[] cchaine2=chaine2.toCharArray();
		int decalage2=17;
		System.out.println("1ere chaine a dechiffrer : \n"+chaine1);
		System.out.println("avec décalage : " + decalage1);
		System.out.println("Resultat : ");
		dechiffreCesar(cchaine1, decalage1);
		System.out.println(String.valueOf(cchaine1));
		System.out.println("2eme chaine a dechiffrer : \n"+chaine2);
		System.out.println("avec décalage : " + decalage2);
		System.out.println("Resultat : ");
		dechiffreCesar(cchaine2, decalage2);
		System.out.println(String.valueOf(cchaine2));
	}

	/** fonction de test sur le déchiffrage de Vigenere
	 */
	public static void testeDechiffreVigenere() {
		String chaine1="BCGJF, K'XZF YN MKOL BKHHEIW";
		String cle1="ALGORITHME";
		String chaine2="EOEZVZ OQ ZXEHD NHUEON AH PLGQ NPDNQ WLI RGQT";
		String cle2="PANGRAMME";
		System.out.println("1ere chaine a dechiffrer : ");
		System.out.println(chaine1);
		System.out.println("avec cle : "+cle1);
		System.out.println("Resultat : ");
		char[] cchaine1 = chaine1.toCharArray();
		char[] ccle1 = cle1.toCharArray();
		dechiffreVigenere(cchaine1, ccle1);
		System.out.println(String.valueOf(cchaine1));
		System.out.println("2eme chaine a dechiffrer : ");
		System.out.println(chaine2);
		System.out.println("avec cle : "+cle2);
		System.out.println("Resultat : ");
		char[] cchaine2 = chaine2.toCharArray();
		char[] ccle2 = cle2.toCharArray();
		dechiffreVigenere(cchaine2, ccle2);
		System.out.println(String.valueOf(cchaine2));
	}

	/** fonction de test sur chiffrePermut et dechiffrePermut
	 */
	public static void testePermut() {
		String chaine1="Mo  nerNg steilsasroantangtofge re  p: cio aomul uprau";
		char[] cchaine1 = chaine1.toCharArray();
		char[] cchaine3 = new char[60];
		int n1 = 5;
		String chaine2="B'nelescreéz' aéas -odgdvt!vrueeo  oi  n,gSugmpt aasier cgv nsé?";
		char[] cchaine2 = chaine2.toCharArray();
		char[] cchaine4 = new char[90];
		int n2 = 8;
		System.out.println("Test de chiffrePermut (sur une chaine chiffree par dechiffrePermut)");
		System.out.println("Chaine : "+ chaine1);
		System.out.println("Valeur de n : "+n1);
		System.out.println("Resultat : ");
		int len3 = chiffrePermut(cchaine1,cchaine3,n1);
		System.out.println(String.valueOf(cchaine3,0,len3));
		System.out.println("Test de dechiffrePermut (sur une chaine chiffree par chiffrePermut)");
		System.out.println("Chaine : "+chaine2);
		System.out.println("Valeur de n : "+n2);
		System.out.println("Resultat : ");
		int len4 = dechiffrePermut(cchaine2,cchaine4,n2);
		System.out.println(String.valueOf(cchaine4,0,len4));
	}

	/** 
	 * programme principal, TP6 exo 2
	 * @param args (non utilisé)
	 */
	public static void main(String[] args)
	{
		int choix;
		boolean quitter=false;
		while (!quitter) {
			System.out.println("Quelle question voulez-vous tester ?");
			System.out.println("1 : Cesar   2 : Vigenere    3 : permutation     0 : quitter ?");
			choix = IO.lireInt();
			switch (choix) {
			case 1 : {
				testeDechiffreCesar();
				break;
			}
			case 2 : {
				testeDechiffreVigenere();
				break;
			}
			case 3 : {
				testePermut();
				break;
			}
			case 0 : quitter=true; break;
			default : {
				System.out.println("Choix invalide !\n");
			}
			}
		}
	}

}
