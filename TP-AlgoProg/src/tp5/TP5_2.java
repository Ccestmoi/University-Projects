package tp5;

import utilGraphics.Util_TP5_2;

public class TP5_2 extends Util_TP5_2 {
	
	/** dessin de la "grille" actuelle
	 * � partir du point (10,10), largeur d'un dessin = 180, hauteur = 100
	 * @param tab tab[i][j] donne le num�ro du dessin plac� en ligne i et colonne j
	 */
	public static void dessine_puzzle(int[][] tab) {

	}

	/** V�rifie si le puzzle est termin� (le dessin est correct)
	 * @param tab la "grille" actuelle
	 * @return vrai si le puzzle est termin�, faux sinon
	 */
	public static boolean est_termine(int[][] tab) {
		return false; // � modifier
	}

    /** action effectu�e lors d'un click sur la grille :
	  1) on v�rifie si le click correspond � un mouvement (sinon on retourne faux)
	  2) si oui, on effectue le mouvement en modifiant tab et on retourne vrai
	 * @param tab grille actuelle, �ventuellement modifi�e par la fonction
	 * @param cx abscisse du "click"
	 * @param cy ordonn�e du "click"
	 * @return vrai si la grille a �t� modifi�e (mouvement effectu�), faux sinon
	 */
	public static boolean joue_click(int[][] tab, int cx, int cy) {
		return false; // � modifier
	}

	/* PAS DE MODIFICATION SOUS CETTE LIGNE */


	/**
	 * fonction principale, TP 5.2
	 * @param args (non utilis�)
	 */
	public static void main(String args[]) {
		TP5_2 tp5_2 = new TP5_2();
		progname="TP5 exo 2";
		tp5_2.start();
	}
	/** interface graphique, TP5 exercice 2 
	 * note: une partie du code est sur Util_TP5_2 */
	public void initUI()
	{
	    int[][] tab = new int[4][4];
	    initImages();
	    initPuzzle(tab,true);
	    dessine_puzzle(tab);
		addButton("Init facile",() -> {
			cnt=0;
			initPuzzle(tab,true);
			dessine_puzzle(tab);
			graphOut.println("R�solvez le puzzle...");
		});
		addButton("Init al�atoire",() -> {
			cnt=0;
			initPuzzle(tab,false);
			dessine_puzzle(tab);
			graphOut.println("R�solvez le puzzle...");
		});
		addButton("Quitter", Util_TP5_2::quit);
	    graphOut.println("R�solvez le puzzle...");
		addMouseClick((x,y) -> {
			if (est_termine(tab)) return null;
			if (joue_click(tab,x,y)) {
				cnt=cnt+1;
				graphOut.println("Nombre de mouvements : "+cnt);
				dessine_puzzle(tab);
				if (est_termine(tab)) {
					graphOut.println("Bravo ! Vous avez r�ussi !");
					graphOut.println("Cliquez sur \"Quitter\" pour quitter.");
				}
			}
			return null;
		});
	}
}
