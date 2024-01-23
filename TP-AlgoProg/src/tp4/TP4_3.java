package tp4;

@SuppressWarnings("all")
public class TP4_3 {
	
	/* approximation de pi par la formule de Wallis : */
	/*   pi = 2 * (2/1) * (2/3) * (4/3) * (4/5) ...     */
	/* ecrire la fonction wallis prenant en parametre un entier
	     n et retournant la valeur approchee de pi avec n termes
	     (sans compter le 2*)
	    (par exemple pour n=4  : 2*(2/1)*(2/3)*(4/3)*(4/5)) */
	
	
	
	
	/*   approximation de pi par la formule de Brouncker :   */
	/*   pi = 4/(1+(1*1)/(2+(3*3)/(2+(5*5)/(2+...))))        */
	/*   ecrire la fonction brouckner prenant en parametre un entier
	      n et s'arretant au niveau de (2n-1)*(2n-1)         */
	/*   par exemple pour n=4, il faudrait calculer
	       4/(1+(1*1)/(2+(3*3)/(2+(5*5)/(2+(7*7)/2))))       */
	/* indice : partir de "la fin" : 
	      2 puis 2+(7*7)/2 puis 2+(5*5)/(2+(7*7)/2)
	      puis 2+(3*3)/(2+(5*5)/(2+(7*7)/2))
	      puis 1+(1*1)/(2+(3*3)/(2+(5*5)/(2+(7*7)/2)))
	      et on retourne 4/le resulat                       */
	
	
	

	/** TP 4 exo 3 , programme principal.
	 *     Vous devez tester les fonctions Wallis et Brouncker avec
	 *     n = 5, n=100, n=10000 et n=10000000 , en affichant l'ecart
	 *     entre le resultat de ces fonctions et la valeur approchee
	 *     de pi ci-dessous 
	 * @param args (non utilisé)
	 */
	public static void main(String[] args)
	{
	    double PI = Math.PI; // 3.14159265358979323846;
	
	    /* calculer wallis et brouncker pour n=5,
	         et afficher la difference entre ces resultats et PI ***/
	
	    /* meme chose pour n=100, 10000 et 10000000 **/
	
	}
	
}

