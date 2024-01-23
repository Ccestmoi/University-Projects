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
	
	/* Question 2 : analyse de la complexit� : � faire ci-dessous */
	
	/** 
	 * class Resultat : type enregistrement avec deux champs (taille et temps)<br>
	 * {@code double taille, temps;}
	 */
	public static class Resultat {
		public double taille; // taille du tableau tri�
		public double temps;  // temps pour faire le tri (en ms)
	}


	/** 
	 * Dessin des mesures
	 * @param mesures le tableau des mesures � dessiner
	 */
	public static void drawResults (Resultat[] mesures) {
	}
	
	/**
	 * evaluation de la complexit� : vous pouvez soit
	 * compl�ter drawResults, soit �crire une nouvelle
	 * fonction qui sera appel�e depuis drawResults.
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
	 * @param args (non utilis�)
	 */
	public static void main(String[] args) {
		TP8_1 tp8_1 = new TP8_1();
		progname="TP8";
		tp8_1.start();
	}
	protected static ButtonGroup tg1;

	/* Gestion de la question 1 */
	/** taille du tableau � trier en question 1  = 70 */
	private static final int tailleTabQ1 = 70;
	/** tableau � trier (statique) pour la question 1 */
	private static double[] tabstatic = new double[tailleTabQ1];
	/** couleurs d'affichage des valeurs */
	private static Color[] tabcolor = new Color[tailleTabQ1];
	/** rectangle � afficher */
	private static GraphPanel.PlainRect[] tabrectangle = new GraphPanel.PlainRect[tailleTabQ1];
	/** en cours d'affichage (question 1) */
	private static boolean inQuestion1 = false;
	/** generateur al�atoire */
	private static Random randgen = new Random();
	/**
	 * initialisation al�atoire d'un tableau de double entre 0.0 et 1.0
	 * @param tab le tableau � remplir
	 */
	private static void remplitTabDouble(double[] tab) {
		for (int i=0;i<=tab.length-1;i=i+1) {
		   tab[i] = randgen.nextDouble();
		}
	}
	/**
	 * "marque" (en orange) les indices entre deb et fin (question 1 uniquement)
	 * @param deb d�but de la zone
	 * @param fin fin de la zone
	 * @Precondition deb et fin doivent �tre des indices valides (entre 0 et 69)
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
	 * @param ind l'indice � marquer
	 * @Precondition ind doit �tre un indice valide (entre 0 et 69)
	 */
	public static void mark_array_index(int ind) {
		if (!inQuestion1) return;
		tabcolor[ind]=Color.RED;

	}
	/**
	 * enl�ve le marquage (met en vert) les indices de deb � fin (question 1 uniquement)
	 * @param deb d�but de la zone
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
	 * enl�ve le marquage (met en vert) l'indice ind (question 1 uniquement)
	 * @param ind l'indice � d�marquer
	 * @Precondition ind doit �tre valide (entre 0 et 69)
	 */
	public static void unmark_array_index(int ind) {
		if (!inQuestion1) return;
		tabcolor[ind]=Color.GREEN;
	}

	/** enl�ve tous les marquages (question 1 uniquement)
	 */
	public static void unmark_all() {
		if (!inQuestion1) return;
		for (int i=0;i<=tabcolor.length-1;i=i+1) {
			tabcolor[i] = Color.GREEN;
		}
	}

	/** question 1 : met � jour l'affichage et attend time millisecondes
	 * @param time le temps � attendre (en ms)
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
	 * mise � jour et dessin du tableau
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
	 * @param nbtri num�ro du tri (In)
	 * @param tab tableau � trier (InOut)
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
		default: graphOut.println("Erreur de num�ro de tri !");
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
				    graphOut.println("Echec du tri : le programme a plant� !");
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
			    	graphOut.println("Echec des mesures : le programme a plant� !");
				}
			}			
			
		};

		Thread taskthread = new Thread(trieur);
		taskthread.start();

	}

   	public void initUI() {
   	    addButton("Tester",() -> { launchTest(); });
		addButton("Complexit�", () -> { launchComplexity(); } );
		addButton("Quitter", TPGUISwing::quit);
		tg1 = addRadioButtons("Tri utilis�",
				"Bulles","Insertion","S�lection","Fusion",
				"Rapide","Tas","Peigne","FaireValoir");
//		addMouseMoved((x,y) -> { gereSouris(x,y,false); return null; });
//		addMouseClick((x,y) ->  { gereSouris(x,y,true); return null; });
	}
}
