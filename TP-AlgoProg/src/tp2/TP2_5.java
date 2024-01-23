package tp2;

import utilGraphics.TPGUISwing;

public class TP2_5 extends TPGUISwing {

	/** Question1 : recupère numéro de ligne et colonne (champs "lig" et "col")
	 *  et dessine une croix sur la case correspondante */
	public static void question1() {

	}

	/** Question2 : récupère un numero de case (champs "num") 
	 * (a partir de 1, de gauche a droite et de base en haut),
	 *  et dessine une croix sur la case correspondante */
	public static void question2() {

	}

	/** Question3 : prend en parametre les coordonnees (x,y) d'un point sur
	 *  lequel l'utilisateur a clique, et doit donner
	 *  1) le numero de ligne et de colonne de la case correspondante, 
	 *  2) son numero global
	 *  3) ET dessiner une croix sur cette case 
	 *  @param x abscisse du point 
	 *  @param y ordonnée du point */	
	public static void question3(int x, int y) {
	}

	/** dessine_grille (déjà faite): dessine une grille,
    chaque case étant un hexagone */
	public static void dessine_grille() {
		clearGraphPanel();
		for (int it1=0;it1<=6;it1=it1+1) {
			for (int it2=0;it2<=4;it2=it2+1) {
				if (it2<4) {
					graphDrawLine(50+120*it1+60*(it2%2),40+90*it2,50+120*it1+60*(it2%2),100+90*it2);
					if ((it1<6) || (it2==2))
						graphDrawLine(50+120*it1+60*(it2%2),40+90*it2,110+120*it1+60*(it2%2),10+90*it2);
					if ((it1>0) || (it2%2!=0))
						graphDrawLine(-10+120*it1+60*(it2%2),10+90*it2,50+120*it1+60*(it2%2),40+90*it2);
				} else if (it1<6) {
					graphDrawLine(170+120*it1+60*(it2%2),40+90*it2,230+120*it1+60*(it2%2),10+90*it2);
					graphDrawLine(110+120*it1+60*(it2%2),10+90*it2,170+120*it1+60*(it2%2),40+90*it2);
				}
			}
		}
	}

	/***************** NE PAS MODIFIER AU-DELA DE CETTE LIGNE ****************/
	/**
	 * fonction main, TP 2.5
	 * @param args (non utilisé)
	 */
	public static void main(String args[]) {
		TP2_5 tp2_5 = new TP2_5();
		progname="TP2 exo 5";
		tp2_5.start();
	}
	/**
	 * Construction de l'interface graphique pour l'exercice de TP 2.5
	 */
	protected void initUI() {
		addIntField("lig",2);
		addIntField("col",5);
		addIntField("num",14);
		dessine_grille();
		addButton("Redessiner",TP2_5::dessine_grille);
		addButton("Quitter", TPGUISwing::quit);
		addButton("Question 1",TP2_5::question1);
		addButton("Question 2",TP2_5::question2);
		addMouseClick((x,y) -> { question3(x,y); return null; });
		graphOut.println("Question 1 : cliquer sur 'Question 1'");
		graphOut.println("Question 2 : cliquer sur 'Question 2'");
		graphOut.println("Question 3 : cliquer sur la grille");
	}

}
