package tp8;

import java.awt.Color;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import utilGraphics.TPGUISwing;

public class TP8_1 extends TPGUISwing {

	/* Question 1 : faire l'implantation du tri rapide 
	 * dans Tris.java */
	
	/* Question 2 : analyse de la complexité : à faire ci-dessous */
	
	/** 
	 * class Resultat : type enregistrement avec deux champs (taille et temps)<br>
	 * {@code double taille, temps;}
	 */
	public static class Resultat {
		public double taille; // taille du tableau trié
		public double temps;  // temps pour faire le tri (en ms)
	}


	/** 
	 * Dessin des mesures
	 * @param mesures le tableau des mesures à dessiner
	 */
	public static void drawResults (Resultat[] mesures) {
	}
	
	/**
	 * evaluation de la complexité : vous pouvez soit
	 * compléter drawResults, soit écrire une nouvelle
	 * fonction qui sera appelée depuis drawResults.
	 */

	/** dessin des axes 
	 */
	public static void drawAxes() {
	   graphDrawLine(50,380,950,380,127,127,127);
	   graphDrawLine(100,400,100,10,127,127,127);
	   graphDrawLine(900,370,900,390,127,127,127);
	   graphDrawLine(90,20,110,20,127,127,127);
	   displayText("Taille",400,400);
	   displayText("Temps (ms)",5,200);
	}
	
	/* NE PAS MODIFIER SOUS CETTE LIGNE */
	
	/**
	 * fonction principale, TP8 (tris)
	 * @param args (non utilisé)
	 */
	public static void main(String[] args) {
		TP8_1 tp8_1 = new TP8_1();
		progname="TP8";
		tp8_1.start();
	}
	protected static ButtonGroup tg1;

	/* Gestion de la question 1 */
	/** taille du tableau à trier en question 1  = 70 */
	private static final int tailleTabQ1 = 70;
	/** tableau à trier (statique) pour la question 1 */
	private static double[] tabstatic = new double[tailleTabQ1];
	/** couleurs d'affichage des valeurs */
	private static Color[] tabcolor = new Color[tailleTabQ1];
	/** rectangle à afficher */
	private static GraphPanel.PlainRect[] tabrectangle = new GraphPanel.PlainRect[tailleTabQ1];
	/** en cours d'affichage (question 1) */
	private static boolean inQuestion1 = false;
	/** generateur aléatoire */
	private static Random randgen = new Random();
	/**
	 * initialisation aléatoire d'un tableau de double entre 0.0 et 1.0
	 * @param tab le tableau à remplir
	 */
	private static void remplitTabDouble(double[] tab) {
		for (int i=0;i<=tab.length-1;i=i+1) {
		   tab[i] = randgen.nextDouble();
		}
	}
	/**
	 * "marque" (en orange) les indices entre deb et fin (question 1 uniquement)
	 * @param deb début de la zone
	 * @param fin fin de la zone
	 * @Precondition deb et fin doivent être des indices valides (entre 0 et 69)
	 */
	public static void mark_array_range(int deb, int fin) {
		int i;
		if (!inQuestion1) return;
		for (i=deb;i<=fin;i=i+1) {
			tabcolor[i]=Color.ORANGE;
		}
	}
	/**
	 * "marque" (en rouge) l'indice ind (question 1 uniquement)
	 * @param ind l'indice à marquer
	 * @Precondition ind doit être un indice valide (entre 0 et 69)
	 */
	public static void mark_array_index(int ind) {
		if (!inQuestion1) return;
		tabcolor[ind]=Color.RED;

	}
	/**
	 * enlève le marquage (met en vert) les indices de deb à fin (question 1 uniquement)
	 * @param deb début de la zone
	 * @param fin fin de la zone
	 * @Precondition deb et fin sont des indices valides (entre 0 et 69)
	 */
	public static void unmark_array_range(int deb, int fin) {
		int i;
		if (!inQuestion1) return;
		for (i=deb;i<=fin;i=i+1) {
			tabcolor[i]=Color.GREEN;
		}
	}
	/**
	 * enlève le marquage (met en vert) l'indice ind (question 1 uniquement)
	 * @param ind l'indice à démarquer
	 * @Precondition ind doit être valide (entre 0 et 69)
	 */
	public static void unmark_array_index(int ind) {
		if (!inQuestion1) return;
		tabcolor[ind]=Color.GREEN;
	}

	/** enlève tous les marquages (question 1 uniquement)
	 */
	public static void unmark_all() {
		if (!inQuestion1) return;
		for (int i=0;i<=tabcolor.length-1;i=i+1) {
			tabcolor[i] = Color.GREEN;
		}
	}

	/** question 1 : met à jour l'affichage et attend time millisecondes
	 * @param time le temps à attendre (en ms)
	 */
	public static void update_display(int time) {
		if (!inQuestion1) return;
		SwingUtilities.invokeLater(TP8_1::dessineTableau);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * mise à jour et dessin du tableau
	 */
	protected static void dessineTableau() {
		for (int i=0;i<tabstatic.length-1;i=i+1) {
			tabrectangle[i].updateHeight((int) (400*tabstatic[i]));
			tabrectangle[i].updateY((int) (425-400*tabstatic[i]));
			tabrectangle[i].updateC(tabcolor[i]);
			tabrectangle[i].setVisible(true);
		}
		updatePanel();
	}
	/**
	 * langement du tri
	 * @param nbtri numéro du tri (In)
	 * @param tab tableau à trier (InOut)
	 */
	protected static void lanceTri(int nbtri, double[] tab) {
		switch (nbtri) {
		case 0: Tris.triBulle(tab); break;
		case 1: Tris.triInsertion(tab); break;
		case 2: Tris.triSelection(tab); break;
		case 3: Tris.triFusion(tab); break;
		case 4: Tris.triRapide(tabstatic); break;
		case 5: Tris.triTas(tab); break;
		case 6: Tris.triPeigne(tab); break;
		case 7: Tris.triFaireValoir(tab); break;	
		default: graphOut.println("Erreur de numéro de tri !");
		}		
	}
	/**
	 * lancement du test d'un tri (question 1)
	 */
	protected static void launchTest() {
		clearGraphPanel();
		remplitTabDouble(tabstatic);
		/* initialise tout en vert */
		for (int i=0;i<=tabcolor.length-1;i=i+1) {
			tabcolor[i] = Color.GREEN;
			tabrectangle[i] = new GraphPanel.PlainRect
					(Color.GREEN, (int) (1000/tabcolor.length-3),
					(int) (400*tabstatic[i]));
			tabrectangle[i].updateX((int) (i*1000/tabcolor.length));
			graphPanel.addDrawable(tabrectangle[i]);
		}
		dessineTableau();
		setActiveButtonPanel(false);
		setActiveFieldPanel(false);
		final int nbtri = getSelectedButton(tg1);
		inQuestion1 = true;
		SwingWorker<Void,Void> trieur = new SwingWorker<Void,Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				lanceTri(nbtri,tabstatic);
				return null;
			}
			@Override	
			protected void done() {
				dessineTableau();
				setActiveButtonPanel(true);
			    setActiveFieldPanel(true);
				inQuestion1=false;
				try {
				   get();
			    	graphOut.println("Fin du test.");
				} catch (ExecutionException | InterruptedException ex) {
				    graphOut.println("Echec du tri : le programme a planté !");
			    }
			}				
		};

		Thread taskthread = new Thread(trieur);
		taskthread.start();
	}

	protected static Resultat[] remplitMesures(int nbtri) {
		   int taille=200;
		   int nbmes=0;
		   long temps_total=0;
		   ArrayList<Resultat> resultats = new ArrayList<Resultat>();
		   while (temps_total<5000 && taille<10000000) {
		      double[] tab = new double[taille];

		      remplitTabDouble(tab);
		      Instant start = Instant.now();
		      lanceTri(nbtri,tab);
	//	      System.out.println(nbtri + " " + tab[0] + " " + tab[taille-1]);
		      Instant end = Instant.now();
		      Duration elapsed = Duration.between(start, end);
		      long inmillis = elapsed.toMillis();
		      Resultat res = new Resultat();
		      res.taille=taille;
		      res.temps=inmillis;
	//	      System.out.println(elapsed.toString());
		      resultats.add(res);
		      nbmes=nbmes+1;
		      temps_total=temps_total+inmillis;
		      SwingUtilities.invokeLater( () -> 
		          {  graphOut.printf("taille %g, temps %g ms\n", 
		    		  res.taille, res.temps); });
		      taille = (int) Math.round(taille*1.2);
		   }
		   Resultat[] ret = new Resultat[resultats.size()];
		   return resultats.toArray(ret);
	}
	protected static void launchComplexity() {
		final int nbtri = getSelectedButton(tg1);
		setActiveButtonPanel(false);
		setActiveFieldPanel(false);
		SwingWorker<Resultat[],Void> trieur = new SwingWorker<Resultat[],Void>() {

			@Override
			protected Resultat[] doInBackground() throws Exception {
				return remplitMesures(nbtri);
			}
			@Override	
			protected void done() {
		    	setActiveButtonPanel(true);
				setActiveFieldPanel(true);
				try {
  				  Resultat[] res = this.get();
  		    	  graphOut.println("Fin. Nombre de mesures " + res.length);
		    	  clearGraphPanel();
		    	  drawAxes();
		    	  drawResults(res);
				} catch (ExecutionException | InterruptedException ex) {
			    	graphOut.println("Echec des mesures : le programme a planté !");
				}
			}			
			
		};

		Thread taskthread = new Thread(trieur);
		taskthread.start();

	}

   	public void initUI() {
   	    addButton("Tester",() -> { launchTest(); });
		addButton("Complexité", () -> { launchComplexity(); } );
		addButton("Quitter", TPGUISwing::quit);
		tg1 = addRadioButtons("Tri utilisé",
				"Bulles","Insertion","Sélection","Fusion",
				"Rapide","Tas","Peigne","FaireValoir");
//		addMouseMoved((x,y) -> { gereSouris(x,y,false); return null; });
//		addMouseClick((x,y) ->  { gereSouris(x,y,true); return null; });
	}
}
