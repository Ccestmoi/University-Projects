package tp2;

import utilGraphics.TPGUISwing;

public class TP2_3 extends TPGUISwing {

	/** Dessin numéro 1 : récupérer x, y et H (avec getIntF) et
	 * dessiner le dessin de l'enoncé 
	 * utiliser graphDrawLine(x1,y1,x2,y2) pour dessiner une ligne de (x1,y1)
	 * à (x2,y2) */
	public static void dessin1() {
		int x = getIntF("x"); 
		int y = getIntF("y");
		int H = getIntF("H");
		graphDrawLine(x, y, x+H, y-H);
		graphDrawLine(x+H, y-H, x+2*H, y);
		graphDrawLine(x+2*H, y, x+H, y+H);
		graphDrawLine(x+H, y+H, x, y);
	}

	/** Dessin numéro 2 : récupérer x, y et H et
	 * dessiner le dessin de l'enoncé */
	public static void dessin2() {
		int x = getIntF("x"); 
		int y = getIntF("y");
		int H = getIntF("H");
		graphDrawLine(x, y, x+H, y-H);
		graphDrawLine(x+H, y-H, x+2*H, y);
		graphDrawLine(x+2*H, y, x+H, y+H);
		graphDrawLine(x+H, y+H, x, y);
		graphDrawLine(x+H/2, y-H/2, x+3*H/2, y+H/2);
		graphDrawLine(x+H/2, y+H/2, x+3*H/2, y-H/2);
	}

	/** Dessin numéro 3 : récupérer x, y et H et
	 * dessiner le dessin de l'enoncé */
	public static void dessin3() {
		int x = getIntF("x"); 
		int y = getIntF("y");
		int H = getIntF("H");
		graphDrawLine(x, y, x+H, y-H);
		graphDrawLine(x+H, y-H, x+2*H, y);
		graphDrawLine(x+2*H, y, x+H, y+H);
		graphDrawLine(x+H, y+H, x, y);
		graphDrawLine(x+H/2, y-H/2, x+3*H/2, y+H/2);
		graphDrawLine(x+H/2, y+H/2, x+3*H/2, y-H/2);
		graphDrawLine(x+H/4, y-H/4, x+3*H/4, y+H/4);
		graphDrawLine(x+H/4, y+H/4, x+3*H/4, y-H/4);
		graphDrawLine(x+H/4+H, y+H/4, x+H+3*H/4, y-H/4);
		graphDrawLine(x+H/4+H, y-H/4, x+H+3*H/4, y+H/4);
	}

	/***************** NE PAS MODIFIER AU-DELA DE CETTE LIGNE ****************/
	/**
	 * fonction main, TP 2.3
	 * @param args (non utilisé)
	 */
	public static void main(String args[]) {
		TP2_3 tp2_3 = new TP2_3();
		progname="TP2 exo 3";
		tp2_3.start();
	}
	/**
	 * Construction de l'interface graphique pour l'exercice de TP 2.3 
	 */
	protected void initUI() {
		addIntField("x",10);
		addIntField("y",150);
		addIntField("H",100);
		addButton("Quitter", TP2_3::quit);
		addButton("Effacer", () -> { clearGraphPanel(); });

		addButton("Dessin 1",TP2_3::dessin1);
		addButton("Dessin 2",TP2_3::dessin2);
		addButton("Dessin 3",TP2_3::dessin3);

		graphOut.println("Cliquez sur le bouton pour chaque dessin");
	}
	
}
