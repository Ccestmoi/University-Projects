package tp4;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import util.IO;

public class TP4_2 {

	/** jeu 1 (deja ecrit) : demande 20 questions, 
	 * le score est le nombre de bonnes reponses 
	 * @return score (nombre de bonnes réponses)
	 */
	public static int jeu1() {
		int i,score;
		score = 0;
		for (i=1;i<=20;i=i+1) {
			boolean res_question;
			System.out.println("Question numero "+i);
			res_question = poser_question();
			if (res_question) {
				score = score +1;
			}
			System.out.println("Score actuel : "+score);
		}
		return score;
	}

	/** jeu 2 (à ecrire): pas de limite au nombre de questions. 
	 * Bonne reponse = +1 point, mauvaise reponse = -1 a condition 
	 * que le score reste >=0. 
	 * On arrete quand le score atteint 10.
	 * A chaque tour, vous devez afficher le score en cours.
	 * @return score (forcément 10)
	 */
	public static int jeu2() {
		return 0; /* a modifier pour retourner le score final */
	}

	/** jeu 3 (à écrire) : 20 questions. 
	 * On ne gagne 1 point que si on répond correctement et que
	 * la réponse precedente etait egalement correcte (donc n reponses 
	 * correctes consecutives rapportent n-1 points). 
	 * Une reponse correcte a la premiere question ne fait rien gagner.
     * Vous devez afficher a chaque tour le score actuel, et si une reponse 
     * correcte fait a la question en cours fait gagner ou non 1 point.
     * @return le score final.
     */
	public static int jeu3() {
		return 0; /* a modifier pour retourner le score final */
	}

	/** jeu 4 (à écrire) : 20 questions maximum. 
	 * On s'arrete a la premiere mauvaise reponse.
     * Chaque bonne reponse rapporte 1 point.
	 * @return le score final.
	 */
	public static int jeu4() {
		return 0; /* a modifier pour retourner le score final */
	}

	/** jeu 5 (a ecrire) : on dispose d'un score "reel" et d'un score temporaire.
	 *  Le score temporaire est initialement a 0, passe a 1 apres une bonne reponse,
	 *  puis est doublé à chaque bonne reponse (donc 1 2 4 8 ...). A chaque 
	 *  mauvaise reponse, le score temporaire est ajoute au score "réel" puis est 
	 *  remis a 0. On s'arrete a 20 questions, et le dernier score temporaire est 
	 *  ajouté au score "reel" a la fin du jeu.
     *  Par exemple, avec la sequence (B : bonne reponse, M : mauvaise reponse) :
     *  B M B B B M B B B M B B M M M B B B B B fin
     *  on obtient la sequence apres chaque question (score temporaire a gauche ;
     *  score reel a droite ) :
     * B(1,0) M(0,1) B(1,1) B(2,1) B(4,1) M(0,5) B(1,5) B(2,5) B(4,5) M(0,9) B(1,9) 
     * B(2,9) M(0,11) M(0,11) M(0,11) B(1,11) B(2,11) B(4,11) B(8,11) B(16,11) fin(0,27), 
     * le score retourné est donc 27.
     * A chaque tour, vous devez afficher le score temporaire et le score "reel".
	 * @return Le score "réel" final
	 */
	public static int jeu5() {
		return 0; /* a modifier pour retourner le score final */
	}

	/** jeu 6 : semblable au jeu 5 mais le score "réel" est cette fois le 
	 * maximum des scores temporaires atteint et non leur somme. 
	 * Le résultat avec l'exemple precedent serait donc 16.
     * DE PLUS, le jeu s'arrête des que le score temporaire/reel atteint 1024 .
     * A chaque tour, vous devez afficher le score temporaire et le score reel 
     * @return Le score "réel" final
     */
	public static int jeu6() {
		return 0; /* a modifier pour retourner le score final */
	}

	/** jeu 7 : semblable au jeu 6 mais quand le score atteint 1024, 
	 * on peut continuer a jouer (et donc monter au-delà : 2048 4096 ...) 
	 * tant qu'on répond correctement aux questions. Le jeu s'arrete <i>dans ce cas</i>
     * (si score >= 1024) des qu'une réponse incorrecte est donnee.
     * On s'arrete egalement au bout de 20 questions.
	 * @return Le score final
	 */
	public static int jeu7() {
		return 0; /* a modifier pour retourner le score final */
	}

	/* NE PAS MODIFIER LE CODE A PARTIR DE CETTE LIGNE */
	
	/** fonction main 
	 * @param args (non utilisé)
	 * @throws IOException (si la lecture du fichier des questions provoque
	 * une erreur, le programme s'arrête sur une "exception") */
	public static void main(String[] args) throws IOException
	{
		int n, score_final;
		lire_fichier();
		System.out.print("Entrez le numero de votre jeu (de 1 à 7) : ");
		n = IO.lireInt();
		while ((n<1) || (n>7)){
			System.out.print("Numero incorrect. Entre 1 et 7 : ");
			n = IO.lireInt();
		}
		switch (n) {
		case 1 : score_final = jeu1();
		break;
		case 2 : score_final = jeu2();
		break;
		case 3 : score_final = jeu3();
		break;
		case 4 : score_final = jeu4();
		break;
		case 5 : score_final = jeu5();
		break;
		case 6 : score_final = jeu6();
		break;
		case 7 : score_final = jeu7();
		break;
		default : System.out.println("Erreur de numero !");
		score_final = 0;
		}
		System.out.println("Score final obtenu : "+score_final);
	}

	/* lecture et gestion des questions */
	/** nombre de questions */
	private static int nb_capitales;
	/** liste des questions */
	private static ArrayList<String> capitales = new ArrayList<String>();
	/** générateur pseudo-aléatoire pour tirer les questions au sort */
	private static final Random randgen = new Random();

	/**
	 * pose une question aléatoirement, et attend la réponse de l'utilisateur. 
	 * @return vrai si la réponse est correcte, faux sinon.
	 */
	public static boolean poser_question() {
		int npays = randgen.nextInt(nb_capitales);
		int ncap = randgen.nextInt(nb_capitales-1);
		int first = randgen.nextInt(2);
		int reponse;
		if (ncap>=npays) {
			ncap = ncap+1;
		}
		System.out.println("Quelle est la capitale du pays : "+capitales.get(2*npays)+ "?");
		if (first==1) {
			System.out.println("1) "+capitales.get(2*npays+1)+"\t\t2) "+capitales.get(2*ncap+1));
		} else {
			System.out.println("1) "+capitales.get(2*ncap+1)+"\t\t2) "+capitales.get(2*npays+1));
		}
		reponse = IO.lireInt();
		if (reponse+first==2) {
			System.out.println("Bonne réponse !");
		} else {
			System.out.println("Mauvaise réponse !\n");
		}
		return (reponse+first==2);
	}

	/**
	 * Lecture du fichier de questions (data/TP4_2/capitales.txt)
	 * @throws IOException si le fichier n'a pu être ouvert
	 */
	private static void lire_fichier() throws IOException {
		FileReader fichier = new FileReader("data/TP4_2/capitales.txt");
		BufferedReader lecture = new BufferedReader(fichier);
		int n=0;
		String line;

		try {
			while ((line = lecture.readLine())!=null) {
				String[] tab = line.split(" *\t+ *");
				capitales.add(tab[0]); capitales.add(tab[1]);
				n=n+1;
			}
		} catch (EOFException e) {
		}
		System.out.println("Fin de fichier, "+n+" capitales lues.");
		nb_capitales=n;
		lecture.close();
	}
}
