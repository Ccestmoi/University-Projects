package tp7;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import javax.swing.ButtonGroup;
import javax.swing.SwingWorker;

import utilGraphics.TPGUISwing;

public class TP7_1 extends TPGUISwing {
	
	/**** QUESTION 1 ****/
	
	/* remplir le type enregistrement etat_jeu avec
	 * 1 champs entier nbpiles (nombre de piles)
	 * 1 tableau entiers nbpions (nombre de pions pour chaque
	 * pile)
	 * 1 champs entier joueur (le joueur dont c'est le tour de jouer)
	 */
    public static class etat_jeu {
    }

    /*
     * remplir le type enregistrement coup_joue qui décrit
     * un "coup" d'un joueur avec
     * 1 champs entier qui donne la pile modifiée
     * 1 champs entier qui donne le nombre de pions à enlever
     * de cette pile
     */
    public static class coup_joue {
    }
    
    
	/* remplir la fonction "nouveaujeu" qui retourne un
	 * nouveau etat_jeu, avec 3 piles (4,6 et 10 pions)
	 * et le joueur 1 qui commence. Ne pas oublier *
	 * la spécification.
	 */
	public static etat_jeu nouveauJeu() {
		return new etat_jeu(); /* CODE A CHANGER */
	}
	
	/* remplir la fonction qui retourne le numéro du joueur
	 * d'un etat_jeu
	 */
    public static int numJoueur(etat_jeu ej) {
    	return 0; /* CODE A CHANGER */
    }
    
    /* retourne vrai si le jeu est terminé et faux sinon */
    public static boolean estTermine(etat_jeu jeu) {
    	return false; /* CODE A CHANGER */
    }	
    
    /* affiche le jeu :
     * - par un appel à dessine_piles qui prend le nombre de piles
     * et le nomnbre de pions sur chaque pile
     * - en affichant en plus "joueur en cours" suivi du numéro
     * du joueur
     */
    public static void afficheJeu(etat_jeu jeu) {
    }

    /* affiche un dernière fois le jeu et le numéro du gagnant */
    public static void finDuJeu (etat_jeu jeu) {
    }

    /* "joue" un coup : modifie le paramètre etat_jeu pour
     * prendre en compte le coup cj. retourne true si le
     * coup est valide et a été effectivement joué, false
     * si le coup est impossible (le numéro de pile n'est
     * pas correct, ou il n'y a pas assez de pions)
     * joueCoup doit également afficher (avec graphOut.println)
     * une phrase du type 
     * "Le joueur ... enleve .. pions de la pile ..."
     */
    public static boolean joueCoup(etat_jeu ej, coup_joue cj) {
    	return false; /* A MODIFIER */
    }
    
    /* crée et retourne un nouveau coup créé par l'interface
     * graphique (joueur "humain"). npile est le numéro
     * de la pile (en partant de 0 !) et npions le nombre
     * de pions à **laisser** sur la pile (et non à enlever),
     * obtenu par le click de la souris
     */
    public static coup_joue jeuHumain(etat_jeu ej, int npile, int npions) {
    	return new coup_joue(); /* A MODIFIER */
    }
    
    /**** QUESTION 2 *****/
    
    /* permet d'utiliser le générateur aléatoire :
     * randgen.nextInt(int n) retourne un entier aléatoire
     * entre 0 et n-1.
     */
    public static Random randgen = new Random();
    
    /* crée un coup aléatoire pour l'ordinateur.
     * attention : le coup doit être valide (pile non vide,
     * nombre de pions dans la limite de la pile)
     */
    public static coup_joue ordi0(etat_jeu ej) {
    	return new coup_joue(); /** A MODIFIER **/
    }

    /**** QUESTION 3 *****/

    /* calcul du "nimber" (voir sujet) 
     * fonction calcul_nimber à programmer 
     */

    /* crée un coup parfait pour l'ordinateur (en 
     * utilisant la fonction calcul_nimber).
     * s'il n'est pas possible de garantir la victoire,
     * l'ordinateur peut faire un coup aléatoire.
     */
    public static coup_joue ordi1(etat_jeu ej) {
    	return new coup_joue(); /** A MODIFIER **/
    }    

	/**** interface déjà écrite, ne pas modifier ci-dessous ****/
   	public static void main(String[] args) {
   		TP7_1 tp7_1 = new TP7_1();
		progname="TP7 exo 1";
		tp7_1.start();
	}
    private static GraphPanel.ImageView[][] pieces = null;
   	private static int[] taillepiles;
   	private static int npile_actuel=-1, npion_actuel=-1;
   	private static void init_dessinpiles() {
   		clearGraphPanel();
   		pieces=null;
   		taillepiles=null;
   	}
   	protected static void dessine_piles(int nbpiles, int[] nbpions) {
   		if (pieces==null) {
   			/* reconstruction du dessin */
   	 		graphFillRectangle(50,360,180*nbpiles,20,128,192,192);
   			pieces = litImages("data/TP7_1/piece.bmp",nbpiles,nbpions);
   			taillepiles = new int[nbpiles];
   			for (int i=0;i<nbpiles;i=i+1) {
   				taillepiles[i]= nbpions[i];
   			}
   		} else {
   			changeOpacity(1.0);
   			for (int i=0;i<pieces.length;i=i+1) {
   				taillepiles[i] = nbpions[i]; // TODO : animation ?
   				for (int j=0;j<pieces[i].length;j=j+1) {
   					pieces[i][j].setVisible(j<nbpions[i]);
   				}
   			}
   		}
		npile_actuel=-1; npion_actuel=-1;
   	}
   	protected static void changeOpacity(double val) {
   		if (npile_actuel<0 || npile_actuel>=taillepiles.length) return;
	    for (int j=npion_actuel;j<taillepiles[npile_actuel];j=j+1) {
	   	   	   pieces[npile_actuel][j].setOpacity(val);
	   	}
   	}
   	protected static void updateOmbre(int npile, int npion) {
   	    if (npile!=npile_actuel || npion!=npion_actuel) {
   	    	changeOpacity(1.0);
   	    	npile_actuel=npile;
   	    	npion_actuel=npion;
   	    	changeOpacity(0.8);
   	    	updatePanel();
   	    }
   	}
   	protected static void gereSouris(int x, int y, boolean click) {
   		int npile=-1, npion=-1;
   		if (y<=360 && (x-75)%180<=150) {
   			npile = (x-75)/180;
    		if (npile>=0 && npile<taillepiles.length) {
    			npion = (350-y)/30;
    			if (npion<0 || npion>=taillepiles[npile]) {
    				npile=-1; npion=-1;
    			}
    		} else npile=-1;
   		}
   		if (!click) updateOmbre(npile,npion);
   		else {
   			if (npile==-1) return;
   			coup_joue cj = jeuHumain(ej, npile,npion);
   			if (joueCoup(ej,cj)) {
   				afficheJeu(ej);
   				setActiveGraphPanel(false);
   				nouveau_coup();
   			} else {
   				graphOut.println("Coup généré par jeuHumain invalide pour joueCoup !");
   			}
   		}
   	}
   	
    private static etat_jeu ej;
    private static ButtonGroup tg1;
    private static ButtonGroup tg2;

    protected static void launchIA(Function<etat_jeu,coup_joue> fun_ia) {
    	SwingWorker<coup_joue,Void> task = new SwingWorker<coup_joue,Void>() {
			@Override
			protected coup_joue doInBackground() throws Exception {
				coup_joue cj = fun_ia.apply(ej);
				return cj;
			}
			
			@Override	
			protected void done() {
				try {
				coup_joue cj = get();
				setActiveButtonPanel(true);
		    	if (joueCoup(ej,cj)) {
		    		afficheJeu(ej);
	   				nouveau_coup();
		    	} else {
		    		graphOut.println("Echec de la partie. L'AI a retourné un coup invalide !");
		    		setActiveFieldPanel(true);
		    	}
				} catch (ExecutionException | InterruptedException ex) {
				    graphOut.println("Echec de la partie. L'AI a planté !");
				    setActiveFieldPanel(true);
			    }
			}		
    	};

	    Thread aithread = new Thread(task);
	    aithread.start();
    }
    protected static void nouveau_coup() {
    	if (estTermine(ej)) {
    		finDuJeu(ej);
    		updatePanel();
    		setActiveFieldPanel(true);
    		return;
    	}
    	ButtonGroup tg = (numJoueur(ej)==1 ? tg1 : tg2);
    	switch (getSelectedButton(tg)) {
   		case 1 : // Ordi 0
   			setActiveButtonPanel(false);
   			launchIA(TP7_1::ordi0);
   			break;
   		case 2 : // Ordi 1
   			setActiveButtonPanel(false);
   			launchIA(TP7_1::ordi1);
   			break;
   		default : // humain
   			setActiveGraphPanel(true);
   		}
    }
   	public static void initialise() {
   		ej = nouveauJeu();
   		init_dessinpiles();
		graphOut.println("Cliquez sur \"Commencer\" pour commencer la partie.");
   		afficheJeu(ej);
   		setActiveFieldPanel(true);
   		setActiveButtonPanel(true);
		setActiveGraphPanel(false);

   	}
   	public void initUI() {
		initialise();
		addButton("Reinitialiser",() -> { initialise(); });
		addButton("Quitter", TPGUISwing::quit);
		addButton("Commencer",() -> { setActiveFieldPanel(false);
   									  nouveau_coup(); });
		tg1 = addRadioButtons("Joueur 1","Humain","Ordi 0","Ordi 1");
		tg2 = addRadioButtons("Joueur 2","Humain","Ordi 0","Ordi 1");
		addMouseMoved((x,y) -> { gereSouris(x,y,false); return null; });
		addMouseClick((x,y) ->  { gereSouris(x,y,true); return null; });
		setActiveGraphPanel(false);
	}
}
