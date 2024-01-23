package tp4;

import utilGraphics.TPGUISwing;

public class TP4_1 extends TPGUISwing {
	
	/** dessin1 : r�cup�re un entier n et dessine une ligne de disques */
	public static void dessin1() {
		/* int n = getIntF("n"); */
		/* ... */
	}

	/** dessin2 : r�cup�re n et dessine une ligne de disques de couleurs altern�es */
	public static void dessin2() {
	}

	/** dessin3 : r�cup�re n et h et dessine un "rectangle" de disques */
	public static void dessin3() {
	}

	/** dessin4 : r�cup�re n et dessine un triangle de disques */
	public static void dessin4() {
	}
	
	/** dessin5 : r�cup�re n et dessine une pyramide de disques */
	public static void dessin5() {
	}
	
	/***************** NE PAS MODIFIER AU-DELA DE CETTE LIGNE ****************/
	/**
	 * fonction main, TP 4.1
	 * @param args (non utilis�)
	 */
	public static void main(String args[]) {
		TP4_1 tp4_1 = new TP4_1();
		progname="TP4 exo 1";
		tp4_1.start();
	}
	/**
	 * Construction de l'interface graphique pour l'exercice de TP 4.1 
	 */
	protected void initUI() {
		addIntField("n (base)","n",6);
		addIntField("h (hauteur)","h",4);
		
		addButton("Effacer", () -> { clearGraphPanel(); });
		addButton("Quitter", TPGUISwing::quit);
		addButton("Dessin 1",TP4_1::dessin1);
		addButton("Dessin 2",TP4_1::dessin2);
		addButton("Dessin 3",TP4_1::dessin3);
		addButton("Dessin 4",TP4_1::dessin4);
		addButton("Dessin 5",TP4_1::dessin5);
		graphOut.println("Dessins 1, 2, 4 et 5 utilisent le champs n.");
		graphOut.println("Dessin 3 utilise les champs n et h.");
		graphOut.println("N'oubliez pas d'effacer entre chaque dessin.");
	}

}
