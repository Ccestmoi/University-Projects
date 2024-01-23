package tp3;

import util.IO;

public class TP3_1 {
	
	/***** METTRE ICI LES FONCTIONS INTERMEDIAIRES ISSUES DU main *****
	
	/* */
	
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
		System.out.println("Jeu de nim");
		System.out.println("----------");
		System.out.println("Vous avez un tas de batons.");
		System.out.println("A chaque tour, vous (ou l'ordinateur) prenez 1, 2 ou 3 batons.");
		System.out.println("Celui qui enleve le dernier baton a gagne.");
		System.out.println("L'ordinateur commence, mais vous pouvez choisir le nombre initial de batons.");
		System.out.print("Combien de batons au debut (entre 10 et 25) ? ");
		/** lecture entre 10 et 25 **/
		pile = IO.lireInt();
		while ((pile<10) || (pile>25)) {
			System.out.print("Mauvaise valeur. Reessayez : ");
			pile = IO.lireInt();
		}

		joueur = 1; /* numero du joueur dont c'est le tour : 1 = ordinateur, 2 = humain */
		while (pile>0) {
			int nb_a_retirer; /* nombre de pions a retirer de la pile, 
			     determine soit par l'ordinateur soit par le joueur */

			System.out.println("Il reste " + pile + " batons.");

			if (joueur==1) {
				/*** L'ordinateur joue. **/
				if (pile%4==0) {
					/* position perdante. On enleve entre 1 et 3 bâtons au hasard */
					nb_a_retirer=(int) (Math.random()*3)+1;
				} else {
					/* position gagnante */
					nb_a_retirer=pile%4;
				}

				System.out.println("L'ordinateur enleve " + 
						nb_a_retirer + " baton(s).");

			} else {
				/*** Le joueur joue. **/
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
				nb_a_retirer = IO.lireInt();
				while ((nb_a_retirer<1) || (nb_a_retirer>mx_pions)) {
					System.out.print("Mauvaise valeur. Reessayez : ");
					nb_a_retirer = IO.lireInt();
				}

				System.out.println("Vous enlevez " + nb_a_retirer + "baton(s).");

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
		if (joueur==1) {
			/* c'est a l'ordinateur de jouer, donc c'est l'humain qui a enleve le dernier pion */
			System.out.println("Vous avez gagne. Bravo !");
		} else {
			System.out.println("L'ordinateur a gagne. A bientot pour la revanche.");
		}

	}
     
}
