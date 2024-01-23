package utilGraphics;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public abstract class Util_TP6_1 extends TPGUISwing {
	/**** interface déjà écrite ****/
	protected static int cnt=0;
	protected static boolean jeuencours;
	protected static String motcherche;
	protected static char[] motdevine;
	protected static char[] alphabet = new char[26];
	protected static GraphPanel.Text t_motdevine, t_alphabet;
    protected static void dessine_pendu(int etape) {
        switch (etape) {
        case 0 : {
                    graphDrawLine(450,400,550,400);
                    break;
                 }
        case 1 : {
                    graphDrawLine(500,50,500,400);
                    break;
                 }
        case 2 : {
                    graphDrawLine(500,50,650,50);
                    graphDrawLine(500,100,550,50);
                    break;
                 }
        case 3 : {
                    graphDrawLine(640,50,640,130);
                    break;
                 }
        case 4 : {
                    graphFillCircleRGB(640,145,15,255,0,0);
                    break;
                 }
        case 5 : {
                    graphDrawLine(640,160,640,230,255,0,0);
                    graphDrawLine(640,180,590,130,255,0,0);
                    graphDrawLine(640,180,690,130,255,0,0);
                    break;
                 }
        case 6 : {
                    graphDrawLine(640,230,590,280,255,0,0);
                    graphDrawLine(640,230,690,280,255,0,0);
                 }
        }
    }
    protected static final Random randgen = new Random();
    protected static String choisit_mot() {
		FileReader fichier;
		try {
			fichier = new FileReader("data/TP6_1/listemots.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture du fichier listemots.txt.");
			return "ERREUR";
		}
		Scanner lecture = new Scanner(fichier);
		int nbmots = lecture.nextInt();
        int n = randgen.nextInt(nbmots);
        for (int i=0;i<=n-1;i=i+1) {
        	lecture.next();
        }
        String ret = lecture.next();
        lecture.close();
        return ret;
    }
	public static void initialise() {
		for (int i=0;i<alphabet.length;i=i+1) {
			alphabet[i]=' ';
		}
		motcherche=choisit_mot();
		motdevine = new char[2*motcherche.length()];
		for (int i=0;i<motdevine.length;i=i+2) {
			motdevine[i]='_';
			motdevine[i+1]=' ';
		}
		cnt=0;
		clearGraphPanel();
		displayText("Mot à deviner", 50, 70);
		t_motdevine = displayText(String.copyValueOf(motdevine),50,120, Color.RED,30);
		displayText("Lettres utilisées", 50,220);
		t_alphabet = displayText(String.copyValueOf(alphabet),50,250, Color.GREEN,25);
		jeuencours=true;
		graphOut.println("Résolvez le puzzle...");
		focusFrame();
	}

	
}
