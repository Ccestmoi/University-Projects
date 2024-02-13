package tp1;

import util.IO;

public class TP1_2 {

	/*** QUESTION 1 
	 ***  Cet extrait de code demande le nom et le prenom de l'utilisateur, 
	 ***  puis affiche les deux l'un après l'autre.
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
	 *** Ce programme demande le prénom et l'age de l'utilisateur et affiche les deux. 
	 *** Notez qu'il est très mal formaté. Pour vous aider, vous pouvez utiliser 
	 *** "Correct identation" (Ctrl-I) sur le bloc sélectionné, puis corrigez les 
	 *** erreurs */
	 public static void question2() {
		 String nom;
		 Integer age;
		 System.out.println("Entrez votre nom puis votre age : ");
		 nom = IO.lireLigne(); age = IO.lireInt();
		 System.out.println("Bonjour, " + nom + ".\nVous avez " + age + " ans.");
	}
	
	/*** QUESTION 3 
	 *** Ce programme calcule (a peu près) l'age de l'utilisateur a partir de l'annee   
	 *** de naissance et de l'année en cours. Le code est encore mal formaté, 
	 *** reformatez-le.
	 *** Les variables sont tres mal nommees, vous devez les renommer. 
	 *** Corrigez les erreurs */

	public static void question3() {
	    Integer naissance, annee;
	    System.out.print("Quelle est votre année de naissance : ");
	    naissance = IO.lireInt();
	    System.out.print("Quelle est l'annee en cours : ");
	    annee = IO.lireInt();
	    int age = annee - naissance;
	    System.out.print("Vous avez (a peu pres) "+ age + " ans.");
	}
	
	/*** QUESTION 4 
	 *** Ce code lit une durée en secondes, et écrit cette même durée 
	 *** en heures, minutes et secondes. Attention, le problème ne se résume
	 *** pas à compiler le code, il faut qu'il marche sur plusieurs exemples */

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
	 *** et affiche la différence entre les deux en secondes. 
	 *** Le calcul est correct, mais le code est difficile à lire, en particulier
	 *** parce que les variables n'ont pas des noms clairs et servent parfois 
	 *** à plusieurs choses à la fois. Modifiez le nom des variables, créez 
	 *** éventuellement de nouvelles variables et ajoutez des commentaires pour
	 *** expliquer ce que fait le code */
	
	public static void question5() {
	    int hdebut, hfin,c,d,e,diffsecondes;

	    System.out.print ("Entrez l'heure de debut (au format hhmmss) : ");
	    hdebut = IO.lireInt();
	    System.out.print ("Entrez l'heure de fin (au format hhmmss) : ");
	    hfin = IO.lireInt();
	    c = hdebut%100;  // c représente les secondes de l'heure de début
	    hdebut = hdebut/100;  // hdebut représente les heures et minutes de l'heure de debut
	    d = hfin/100;  // d représente les heures et les minutes de l'heure de fin
	    hfin = hfin%100;  // hfin représente les secondes de l'heure de fin
	    e = hfin-c;    // e représente la différence en secondes entre l'heure de début et l'heure de fin
	    c = hdebut/100;  //c représente les heures de l'heure de début
	    hdebut = hdebut%100;  //hdebut représente les minutes de l'heure de début
	    diffsecondes = d/100;  //f représente les heures de l'heure de fin
	    hfin = d%100;  //hfin resprésente les minutes de l'heure de fin
	    hfin = hfin-hdebut;    //hfin représente l'écart entre les minutes des deux heures
	    hdebut = diffsecondes-c;    //hdebut représente l'écart d'heure entre les deux heures
	    diffsecondes = hfin+hdebut*60; //f représente l'écart d'heure entre les deux heures en minutes
	    diffsecondes = diffsecondes*60+e; //f représente le temps entre les deux heures en secondes
	    System.out.println("Entre les deux heures se sont ecoulees " + diffsecondes + " secondes.");
	}

	/**
	 * Programme principal : exécute une des fonctions écrites
	 * @param args (non utilisé)
	 */
	public static void main(String[] args) {
		// Décommenter la question exécutée
		//question1();
		//question2();
		//question3();
		//question4();
		// question5();
	}

}
