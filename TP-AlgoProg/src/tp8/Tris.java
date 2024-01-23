package tp8;

public class Tris {

	/**
	 * echange deux valeurs (d'indice i et j) dans un tableau de double
	 * @param tab le tableau de double (InOut)
	 * @param i 1er indice (In)
	 * @param j 2ème indice (In)
	 * @precondition i et j sont des indices valides de tab
	 */
	public static void echange_deux_valeurs(double[] tab, int i, int j) {
		double tmp;
		tmp = tab[j];
		tab[j] = tab[i];
		tab[i]=tmp;
	}
	
	/** TRI RAPIDE A IMPLANTER **/
	/* 1) d'abord l'algorithme de partition */
	
	/* ... */
	
	/* 2) puis la fonction récursive triRecRapide */
	public static void triRapideRec(double[] tab, 
									int debut, int fin) {
		/* ... a remplir ... */
	}
	
	/* 3) puis l'appel à cette fonction */
	/**
	 * Tri d'un tableau de double par la méthode du tri rapide
	 * @param tab le tableau à trier (InOut)
	 */
	public static void triRapide(double[] tab) {
		triRapideRec(tab,0,tab.length-1);
	}
 	

	/** AUTRES TRIS (DEJA ECRITS) **/
	
	/**
	 * Tri à bulles sur un tableau de double
	 * @param tab le tableau à trier (InOut) 
	 */
	public static void triBulle(double[] tab) {
		int i;
		boolean termine=false;
		i = tab.length-1;
		while (i>0 && !termine) {
			int j;
			termine=true;
			for (j=0;j<=i-1;j=j+1) {
				if (tab[j]>tab[j+1]) {
					echange_deux_valeurs(tab,j,j+1);
					termine=false;
				}
			}
			TP8_1.mark_array_index(i);
			TP8_1.update_display(100);
			i=i-1;
		}
	}




	/**
	 * tri par sélection d'un tableau de double
	 * @param tab le tableau à trier (InOut)
	 */
	public static void triSelection(double[] tab) {
		int i;
		for (i=tab.length-1;i>=1;i=i-1) {
			int imax=0,j;
			for (j=1;j<=i;j=j+1) {
				if (tab[j]>tab[imax]) {
					imax=j;
				}
			}
			echange_deux_valeurs(tab,imax,i);
			TP8_1.mark_array_index(imax);
			TP8_1.mark_array_index(i);
			TP8_1.update_display(200);
			if (i!=imax) TP8_1.unmark_array_index(imax);
		}
	}

	/**
	 * tri par insertion d'un tableau de double
	 * @param tab le tableau à trier (InOut)
	 */
	public static void triInsertion(double[] tab) {
		int i;
		for (i=1; i<=tab.length-1; i=i+1) {
			int j=i;
			boolean place=false;
			double val = tab[i];
			while (j>0 && !place) {
				if (val<tab[j-1]) {
					tab[j]=tab[j-1];
					j=j-1;
					TP8_1.update_display(10);
				} else {
					place=true;
				}
			}
			tab[j]=val;
			TP8_1.mark_array_index(j);
			TP8_1.mark_array_range(j+1,i);
			TP8_1.update_display(200);
			TP8_1.unmark_all();
		}
	}

	/** 
	 * algorithme de fusion de deux morceaux de tab (tableau de double), entre
	 * <b>deb</b> et <b>mil</b>-1 et entre <b>mil</b> et <b>fin</b>. La fusion est
	 * faite sur un tableau temporaire, puis recopiée sur le tableau initial 
	 * @param tab Le tableau sur lequel la fusion est faite (InOut)
	 * @param tmptab tableau temporaire (ni In, ni Out)
	 * @param deb début de la première zone (In) 
	 * @param mil début de la seconde zone (In)
	 * @param fin fin de la seconde zone (In)
	 * @precondition tab est trié entre les indices deb et mil-1 et entre les indices mil et fin-1,
	 *         tmptab a une taille suffisante
	 */
	public static void fusion(double[] tab, double[] tmptab, int deb, int mil, int fin) {
		int i;
		int ig=deb, id=mil;
		// double[] tmptab = new double[fin-deb+1];
		for (i=deb;i<=fin;i=i+1) {
			boolean gauche=true;
			if (ig==mil) {
				gauche=false;
			} else if (id<=fin) {
				if (tab[id]<tab[ig]) {
					gauche=false;
				}
			}
			if (gauche) {
				tmptab[i] = tab[ig];
				ig = ig+1;
			} else {
				tmptab[i] = tab[id];
				id = id+1;
			}
		}
		for (i=deb;i<=fin;i=i+1) {
			tab[i]=tmptab[i];
		}
	}
	/**
	 * Tri fusion sur un tableau de double : algorithme récursif
	 * @param tab le tableau à trier entre deb et fin (InOut)
	 * @param tmptab tableau temporaire pour la fusion (ni In ni Out...)
	 * @param deb début de la zone à trier (In)
	 * @param fin fin de la zone à trier (In)
	 * @precondition tab est défini entre deb et fin. tmptab a la taille de tab
	 */
	public static void triRecFusion(double[] tab, double[] tmptab, int deb, int fin) {
		int milieu;
		if (fin<=deb) return;
		milieu = (fin+deb)/2;
		triRecFusion(tab,tmptab,deb,milieu);
		triRecFusion(tab,tmptab,milieu+1,fin);
		fusion(tab,tmptab, deb,milieu+1,fin);
		TP8_1.mark_array_range(deb,fin);
		TP8_1.update_display(200);
		TP8_1.unmark_array_range(deb,fin);
	}
	/**
	 * Tri fusion : appel de la fonction récursive
	 * @param tab tableau à trier (InOut)
	 */
	public static void triFusion(double[] tab) {
		double[] tmptab = new double[tab.length];
		triRecFusion(tab,tmptab,0,tab.length-1);
	}

	/* Tri par tas */

	/* Gestion du tas */
	/**
	 * indice du père à partir de l'indice du fils dans un tas représenté par un tableau
	 * @param a indice du fils (In)
	 * @return l'indice du père, soit (<b>a</b>-1)/2
	 */
	public static int indpere(int a) {
		return (a-1)/2;
	}
	/**
	 * indice du premier fils à partir de l'indice du père dans un tas représenté par un tableau
	 * @param a indice du père (In)
	 * @return l'indice du premier file (<a>*2+1)
	 */
	public static int indfils1(int a) {
		return a*2+1;
	}

	/*** filtre_bas : "replace" la valeur a l'indice i dans le tas en le   ***/
	/*** "descendant" s'il est plus petit qu'un de ses descendants         ***/
	/** "descend" un élément dans le tas pour le remettre à sa place
	 *  En fin de fonction, le tableau aura la propriété de tas de i à
	 *  taille-1.
	 * @param tas un tableau représentant (à terme) un tas (InOut)
	 * @param taille la partie du tableau utilisé pour représenter le tas (In)
	 * @param i l'indice de l'élément à replacer (In)
	 * @precondition le tableau doit avoir la propriété de tas de i+1 jusqu'à taille-1
	 *    (c'est-à-dire tab[j]>=tab[2*j+1] et tab[j]>=tab[2*j+2] si ces indices
	 *    existent et j>i). 
	 */
	public static void filtre_bas(double[] tas, int taille, int i) {
		boolean place=false;
		while (!place) {
			int imax=i, ifils=indfils1(i);
			place=true;
			if (ifils<taille) {
				if (tas[ifils]>tas[i]) {
					imax=ifils;
				}
				if (ifils+1<taille) {
					if (tas[ifils+1]>tas[imax]) {
						imax=ifils+1;
					}
				}
				if (imax!=i) {
					echange_deux_valeurs(tas,i,imax);
					TP8_1.mark_array_index(imax);
					i = imax;
					place=false;
				}
			}
		}
	}

	/**
	 * retire le maximum du tas (indice 0) et le place à la fin (indice ifin) avec
	 * un échange entre les indice 0 et ifin, puis reconstruit le tas sur la zone 0,ifin-1.
	 * @param tab le tableau qui représente un tas entre les indices 0 et ifin (InOut)
	 * @param ifin l'indice de fin du tas (In)
	 * @precondition tab doit avoir la propriété du tas des indices 0 à ifin (en fin 
	 * de fonction, cette propriété ne s'applique plus que de 0 à ifin-1)
	 */
	public static void enleve_tas(double[] tab, int ifin) {
		echange_deux_valeurs(tab,0,ifin);
		TP8_1.mark_array_index(0);
		filtre_bas(tab,ifin,0);
	}

	/** 
	 * tri par tas d'un tableau de double, fonction principale
	 * @param tab le tableau à trier (InOut)
	 */
	public static void triTas(double tab[]) {
		/* construction du tas par filtre bas */
		int i;
		for (i=indpere(tab.length-1);i>=0;i=i-1) {
			TP8_1.mark_array_index(i);
			filtre_bas(tab,tab.length,i);
			TP8_1.update_display(200);
			TP8_1.unmark_all();
		}
		/* destruction du tas et construction du tableau trié */
		for (i=tab.length-1;i>=1;i=i-1) {
			enleve_tas(tab,i);
			TP8_1.mark_array_range(i,tab.length-1);
			TP8_1.update_display(200);
			TP8_1.unmark_all();
		}
	}

	/* Tris supplementaires */

	/** tri à peignes : a priori rapide, d'analyse compliquée 
	 * @param tab tableau à trier (InOut)
	 */
	public static void triPeigne(double[] tab) {
		int i;
		int ecart=tab.length-1;
		boolean echange = true;
		while (ecart>1 || echange) {
			echange=false;
			for (i=0;i<=tab.length-1-ecart;i=i+1) {
				if (tab[i]>tab[i+ecart]) {
					echange_deux_valeurs(tab,i,i+ecart);
					TP8_1.update_display(5);
					echange=true;
				}
			}
			ecart = (int) (ecart /1.3);
			if (ecart==0) ecart=1;
			TP8_1.mark_array_index(ecart);
			TP8_1.update_display(100);
		}
	}

	/** tri faireValoir : récursif et super-lent. Ceci est la partie récursive.
	 * @param tab tableau à trier (InOut)
	 * @param deb début de la zone à trier (In)
	 * @param fin fin de la zone à trier (In)
	 */
	public static void triFaireValoirRec(double[] tab, int deb, int fin) {
		if (tab[deb]>tab[fin]) {
			echange_deux_valeurs(tab,deb,fin);
		}
		if (fin-deb>1) {
			TP8_1.mark_array_range(deb,fin);
			TP8_1.update_display(1);
			TP8_1.unmark_all();
			int range=(fin-deb+1)/3;
			triFaireValoirRec(tab, deb, fin-range);
			triFaireValoirRec(tab, deb+range, fin);
			triFaireValoirRec(tab, deb, fin-range);
		}
	}
	/**
	 * tri faire valoir : fonction principale
	 * @param tab le tableau à trier (InOut)
	 */
	public static void triFaireValoir(double[] tab) {
		triFaireValoirRec(tab,0, tab.length-1);
	}

}
