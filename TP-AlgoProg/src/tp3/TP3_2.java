package tp3;


import utilGraphics.TPGUISwing;

public class TP3_2 extends TPGUISwing {

	/* QUESTION 1 */

	/**
	 * Face avec 0 point (carr� seul)
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr� (non utilis� ici)
	 */
	public static void dessine_de0(int x1, int y1, int w, double r) {
	}

	/**
	 * Face avec 1 point 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de1(int x1, int y1, int w, double r) {
	}

	/**
	 * Face avec 2 points 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de2(int x1, int y1, int w, double r) {
	}

	/**
	 * Face avec 3 points 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de3(int x1, int y1, int w, double r) {
	}
	
	/**
	 * Face avec 4 points 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de4(int x1, int y1, int w, double r) {
	}
	
	/**
	 * Face avec 5 points 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de5(int x1, int y1, int w, double r) {
	}

	/**
	 * Face avec 6 points 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de6(int x1, int y1, int w, double r) {
	}
	
	/**
	 * Face avec 7 points 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de7(int x1, int y1, int w, double r) {
	}

	/**
	 * Face avec 8 points 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de8(int x1, int y1, int w, double r) {
	}
	
	/**
	 * Face avec 9 points 
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur du carr�
	 */
	public static void dessine_de9(int x1, int y1, int w, double r) {
	}

	/* QUESTION 2 */

	/** Dessine une "face" � 5 points (sans le carr�)
	 * 
	 * @param x1 abscisse gauche
	 * @param y1 ordonn�e haut
	 * @param w largeur de la "face"
	 * @param r diam�tre des points (relativement � la largeur du carr�)
	 */
	public static void construit_face5(double x1, double y1, double w, double r) {
	}

	/** dessine 5 appels � construit_face125 (donc 625 points)
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur des sous-carr�s
	 */
	public static void construit_face25(double x1, double y1, double w, double r) {
	}

	/** dessine 5 appels � construit_face25 (donc 125 points)
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur des sous-carr�s
	 */	
	public static void construit_face125(double x1, double y1, double w, double r) {
	}

	/** dessine 5 appels � construit_face125 (donc 625 points)
	 * @param x1 abscisse du bord gauche
	 * @param y1 ordonn�e du bord haut
	 * @param w largeur du carr�
	 * @param r diam�tre des points relativement � la largeur des sous-carr�s
	 */	
	public static void construit_face625(double x1, double y1, double w, double r) {
	}

	
	/** Test de la question 1 : dessine chaque face un fois
	 */
	public static void question1() {
        dessine_de0(110,10,150,0.18);
        dessine_de1(270,10,150,0.18);
        dessine_de2(430,10,150,0.18);
        dessine_de3(590,10,150,0.18);
        dessine_de4(750,10,150,0.18);
        dessine_de5(110,230,150,0.18);
        dessine_de6(270,230,150,0.18);
        dessine_de7(430,230,150,0.18);
        dessine_de8(590,230,150,0.18);
        dessine_de9(750,230,150,0.18);
	}

	/** Test de la question 2 (fait un appel � chaque construitFace) */
	public static void question2() {
        construit_face5(10,40,216,0.334);
        construit_face25(230,40,216,0.334);
        construit_face125(450,40,216,0.334);
        construit_face625(670,40,216,0.334);
	}

	
	/***************** NE PAS MODIFIER AU-DELA DE CETTE LIGNE ****************/
	/**
	 * fonction main, TP 3.2
	 * @param args (non utilis�)
	 */
	public static void main(String args[]) {
		TP3_2 tp3_2 = new TP3_2();
		progname="TP3 exo 2";
		tp3_2.start();
	}
	/**
	 * Construction de l'interface graphique pour l'exercice de TP 3.2 
	 */
	protected void initUI() {
		addButton("Effacer",() -> { clearGraphPanel(); });
		addButton("Quitter", TPGUISwing::quit);
		addButton("Question 1",TP3_2::question1);
		addButton("Question 2",TP3_2::question2);
		graphOut.println("Question 1 : cliquer sur 'Question 1'");
		graphOut.println("Question 2 : cliquer sur 'Question 2'");
	}

}
