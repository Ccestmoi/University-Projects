package tp3;

import util.IO;

public class TP3_1 {
	
	/***** METTRE ICI LES FONCTIONS INTERMEDIAIRES ISSUES DU main *****
	/* */
	
	/**
	 * Mise en place du jeu
	 * @return Retourne la taille de la pile
	 */
	public static int mise_en_place(){
		int taille;
		System.out.println("Jeu de nim");
		System.out.println("----------");
		System.out.println("Vous avez un tas de batons.");
		System.out.println("A chaque tour, vous (ou l'ordinateur) prenez 1, 2 ou 3 batons.");
		System.out.println("Celui qui enleve le dernier baton a gagne.");
		System.out.println("L'ordinateur commence, mais vous pouvez choisir le nombre initial de batons.");
		System.out.print("Combien de batons au debut (entre 10 et 25) ? ");
		taille = lit_entre_intervalle(10, 25);
		return taille;
	}
	
	/**
	 * Nombre de batons enlevés par l'ordinateur de façon aléatoire
	 * @param pile taille de la pile de batons
	 * @return le nombre de batons enlevés
	 */
	public static int jeu_ordinateur(int pile) {
		int nb_a_retirer;
		if (pile%4==0) {
			/* position perdante. On enleve entre 1 et 3 bâtons au hasard */
			nb_a_retirer=(int) (Math.random()*3)+1;
		} else {
			/* position gagnante */
			nb_a_retirer=pile%4;
		}
		return nb_a_retirer;
	}
	
	/**
	 * Nombre de batons enlevés par le joueur
	 * @param pile taille de la pile de batons
	 * @return le nombre de baton enlevés par le joueur
	 */
	public static int jeu_humain(int pile) {
		int nb_a_retirer;
		int mx_pions; /* on ne peut pas enlever plus de batons qu'il y en a :
        mx_pions va donc contenir le minimum entre 3 et le nombre de batons,
        et indique le nombre de pions maximum que peut enlever le joueur */
		mx_pions=3;
		if (mx_pions>pile) {
			mx_pions = pile;
		}
		System.out.print("A vous de jouer. Combien de baton(s) a enlever (de 1 à " 
				+ mx_pions + ") : ");

		/** lecture entre 1 et mx_pions **/
		nb_a_retirer = lit_entre_intervalle(1, mx_pions);
		
		return nb_a_retirer;
	}
	
	/**
	 * Affichage du joueur gagnant
	 * @param joueur si =1 l'ordinateur gagne sinon c'est le joueur
	 */
	public static void affiche_vainqueur(int joueur) {
		if (joueur==1) {
			/* c'est a l'ordinateur de jouer, donc c'est l'humain qui a enleve le dernier pion */
			System.out.println("Vous avez gagne. Bravo !");
		} else {
			System.out.println("L'ordinateur a gagne. A bientot pour la revanche.");
		}
	}
	
	/**
	 * lecture d'un nombre entre a et b : répète la demande tant que le nombre n'est
	 * pas trouvé
	 * @param a minimum de l'intervalle
	 * @param b maximum de l'intervalle
	 * @return la valeur lue
	 * @Precondition a<=b (sinon boucle infinie)
	 */
	public static int lit_entre_intervalle(int a, int b) {
		int nb;
		nb = IO.lireInt();
		while ((nb<a) || (nb>b)) {
			System.out.print("Mauvaise valeur. Reessayez : ");
			nb = IO.lireInt();
		}
		return nb;
	}
	
	
	/**
	 * fonction principale du jeu. Beaucoup trop longue, à vous de la
	 * couper en fonctions intermédiaires.
	 * @param args (non utilisé)
	 */
	public static void main(String[] args) {
		int joueur, pile;

		/** presentation du jeu => en fonction, doit retourner la taille du tas **/
		/** lecture entre 10 et 25 **/
		pile = mise_en_place();

		joueur = 1; /* numero du joueur dont c'est le tour : 1 = ordinateur, 2 = humain */
		
		while (pile>0) {
			int nb_a_retirer; /* nombre de pions a retirer de la pile, 
			     determine soit par l'ordinateur soit par le joueur */

			System.out.println("Il reste " + pile + " batons.");

			if (joueur==1) {
				/*** L'ordinateur joue. **/
				nb_a_retirer = jeu_ordinateur(pile);

				System.out.println("L'ordinateur enleve " + 
						nb_a_retirer + " baton(s).");

			} else {
				/*** Le joueur joue. **/
				
				nb_a_retirer = jeu_humain(pile);

				System.out.println("Vous enlevez " + nb_a_retirer + " baton(s).");

			}
			/* on enleve les pions de la pile */
			pile = pile-nb_a_retirer;
			/* on change le numero du joueur */
			if (joueur==1) {
				joueur=2;
			} else {
				joueur=1;
			}
		}

		/*** affichage de la fin, a mettre en fonction ***/
		System.out.println("Le tas est vide. ");
		affiche_vainqueur(joueur);

	}
     
}
