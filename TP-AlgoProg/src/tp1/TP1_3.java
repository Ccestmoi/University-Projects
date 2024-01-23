package tp1;

import utilGraphics.TPGUISwing;


public class TP1_3 extends TPGUISwing {
	
	/** Dessine un cube en perspective, en fonction des valeurs entrées
	 * pour x, y, H1, H2 et L2. <br>
	 * <b>A corriger pour le TP</b>
	 */
	public static void dessine() {
		int x,y,H1,H2,L2;
		
		/****
		 * Récupération des valeurs de x, y, H1, H2 et L2 dans l'interface graphique
		 * cette partie n'est pas à modifier
		 */
		x = getIntF("x");
		y = getIntF("y");
		H1 = getIntF("H1");
		H2 = getIntF("H2");
		L2 = getIntF("L2");
		
		/**** Partie à corriger ci-dessous pour prendre en compte les valeurs
		 * de x, y, H1, H2 et L2
		 */
		graphDrawLine(x,y,x,y+H1);
		graphDrawLine(x,y+H1,x+L2,y+H1+H2);
		graphDrawLine(x+L2,y+H1+H2,x+2*L2, y+H1);
		graphDrawLine(x+2*L2,y+H1, x+2*L2, y);
		graphDrawLine(x+2*L2,y,x+L2,y-H2);
		graphDrawLine(x+L2,y-H2,x,y);
		graphDrawLine(x,y,x+L2,y+H2);
		graphDrawLine(x+L2,y+H2,x+L2,y+H2+H1);
		graphDrawLine(x+L2,y+H2,x+2*L2,y);
	}


	/***************** NE PAS MODIFIER AU-DELA DE CETTE LIGNE ****************/
	
	/**
	 * fonction main, TP 1.3
	 * @param args (non utilisé)
	 */
	public static void main(String args[]) {
		TP1_3 tp1_3 = new TP1_3();
		progname="TP1 exo 3";
		tp1_3.start();
	}
	/**
	 * Construction de l'interface graphique pour l'exercice de TP 1.3 
	 */
	protected void initUI() {
		addIntField("x",50);
		addIntField("y",100);
		addIntField("H1",100);
		addIntField("H2",30);
		addIntField("L2",100);
		addButton("Dessin",() -> { clearGraphPanel(); dessine(); });
		addButton("Quitter",TPGUISwing::quit);
		graphOut.println("Cliquez sur 'Dessin' pour lancer le dessin");
	}

}
