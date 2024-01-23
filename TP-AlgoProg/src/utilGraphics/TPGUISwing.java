package utilGraphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;


public abstract class TPGUISwing  {


	private static JPanel fieldPanel; 
	private static GridBagLayout gb;
	private static GridBagConstraints gbc;
	private static JPanel buttonPanel; 
	private static JTextPane textPanel;
	private static JScrollPane stextPanel; 
	private static JPanel globalgrid; 
	private static int nbchamps=0;
	private static int nbbuttons=0;
    private static final Font fontPlain = new Font(Font.SERIF,Font.PLAIN,18);
    private static final Font fontItalic = new Font(Font.SERIF,Font.ITALIC,18); 

    @SuppressWarnings("serial")
	protected static class GraphPanel extends JPanel {
    	private ArrayList<MouseListener> mev_list = new ArrayList<MouseListener>();
    	private ArrayList<MouseMotionListener> mmev_list = new ArrayList<MouseMotionListener>();
    	private boolean isactive=true;
    	@Override
    	public void addMouseListener(MouseListener l) {
    		if (isactive) super.addMouseListener(l);
    		mev_list.add(l);
    	}
    	@Override
    	public void addMouseMotionListener(MouseMotionListener l) {
    		if (isactive) super.addMouseMotionListener(l);
    		mmev_list.add(l);
    	}
    	private interface Drawable {
    		public void draw(Graphics g);
    		public boolean isVisible();
    	}
    	protected static class PlainCircle implements Drawable {
    		Color c;
    		double x,y,r;
			public PlainCircle(Color c,double x, double y, double r) {
				this.c = c;
				this.x = x;
				this.y = y;
				this.r = r;
			}
			public void draw(Graphics g) {
				g.setColor(c);
				g.fillOval((int) (x-r),(int) (y-r),(int) (2*r),(int) (2*r));
			}
			public boolean isVisible() { 
				return true;
			}
    	}
    	public static class PlainRect implements Drawable {
    		Color c;
    		int x,y,w,h;
    		boolean vis = true;
			public PlainRect(Color c,int x, int y, int w, int h) {
				this.c = c;
				this.x = x;
				this.y = y;
				this.w = w;
				this.h = h;
			}
			public PlainRect(Color c,int w, int h) {
				this.c = c;
				this.w = w;
				this.h = h;
				this.vis = false;
			}
			public void updateY(int y) {
				this.y=y;
			}
			public void updateX(int x) {
				this.x=x;
			}
			public void updateHeight(int h) {
				this.h=h;
			}
			public void updateC(Color c) {
				this.c=c;
			}
			public void update(int x, int y) {
				this.x = x;
				this.y = y;
				this.vis = true;
			}
			public void draw(Graphics g) {
				if (!this.vis) return;
				g.setColor(c);
				g.fillRect(x,y,w,h);
			}
			public boolean isVisible() { 
				return vis;
			}
			public void setVisible(boolean b) { 
				vis=b;
			}
    	}
    	protected static class Line implements Drawable {
    		Color c;
    		double x1,y1,x2,y2;
			public Line(Color c,double x1,double y1,double x2, double y2) {
				this.c = c;
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
			}
			public void draw(Graphics g) {
				g.setColor(c);
				g.drawLine((int) x1,(int) y1,(int) x2,(int) y2);
			}
			public boolean isVisible() { 
				return true;
			}
    	}
    	protected static class Text implements Drawable {
    		Color c;
    		Font f;
    		String s;
    		double x,y;
    		boolean vis = true;
    		public Text(String s, Color c,Font f, double x, double y) {
				this.c = c;
				this.f = f;
				this.s = s;
				this.x = x;
				this.y = y;
			}
    		public Text(String s, Color c,Font f) {
				this.c = c;
				this.f = f;
				this.s = s;
				this.vis = false;
			}
    		public void updateString(String s) {
    			this.s=s;
    		}
			public void draw(Graphics g) {
				g.setColor(c);
				g.setFont(f);
				g.drawString(s,(int) x,(int) y);
			}
			public boolean isVisible() { 
				return true;
			}
    	}
    	public static class ImageView implements Drawable {
    		private Image iv;
    		private int x,y;
    		private boolean vis = false;
    		private double opacity = 1.0;
    		public ImageView(Image iv) {
    			this.iv = iv;
    			this.x = this.y = 0;
    		}
    		public void setLayout(int x,int y) {
    			this.x = x;
    			this.y = y;
    			this.vis = true;
    		}
    		public Image getImage() {
    			return iv;
    		}
     		public int getLayoutX() {
    			return x;
    		}
    		public int getLayoutY() {
    			return y;
    		}
			public void draw(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				if (opacity!=1.0) {
					g2d.setComposite(
							AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
					g2d.drawImage(iv,(int) x,(int) y,null);
					g2d.setComposite(AlphaComposite.SrcOver);
				} else {
				    g.drawImage(iv,(int) x,(int) y,null);
				}
			}    		
			public boolean isVisible() { 
				return vis;
			}
			public void setVisible(boolean b) { 
				this.vis=b;
			}
			public void setOpacity(double d) { 
				this.opacity=d;
			}
    	}
		ArrayList<Drawable> s;
    	public GraphPanel() {
    		super();
    		s = new ArrayList<Drawable>();
    	}
		@Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		Graphics2D g2d = (Graphics2D) g;
    		if (!isactive) g2d.setComposite(
					AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.7));
    		for (Drawable ds : s) {
    			if (ds.isVisible()) ds.draw(g);
    		}
    		g2d.setComposite(AlphaComposite.SrcOver);
    	}
		public void addDrawable(Drawable d) {
			s.add(d);
			if (d.isVisible()) this.repaint();
		}
		public void addDrawable(Drawable d, boolean b) {
			s.add(d);
			if (b) this.repaint();
		}
		public void clearAll() {
			s.clear();
			this.repaint();
		}
		@Override
		public void setEnabled(boolean b) {
			super.setEnabled(b);
			if (this.isactive==b) return;
			this.isactive=b;
			if (b) {
				for (MouseListener m : this.mev_list)
					super.addMouseListener(m);
				for (MouseMotionListener m : this.mmev_list)
					super.addMouseMotionListener(m);
			} else {
				for (MouseListener m : this.mev_list)
					super.removeMouseListener(m);
				for (MouseMotionListener m : this.mmev_list)
					super.removeMouseMotionListener(m);
			}
			this.repaint();
		}
    }
	protected static GraphPanel graphPanel;
    
	private enum FontPosture {
		REGULAR, ITALIC
	}
	
	/**
	 * Affichage d'une chaine dans textPanel
	 * @param s : la chaine
	 * @param c : la couleur
	 * @param f : la police
	 */
	private static void printText(String s, Color c, FontPosture f) {
		SimpleAttributeSet set = new SimpleAttributeSet();
		if (f==FontPosture.ITALIC) StyleConstants.setItalic(set, true);
		StyleConstants.setForeground(set,c);
		Document doc = textPanel.getStyledDocument();
		try {
			doc.insertString(doc.getLength(), s, set);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}


	/**
	 * text output : on définit un OutputStream qui permettra d'obtenir un PrintStream
	 */
	private static OutputStream outT = new OutputStream() {
		@Override
		public void write(int b) throws IOException {
			String s = String.valueOf((char) b);
			printText(s,Color.BLUE,FontPosture.REGULAR); 
		}
		@Override
		public void write(byte[] b, int off, int len)
				throws IOException {
			String s = new String(b,off,len);
			printText(s,Color.BLUE,FontPosture.REGULAR); 
		}
	};
	
	/**
	 * text output : we can use graphOut.println, graphOut.print, ...
	 */	
	protected static PrintStream graphOut = 
			new PrintStream(outT);

	/** 
	 * <b>Fonction graphique pour les TP</b><br>
	 * dessine un disque rempli 
	 * @param x abscisse du centre
	 * @param y ordonnée du centre
	 * @param r rayon
	 * @param red couleur rouge (0..255)
	 * @param green couleur verte (0..255) 
	 * @param blue couleur bleur (0..255)
	 */
	protected static void graphFillCircleRGB(double x, double y, double r,
			int red, int green, int blue) {
		Color c = new Color(red,green,blue);
		graphPanel.addDrawable(new GraphPanel.PlainCircle(c, x, y, r));
	}
	/** 
	 * <b>Fonction graphique pour les TP</b><br>
	 * dessine un disque rempli (noir)
	 * @param x abscisse du centre
	 * @param y ordonnée du centre
	 * @param r rayon
	 */
	protected static void graphFillCircle	(double x, double y, double r) {
		graphPanel.addDrawable(new GraphPanel.PlainCircle(Color.BLACK, x, y, r));
	}
	/** 
	 * <b>Fonction graphique pour les TP</b><br>
	 * dessine un rectangle rempli
	 * @param x abscisse bord gauche
	 * @param y ordonnée bord jaut
	 * @param w largeur
	 * @param h hauteur
	 * @param red couleur rouge (0..255)
	 * @param green couleur verte (0..255) 
	 * @param blue couleur bleur (0..255)
	 */
	protected static void graphFillRectangle (int x, int y, int w, int h,
			int red, int green, int blue) {
		Color c = new Color(red,green,blue);
		graphPanel.addDrawable(new GraphPanel.PlainRect(c, x, y, w, h));
	}
	/**
	 * <b>Fonction graphique pour les TP</b><br>
	 * Dessine une ligne (noire) de <b>(x1,y1)</b> à <b>(x2,y2)</b>
	 * @param x1 abscisse du premier point
	 * @param y1 ordonnée du premier point
	 * @param x2 abscisse du second point
	 * @param y2 ordonnée du second point
	 */
	protected static void graphDrawLine(double x1, double y1, double x2, double y2) {
		graphPanel.addDrawable(new GraphPanel.Line(Color.BLACK, x1, y1, x2, y2));
	}
	/**
	 * <b>Fonction graphique pour les TP</b><br>
	 * Dessine une ligne (colorée) de <b>(x1,y1)</b> à <b>(x2,y2)</b>
	 * @param x1 abscisse du premier point
	 * @param y1 ordonnée du premier point
	 * @param x2 abscisse du second point
	 * @param y2 ordonnée du second point
	 * @param r rouge (0..255)
	 * @param g vert (0..255)
	 * @param b bleu (0..255)
	 */
	protected static void graphDrawLine(double x1, double y1, double x2, double y2,
			int r, int g, int b) {
		graphPanel.addDrawable(new GraphPanel.Line(new Color(r,g,b), x1, y1, x2, y2));
	}
	/**
	 * <b>Fonction graphique pour les TP</b><br>
	 * Ecrit du texte (noir) sur le paneau de dessin
	 * @param s chaine à représenter
	 * @param x abscisse gauche
	 * @param y ordonnée haut
	 */
	protected static void displayText(String s, double x, double y) {
		graphPanel.addDrawable(
				new GraphPanel.Text(s,Color.BLACK, 
						new Font(Font.MONOSPACED, Font.PLAIN, 18),x,y));
	}
	
	/**
	 * <b>Fonction graphique pour les TP</b><br>
	 * Ecrit du texte (couleur) sur le paneau de dessin
	 * @param s chaine à représenter (type GraphPanel.t ?)
	 * @param x abscisse gauche
	 * @param y ordonnée haut
	 * @param c la couleur
	 * @return le GraphPanel.Text créé
	 */
	protected static GraphPanel.Text displayText(String t, double x, double y, Color c) {
		GraphPanel.Text gt = new GraphPanel.Text(t,c, 
				new Font(Font.MONOSPACED, Font.PLAIN, 18),x,y);
		graphPanel.addDrawable(gt);
		return gt;
	}
	/**
	 * <b>Fonction graphique pour les TP</b><br>
	 * Ecrit du texte (couleur) sur le paneau de dessin
	 * @param t chaine a représenter (type String)
	 * @param x abscisse gauche
	 * @param y ordonnée haut
	 * @param c couleur
	 * @param size taille
	 * @return le GraphPanel.Text créé
	 */
	protected static GraphPanel.Text displayText(String t, int x, int y, Color c, int size) {
		GraphPanel.Text gt = new GraphPanel.Text(t,c, 
				new Font(Font.MONOSPACED, Font.PLAIN, size),x,y);
		graphPanel.addDrawable(gt);
		return gt;
	}
	/**
	 * met à jour un GraphPanel.Text et réaffiche le panneau graphique
	 * @param t le GraphPanel.Text
	 * @param s la nouvelle chaine
	 */
	protected static void updateText(GraphPanel.Text t, String s) {
		t.updateString(s);
		graphPanel.repaint();
	}
	/** 
	 * <b>Fonction graphique pour les TP</b><br>
	 * Efface le paneau de dessin (graphique).
	 */
	public static void clearGraphPanel() {
		graphPanel.clearAll();
	}
	
	protected static void addButton(String nom, Runnable r) {
		JButton tb = new JButton(nom);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx=nbbuttons%2;
		gbc.gridy=nbbuttons/2; 
		gbc.weightx=50;
		gb.setConstraints(tb,gbc);
		tb.setFont(fontPlain);
		buttonPanel.add(tb/*,nbbuttons%2,nbbuttons/2*/);
		tb.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				r.run();
			}
		});
		nbbuttons=nbbuttons+1;
	}
	
	private static HashMap<String,JTextField> intFieldMap = 
			new   HashMap<String,JTextField>();
	private static
	HashMap<String,JTextField> doubleFieldMap = 
			new   HashMap<String,JTextField>();
	private static HashMap<String,JTextField> stringFieldMap = 
			new   HashMap<String,JTextField>();

	private static JTextField addField(String nom,String base) {
		JTextField tf = new JTextField(base);
		JLabel lb = new JLabel(nom);
		lb.setFont(fontPlain);
		tf.setFont(fontItalic);
		lb.setForeground(Color.RED);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=nbchamps; 
		gbc.weightx=50;
		gb.setConstraints(tf,gbc);
		fieldPanel.add(tf/* ,1,nbchamps*/);
		gbc.gridx=1;
		gb.setConstraints(lb,gbc);
		fieldPanel.add(lb/* ,0,nbchamps*/);
		nbchamps=nbchamps+1;
		return tf;
	}


	protected static void addIntField(String nom, int def) {
		intFieldMap.put(nom,addField(nom,Integer.toString(def)));
	}
	protected static void addDoubleField(String nom, double def) {
		doubleFieldMap.put(nom,addField(nom,Double.toString(def)));
	}
	protected static void addStringField(String nom, String def) {
		stringFieldMap.put(nom,addField(nom,def));
	}
	protected static void addIntField(String nom, String pnom, int def) {
		intFieldMap.put(pnom,addField(nom,Integer.toString(def)));
	}
	protected static void addDoubleField(String nom, String pnom, double def) {
		doubleFieldMap.put(pnom,addField(nom,Double.toString(def)));
	}
	protected static void addStringField(String nom, String pnom, String def) {
		stringFieldMap.put(pnom,addField(nom,def));
	}
	protected static void addIntField(String nom) {
		addIntField(nom,0);
	}
	protected static void addDoubleField(String nom) {
		addDoubleField(nom,0.0);
	}
	protected static void addStringField(String nom) {
		addStringField(nom,"");
	}
	protected static HashMap<ButtonModel,Integer> togglesInt = 
			new HashMap<ButtonModel,Integer>();
	protected static int getSelectedButton(ButtonGroup tg) {
		ButtonModel t = tg.getSelection();
		Integer i = togglesInt.get(t);
		return (i==null ? -1 : i);
	}
	protected static ButtonGroup addRadioButtons(String nom, String... choices) {
		JLabel lb = new JLabel(nom);
		lb.setFont(fontPlain);
		lb.setForeground(Color.RED);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx=0;
		gbc.gridx=0;
		gbc.gridy=nbchamps;
		gb.setConstraints(lb,gbc);
		fieldPanel.add(lb/*,0,nbchamps*/);
	    ButtonGroup group = new ButtonGroup();
	    boolean deuxcolonnes = (choices.length>=4);
	    if (deuxcolonnes) nbchamps=nbchamps+1;
		for (int i=0; i<choices.length; i=i+1)  {
			JRadioButton rb = new JRadioButton(choices[i]);
			rb.setFont(new Font(Font.SERIF, Font.ITALIC, 
					deuxcolonnes ? 16 : 18));
			group.add(rb);
			togglesInt.put(rb.getModel(), i);
			if (i==0) rb.setSelected(true);
			gbc.gridx=deuxcolonnes ? i%2 : 1;
			gbc.gridy=nbchamps;
			gb.setConstraints(rb,gbc);
		    fieldPanel.add(rb/*,deuxcolonnes ? (i%2) : 1,nbchamps*/);
		    nbchamps=nbchamps+(deuxcolonnes ? (i%2) : 1);
		}
		return group;
	}

	/**
	 * <b>Fonction graphique pour les TP</b><br>
	 * Lit le contenu du champ associé à une étiquette et retourne sa valeur entière 
	 * @param nom Le nom de l'étiquette dans l'interface graphique
	 * @return L'entier lu (0 si le contenu n'est pas un entier)
	 */
	protected static int getIntF(String nom) {
		try {
		  return Integer.parseInt(intFieldMap.get(nom).getText());
		} catch (Exception e) {
			System.err.println("Erreur dans getIntF (retour 0) : " + e.toString());
			return 0;
		}
	}
	protected static double getDoubleF(String nom) {
		return Double.parseDouble(doubleFieldMap.get(nom).getText());
	}
	protected static String getStringF(String nom) {
		return stringFieldMap.get(nom).getText();
	}

	protected void addKeyTyped(Function<String,Void> func) {
		KeyListener tkeyHandler =
				new KeyListener() {
			public void keyTyped(KeyEvent event) {
				func.apply(String.valueOf(event.getKeyChar()));
			};
			public void keyReleased(KeyEvent event) {
			};
			public void keyPressed(KeyEvent event) {
			};
		};
		frame.addKeyListener(tkeyHandler);	
		frame.setFocusable(true);
	}
	protected static void focusFrame() {
	//	frame.setFocusable(true);
		frame.requestFocus();
	}
	protected void addMouseClick
			(BiFunction<Integer,Integer,Void> func) {
		MouseListener cmouseHandler =
				new MouseListener () {
			@Override
			public void mouseClicked(MouseEvent e) {
//				func.apply(e.getX(), e.getY());
			}
			@Override
			public void mousePressed(MouseEvent e) {
				func.apply(e.getX(), e.getY());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			};
  		};
   		graphPanel.addMouseListener(cmouseHandler);	
	}
	protected void addMouseMoved
	(BiFunction<Integer,Integer,Void> func) {
		MouseMotionListener mmouseHandler =
				new MouseMotionListener () {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				func.apply(e.getX(),e.getY());	
			};	
		};
		graphPanel.addMouseMotionListener(mmouseHandler);	
	}
	
	
	// images
	protected static GraphPanel.ImageView litImage(String nom)  { 
		Image image;
		try {
			image = ImageIO.read(new FileInputStream(nom));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		GraphPanel.ImageView iv = new GraphPanel.ImageView(image);
		graphPanel.addDrawable(iv);
		/* iv.setImage(im);
		iv.setLayoutX(0-iv.getLayoutBounds().getMinX());
		iv.setLayoutY(0-iv.getLayoutBounds().getMinY());
		graphPanel.getChildren().add(iv);
		iv.setVisible(false); */
		return iv;
	}
	protected static GraphPanel.ImageView[][] 
				litImages(String  nom, int nb_tab, int[] nb_images) {
		Image image;
		try {
			image = ImageIO.read(new FileInputStream(nom));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		GraphPanel.ImageView[][] res = new GraphPanel.ImageView[nb_tab][];
		for (int i=0;i<nb_tab;i=i+1) {
			res[i] = new GraphPanel.ImageView[nb_images[i]];
			for (int j=0;j<nb_images[i];j=j+1) {
				res[i][j] = new GraphPanel.ImageView(image);
				res[i][j].setLayout(75+180*i,320-j*30);
				graphPanel.addDrawable(res[i][j],false);
			}
		}
		return res;
	}
    protected static void montreImage(GraphPanel.ImageView iv, int px, int py) {
    	iv.setLayout(px,py);
    	graphPanel.repaint();
    }
    /*
    protected static Rectangle creeRectangle(double w, double h) {
    	Rectangle rect =  new Rectangle(w,h);
    	rect.setVisible(false);
    	graphPanel.getChildren().add(rect);
    	return rect;
    }
    protected static Rectangle creeRectangle(int w, int h, int r, int g, int b) {
    	Color c = Color.color(r/255.0,g/255.0,b/255.0);
    	Rectangle rect = new Rectangle(w,h,c);
    	rect.setVisible(false);
    	graphPanel.getChildren().add(rect);
    	return rect;
    }
    protected static void placeRectangle(Rectangle rect, int px, int py) {
    	rect.setX(px);
    	rect.setY(py);
    	rect.setVisible(true);
    }
    */
    protected static void setActiveFieldPanel(boolean act) {
    	fieldPanel.setEnabled(act);
    	for (Component c : fieldPanel.getComponents()) {
    		c.setEnabled(act);
    	}
    }
    protected static void setActiveGraphPanel(boolean act) {
    	graphPanel.setEnabled(act);
   }
    protected static void updatePanel() {
    	graphPanel.repaint();
    }
    protected static void setActiveButtonPanel(boolean act) {
    	buttonPanel.setEnabled(act);
    	for (Component c : buttonPanel.getComponents()) {
    		c.setEnabled(act);
    	}
    }
	protected static String progname;

	protected abstract void initUI();
	
	private static JFrame frame;
	public static void quit() { 
		frame.dispose();
	}
	
	public void start()  {
		/* primaryStage.setTitle(progname);  */ // TODO : specific name
        frame = new JFrame(progname);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		graphPanel = new GraphPanel();
		graphPanel.setPreferredSize(new Dimension(1000, 500));
		graphPanel.setBackground(Color.WHITE);
		textPanel= new JTextPane();
		textPanel.setPreferredSize(new Dimension(400, 180));
		stextPanel = new JScrollPane(textPanel);
		stextPanel.setPreferredSize(new Dimension(400,200));
		((DefaultCaret) textPanel.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		textPanel.setEditable(false);
		fieldPanel = new JPanel();
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		fieldPanel.setLayout(gb);
		fieldPanel.setPreferredSize(new Dimension(450, 200));
		gbc.insets = new Insets(0,5,0,5);
/*		fieldPanel.setHgap(10);
		fieldPanel.setVgap(5); */
/*		HBox.setMargin(fieldPanel, new Insets(0,4,0,4));
*/		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(250, 200));
		buttonPanel.setLayout(gb);
		JPanel hbpanel=new JPanel();

		hbpanel.setLayout(new BoxLayout(hbpanel,BoxLayout.X_AXIS));
		hbpanel.add(fieldPanel);
		hbpanel.add(buttonPanel);
		hbpanel.add(stextPanel);

		globalgrid = new JPanel();
		globalgrid.setLayout(new BoxLayout(globalgrid,BoxLayout.Y_AXIS));
		globalgrid.add(hbpanel);
		globalgrid.add(graphPanel);
		initUI();

		frame.setContentPane(globalgrid);
		frame.pack();
		frame.setVisible(true);
		
//		Scene scene = new Scene(globalgrid);
		//		scene.addEventHandler(KeyEvent.KEY_TYPED,tkeyHandler);
		//		graphPanel.addEventHandler(MouseEvent.MOUSE_CLICKED,cmouseHandler);

//		primaryStage.setScene(scene);
//		primaryStage.show();
	}
	

}
