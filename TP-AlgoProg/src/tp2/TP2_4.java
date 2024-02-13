package tp2;

import utilGraphics.TPGUISwing;

public class TP2_4 extends TPGUISwing {

	/** Question1 : recupère numéro de ligne et colonne (champs "lig" et "col")
	 *  et dessine une croix sur la case correspondante */
	public static void question1() {
		int lig = getIntF("lig");
		int col = getIntF("col");
		graphDrawLine(100+col*50, 10+lig*50,100+(col-1)*50,10+(lig-1)*50);
		graphDrawLine(100+col*50, 10+(lig-1)*50,100+(col-1)*50,10+lig*50);
	}

	/** Question2 : récupère un numero de case (champs "num") 
	 * (a partir de 1, de gauche a droite et de base en haut),
	 *  et dessine une croix sur la case correspondante */
	public static void question2() {
		int num = getIntF("num");
		int lig = (num-1)/11+1;
		int col = (num-1)%11+1;
		graphDrawLine(100+col*50, 10+lig*50,100+(col-1)*50,10+(lig-1)*50);
		graphDrawLine(100+col*50, 10+(lig-1)*50,100+(col-1)*50,10+lig*50);
	}

	/** Question3 : prend en parametre les coordonnees (x,y) d'un point sur
	 *  lequel l'utilisateur a clique, et doit donner
	 *  1) le numero de ligne et de colonne de la case correspondante, 
	 *  2) son numero global
	 *  3) ET dessiner une croix sur cette case 
	 *  @param x abscisse du point 
	 *  @param y ordonnée du point */
	public static void question3(int x, int y) {
		int col, lig;
		col = (x-50)/50;
		graphOut.println("Colonne: "+col);
		lig = (y-10)/50+1;
		graphOut.println("Ligne: "+lig);
	}

	/** dessine_grille (déjà faite): dessine une grille 10x8 à
	 *  partir du point (100,10), chaque case etant un carre de côte 50 */
	public static void dessine_grille() {
		clearGraphPanel();
		for (int it=0;it<=11;it=it+1) {
			graphDrawLine(100+50*it,10,100+50*it,410);
			if (it>0) displayText(Integer.toString(it),65+50*it,430);
		}
		for (int it=0;it<=8;it=it+1) {
			graphDrawLine(100,10+50*it,650,10+50*it);
			if (it>0) displayText(Integer.toString(it),85,50*it-15);
		}
	}

	
	/***************** NE PAS MODIFIER AU-DELA DE CETTE LIGNE ****************/
	/**
	 * fonction main, TP 2.4
	 * @param args (non utilisé)
	 */
	public static void main(String args[]) {
		TP2_4 tp2_4 = new TP2_4();
		progname="TP2 exo 4";
		tp2_4.start();
	}
	/**
	 * Construction de l'interface graphique pour l'exercice de TP 2.4 
	 */
	protected void initUI() {
		addIntField("lig",6);
		addIntField("col",9);
		addIntField("num",64);
		dessine_grille();
		addButton("Redessiner",TP2_4::dessine_grille);
		addButton("Quitter", TPGUISwing::quit);
		addButton("Question 1",TP2_4::question1);
		addButton("Question 2",TP2_4::question2);

		addMouseClick((x,y) -> { question3(x,y); return null; });
		graphOut.println("Question 1 : cliquer sur 'Question 1'");
		graphOut.println("Question 2 : cliquer sur 'Question 2'");
		graphOut.println("Question 3 : cliquer sur la grille");
	}
	
}
