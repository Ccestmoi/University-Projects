package utilGraphics;

import java.awt.Color;
import java.util.Random;


public abstract class Util_TP5_2 extends TPGUISwing {

	/**
	 * remplit tab avec une position initiale facile à résoudre.
	 * @param tab La grille à remplir (taille 4*4)
	 * @precondition tab doit être un tableau de 4*4 int
	 */
	protected static void genere_initial_facile(int[][] tab) {
	    int i,j;
	    int[][] tabi = { {2,3,4,8}, {1,6,7,12}, {5,10,11,15}, {9,13,14,0} };
	    for (i=0;i<=3;i=i+1) {
	        for (j=0;j<=3;j=j+1) {
	           tab[i][j]=tabi[i][j];
	        }
	    }
	}
	
	/** générateur pseudo-aléatoire pour position initiale difficile */
	private static final Random randgen = new Random();

	/**
	 * remplit tab avec une position aléatoire mais solvable.
	 * @param tab La grille à remplir (taille 4*4)
	 * @precondition tab doit être tableau de 4*4 int
	 */
	protected static void genere_initial_aleatoire(int[][] tab) {
	   /* tirage aleatoire */
	   int[] perm = new int[15];
	   int i,j,nbv;
	   for (i=0;i<15;i=i+1) {
	       perm[i]=0;
	   }
	   nbv=15;
	   for (i=3;i>=0;i=i-1) {
	      int stj;
	      if (i==3) {
	        stj=2;
	      } else {
	        stj=3;
	      }
	      for (j=stj;j>=0;j=j-1) {
	          int rd = randgen.nextInt(nbv);
	          int u=-1;
	          while (rd>=0) {
	             u=u+1;
	             if (perm[u]==0) {
	                 rd=rd-1;
	             }
	          }
	          tab[i][j]=u+1;
	          perm[u]=nbv;
	          nbv=nbv-1;
	      }
	   }
	   tab[3][3]=0;
	   /* verification de la faisabilite */
	   {
	       int cnt=0;
	       for (i=0;i<=14;i=i+1) {
	         for (j=i+1;j<=14;j=j+1) {
	            if (perm[i]>perm[j]) {
	                cnt=cnt+1;
	            }
	         }
	       }
	       if (cnt%2==1) {
	           /* infaisable ? on echange les deux premiers */
	           int tmp;
	           tmp = tab[0][0];
	           tab[0][0] = tab[0][1];
	           tab[0][1] = tmp;
	       }
	   }
	}

	
	/** nombre de mouvements effectués */
	protected static int cnt=0;
	/** remise à 0 du puzzle
	 * @param tab nouvelle grille
	 * @param facile vrai = grille facile
	 */
	protected static void initPuzzle(int[][] tab, boolean facile) {
		cnt=0;
		if (facile)
	      genere_initial_facile(tab);
		else 
		  genere_initial_aleatoire(tab);
	}
	/** les dessins (extraits de photo) */
	protected static GraphPanel.ImageView[] iv = new GraphPanel.ImageView[15];
	/** le rectangle jaune */
	protected static GraphPanel.PlainRect rectjaune;
	/** récupération des dessins (data/TP5_2/...) */
	protected static void initImages() {
		for (int i=1;i<=15;i=i+1) {
		  iv[i-1] = litImage("data/TP5_2/terenez-"+i+".bmp");
	    }
		rectjaune = new GraphPanel.PlainRect(Color.YELLOW,180,100);
		graphPanel.addDrawable(rectjaune);
	}
	/**
	 * déplace/montre un dessin
	 * @param px abscisse du bord gauche
	 * @param py ordonnée du bord haut
	 * @param num numéro du dessin (0: rectangle jaune, 1-15 : dessin)
	 */
	protected static void graphMontreImage(int px, int py, int num) {
		if (num>0) {
		    montreImage(iv[num-1],px,py);
		} else {
			rectjaune.update(px,py);
		}
		updatePanel();
	}

}
