package tp1;

import util.IO;

public class TP1_2 {

	/*** QUESTION 1 
	 ***  Cet extrait de code demande le nom et le prenom de l'utilisateur, 
	 ***  puis affiche les deux l'un apr�s l'autre.
	 ***  Mais il ne fonctionne pas. Corrigez les erreurs. **/
	public static void question1() {
	    String nom, prenom;

	    System.out.println("Entrez votre nom : ");
	    nom = IO.lireLigne();
	    System.out.println("Entrez votre prenom : ");
	    prenom = IO.lireLigne();
	    System.out.println("Bonjour, " + nom + ", "+ prenom);
	}
	
	/*** QUESTION 2
	 *** Ce programme demande le pr�nom et l'age de l'utilisateur et affiche les deux. 
	 *** Notez qu'il est tr�s mal format�. Pour vous aider, vous pouvez utiliser 
	 *** "Correct identation" (Ctrl-I) sur le bloc s�lectionn�, puis corrigez les 
	 *** erreurs */
	 public static void question2() {
		 String nom;
		 Integer age;
		 System.out.println("Entrez votre nom puis votre age : ");
		 nom = IO.lireLigne(); age = IO.lireInt();
		 System.out.println("Bonjour, " + nom + ".\nVous avez " + age + " ans.");
	}
	
	/*** QUESTION 3 
	 *** Ce programme calcule (a peu pr�s) l'age de l'utilisateur a partir de l'annee   
	 *** de naissance et de l'ann�e en cours. Le code est encore mal format�, 
	 *** reformatez-le.
	 *** Les variables sont tres mal nommees, vous devez les renommer. 
	 *** Corrigez les erreurs */

	public static void question3() {
	    Integer naissance, annee;
	    System.out.print("Quelle est votre ann�e de naissance : ");
	    naissance = IO.lireInt();
	    System.out.print("Quelle est l'annee en cours : ");
	    annee = IO.lireInt();
	    int age = annee - naissance;
	    System.out.print("Vous avez (a peu pres) "+ age + " ans.");
	}
	
	/*** QUESTION 4 
	 *** Ce code lit une dur�e en secondes, et �crit cette m�me dur�e 
	 *** en heures, minutes et secondes. Attention, le probl�me ne se r�sume
	 *** pas � compiler le code, il faut qu'il marche sur plusieurs exemples */

	public static void question4() {
		Integer duree, heures, minutes, secondes;
	    System.out.println("Entrez une duree en secondes : ");
	    duree = IO.lireInt();
	    heures = duree/3600;
	    minutes = duree%3600/60;
	    secondes = duree/3600;
	    System.out.print(duree);
	    System.out.print(" secondes representent ");
	    System.out.println(heures+ " heures, "+ minutes + " minutes, et " + secondes + "secondes.\n");
	}
	
	/*** QUESTION 5 
	 *** Ce code demande deux heures (sous une forme de 6 chiffres, hhmmss) 
	 *** et affiche la diff�rence entre les deux en secondes. 
	 *** Le calcul est correct, mais le code est difficile � lire, en particulier
	 *** parce que les variables n'ont pas des noms clairs et servent parfois 
	 *** � plusieurs choses � la fois. Modifiez le nom des variables, cr�ez 
	 *** �ventuellement de nouvelles variables et ajoutez des commentaires pour
	 *** expliquer ce que fait le code */
	
	public static void question5() {
	    int hdebut, hfin,c,d,e,diffsecondes;

	    System.out.print ("Entrez l'heure de debut (au format hhmmss) : ");
	    hdebut = IO.lireInt();
	    System.out.print ("Entrez l'heure de fin (au format hhmmss) : ");
	    hfin = IO.lireInt();
	    c = hdebut%100;  // c repr�sente les secondes de l'heure de d�but
	    hdebut = hdebut/100;  // hdebut repr�sente les heures et minutes de l'heure de debut
	    d = hfin/100;  // d repr�sente les heures et les minutes de l'heure de fin
	    hfin = hfin%100;  // hfin repr�sente les secondes de l'heure de fin
	    e = hfin-c;    // e repr�sente la diff�rence en secondes entre l'heure de d�but et l'heure de fin
	    c = hdebut/100;  //c repr�sente les heures de l'heure de d�but
	    hdebut = hdebut%100;  //hdebut repr�sente les minutes de l'heure de d�but
	    diffsecondes = d/100;  //f repr�sente les heures de l'heure de fin
	    hfin = d%100;  //hfin respr�sente les minutes de l'heure de fin
	    hfin = hfin-hdebut;    //hfin repr�sente l'�cart entre les minutes des deux heures
	    hdebut = diffsecondes-c;    //hdebut repr�sente l'�cart d'heure entre les deux heures
	    diffsecondes = hfin+hdebut*60; //f repr�sente l'�cart d'heure entre les deux heures en minutes
	    diffsecondes = diffsecondes*60+e; //f repr�sente le temps entre les deux heures en secondes
	    System.out.println("Entre les deux heures se sont ecoulees " + diffsecondes + " secondes.");
	}

	/**
	 * Programme principal : ex�cute une des fonctions �crites
	 * @param args (non utilis�)
	 */
	public static void main(String[] args) {
		// D�commenter la question ex�cut�e
		//question1();
		//question2();
		//question3();
		//question4();
		// question5();
	}

}
