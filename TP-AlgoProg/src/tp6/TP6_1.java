package tp6;

import utilGraphics.Util_TP6_1;

public class TP6_1 extends Util_TP6_1 {
	
	/**
	 *  retourne vrai si le mot n'a plus le caractère '_' 
	 *  @param motdevine Le mot
	 *  @return vrai si '_' n'apparait pas dans motdevine, faux sinon
	 *  @Precondition motdevine est defini
	 */
	public static boolean est_termine(char[] motdevine) {
		return false; /* a changer */
	}

    /** retourne vrai si la lettre apparait dans le tableau de caractères
     * (lettre entre 'A' et 'Z', le tableau est complété par des espaces)
     *  et faux sinon 
     *  @param alphabet un tableau contenant d'abord des lettres entre A et Z, puis
     *  des espaces 
     *  @param lettre la lettre cherchée (entre 'A' et 'Z')
     *  @return vrai si la lettre apparait, faux sinon
     */
    public static boolean apparait(char[] alphabet, char lettre) {
		return false; /* a changer */
    }

    /**
     * "ajoute" une lettre (en remplacement d'un espace) dans un tableau de caractères
     * @param alphabet le tableau de caractères
     * @param lettre la lettre
     * @Precondition alphabet doit avoir au moins un espace
     */
    public static void ajoute_lettre(char[] alphabet, char lettre) {

    }

    
    /**
     * recherche une lettre (lettre) dans une chaine (motfini)
     * chaque fois que la lettre est trouve, on place à deux fois l'indice dans
     * motdevine la lettre en question. On retourne le nombre de placements fait
     * (0 si la lettre n'apparait pas)
     * @param motfini le mot final (à deviner)
     * @param motdevine le mot actuellement en construction (avec les 
     *                  lettres de motfini ou des '_' et un espace entre chaque lettre)
     * @param lettre la lettre recherchée
     * @return le nombre de modifications faites sur motdevine
     * @Precondition motdevine a deux fois la longueur de motfini
     */
    public static int recherche_lettre(String motfini, char[] motdevine, char lettre) {
    	return 0; /* a changer */
    }

	/* NE PAS MODIFIER SOUS CETTE LIGNE */
    
    /**
     * fonction principale, TP6 exo 1 (le pendu)
     * @param args (non utilisé)
     */
	public static void main(String[] args) {
		TP6_1 tp6_1 = new TP6_1();
		progname="TP6 exo 1";
		tp6_1.start();
	}
	/**
	 * Initialisation de l'interface graphique
	 * (note : utilise Util_TP6_1)
	 */
	public void initUI() {
        initialise();
		addButton("Recommencer",TP6_1::initialise);
		addButton("Quitter", Util_TP6_1::quit);
		addKeyTyped((String s) -> {
			System.out.println("Lu : "+s);
			char c = s.charAt(0);
			if (!Character.isLetter(c)) return null;
			if (!jeuencours) return null;
			c = Character.toUpperCase(c);
			if (apparait(alphabet,c)) return null;
			ajoute_lettre(alphabet, c);
			updateText(t_alphabet,String.valueOf(alphabet));
			int nbchange = recherche_lettre(motcherche,motdevine,c);
			if (nbchange==0) {
				dessine_pendu(cnt);
				cnt=cnt+1;
				if (cnt==7) {
					graphOut.println("Vous avez perdu !");
					graphOut.println("Le mot à deviner était "+motcherche);
					jeuencours=false;
				} else {
					graphOut.println(c + " : lettre absente.");
				}
			} else {
				updateText(t_motdevine,String.valueOf(motdevine));
				graphOut.println(c + " : lettre trouvée "+ nbchange + " fois.");
				if (est_termine(motdevine)) {
					graphOut.println("Vous avez gagné ! Bravo !");
					jeuencours=false;
				}
			}
			return null;
		});
	}
}
