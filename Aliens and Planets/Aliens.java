import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;



public class Aliens extends JFrame
{
	public Aliens()
	{
		initGUI();
	}
	private void initGUI()
	{
		setTitle("Aliens");
		setSize(800,600);


		//timer = new Timer();
		//random = new Random();

		p = new JPanel();
		add(p);
		p.setBackground(Color.BLACK);
		p.setOpaque(true);
		setContentPane(p);	
		getContentPane().setLayout(null);	
		p.setLayout(null);
		//bgImage = new ImageIcon("C:/Javaprojekt/SwingListeners/UtforskarLyssnare/space.png");
        //bg = new JLabel(bgImage);
        //bg.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());

		planetFont = new Font("", Font.ITALIC, 30);

		// set planets
		

		planetA = new Planet("A", new ImageIcon("PlanetA.png"), JLabel.RIGHT, 0);
		planetA.setFont(planetFont);
		planetB = new Planet("B", new ImageIcon("PlanetB.gif"), JLabel.RIGHT, 1);
		planetB.setFont(planetFont);
		planetC = new Planet("C", new ImageIcon("PlanetC.png"), JLabel.RIGHT, 2);
		planetC.setFont(planetFont);

		planets = new Planet[NUMBER_OF_PLANETS];
		planets[0] = planetA;
		planets[1] = planetB;
		planets[2] = planetC;

		//	set ships

		ship1 = new Ship("1", new ImageIcon("Ship1.png"), JLabel.CENTER, planets);
		ship2 = new Ship("2", new ImageIcon("Ship2.gif"), JLabel.CENTER, planets);
		ship3 = new Ship("3", new ImageIcon("Ship3.png"), JLabel.CENTER, planets);
		ship4 = new Ship("4", new ImageIcon("Ship4.png"), JLabel.CENTER, planets);
		ship1.setVerticalTextPosition(JLabel.BOTTOM);
		ship2.setVerticalTextPosition(JLabel.BOTTOM);
		ship3.setVerticalTextPosition(JLabel.BOTTOM);
		ship4.setVerticalTextPosition(JLabel.BOTTOM);

		ships = new Ship[NUMBER_OF_SHIPS];
		ships[0] = ship1;
		ships[1] = ship2;
		ships[2] = ship3;
		ships[3] = ship4;


		planetA.setBounds(50, 50, 180, 128);
		planetB.setBounds(300, 50, 180, 128);
		planetC.setBounds(550, 50, 180, 128);
		ship1.setBounds(50, 300, 100, 64);
		ship2.setBounds(250, 300, 100, 64);
		ship3.setBounds(450, 300, 100, 64);
		ship4.setBounds(650, 300, 100, 64);

		
		totalNrOfLabels = NUMBER_OF_SHIPS * NUMBER_OF_PLANETS;
		

		p.add(planetA);
		p.add(planetB);
		p.add(planetC);
		p.add(ship1);
		p.add(ship2);		
		p.add(ship3);
		p.add(ship4);

		shipLabels = new JLabel[NUMBER_OF_SHIPS];
		for(int i = 0; i < NUMBER_OF_SHIPS; i++)
		{
			shipLabels[i] = new JLabel("Ship" + (i+1) + ":");
			shipLabels[i].setBounds(
				(i*150) + MAT_HORIZONTAL_TAB, 
				MAT_Y_DISTANCE, 
				MAT_SIZE, 
				MAT_SIZE);
			shipLabels[i].setForeground(Color.RED);
			p.add(shipLabels[i]);
		}

		ship1Materials = new JLabel[NUMBER_OF_PLANETS];
		for(int i = 0; i < NUMBER_OF_PLANETS; i++)
		{
			ship1Materials[i] = new JLabel(String.valueOf((char)(i + 65)));
			ship1Materials[i].setBounds(
				60 + MAT_HORIZONTAL_TAB + (i*MAT_DISTANCE), 
				MAT_Y_DISTANCE, 
				MAT_SIZE, 
				MAT_SIZE);
			ship1Materials[i].setForeground(Color.BLACK);
			p.add(ship1Materials[i]);
		}

		ship2Materials = new JLabel[NUMBER_OF_PLANETS];
		for(int i = 0; i < NUMBER_OF_PLANETS; i++)
		{
			ship2Materials[i] = new JLabel(String.valueOf((char)(i + 65)));
			ship2Materials[i].setBounds(
				210 + MAT_HORIZONTAL_TAB + (i*MAT_DISTANCE), 
				MAT_Y_DISTANCE, 
				MAT_SIZE, 
				MAT_SIZE);
			ship2Materials[i].setForeground(Color.BLACK);
			p.add(ship2Materials[i]);
		}

		ship3Materials = new JLabel[NUMBER_OF_PLANETS];
		for(int i = 0; i < NUMBER_OF_PLANETS; i++)
		{
			ship3Materials[i] = new JLabel(String.valueOf((char)(i + 65)));
			ship3Materials[i].setBounds(
				360 + MAT_HORIZONTAL_TAB + (i*MAT_DISTANCE), 
				MAT_Y_DISTANCE, 
				MAT_SIZE, 
				MAT_SIZE);
			ship3Materials[i].setForeground(Color.BLACK);
			p.add(ship3Materials[i]);
		}

		ship4Materials = new JLabel[NUMBER_OF_PLANETS];
		for(int i = 0; i < NUMBER_OF_PLANETS; i++)
		{
			ship4Materials[i] = new JLabel(String.valueOf((char)(i + 65)));
			ship4Materials[i].setBounds(
				510 + MAT_HORIZONTAL_TAB + (i*MAT_DISTANCE), 
				MAT_Y_DISTANCE, 
				MAT_SIZE, 
				MAT_SIZE);
			ship4Materials[i].setForeground(Color.BLACK);
			p.add(ship4Materials[i]);
		}

		// give materials to ships

		ships[0].setMaterialLabels(ship1Materials);
		ships[1].setMaterialLabels(ship2Materials);
		ships[2].setMaterialLabels(ship3Materials);
		ships[3].setMaterialLabels(ship4Materials);

		// set font color of ships
		for(int i = 0; i < NUMBER_OF_SHIPS; i++)
		{
			ships[i].setForeground(Color.WHITE);
		}
		//set font color of planets
		for(int i = 0; i < NUMBER_OF_PLANETS; i++)
		{
			planets[i].setForeground(Color.WHITE);
		}
		
		// Start ship threads
		for(int slot = 0; slot<NUMBER_OF_SHIPS; slot++)
		{
			ships[slot].startThread();
		}

		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		//set space location for ships
		for(int slot = 0; slot<NUMBER_OF_SHIPS; slot++)
		{
			ships[slot].setSpaceLocation();
		}
		// Show coordinates
		//System.println
	}
	//public void run()
	//{

	//}
	public static void main(String[] args)
	{
		new Aliens();
	}
	// Constants
	private final int FONT_SIZE = 30;
	private final int NUMBER_OF_SHIPS = 4;
	private final int NUMBER_OF_PLANETS = 3;
	private final int MAT_DISTANCE = 30;
	private final int MAT_Y_DISTANCE = 500;
	private final int MAT_SIZE = 50;
	private final int MAT_HORIZONTAL_TAB = 100;

	//	fields
	private JPanel p;

	private Planet planetA, planetB, planetC; 
	private Ship ship1, ship2, ship3, ship4, bg;
	private Ship[] ships;
	private Planet[] planets;
	private Font planetFont;
	private int totalNrOfLabels;
	private JLabel[] shipLabels;
	private JLabel[] materialLabels;
	private JLabel[] ship1Materials;
	private JLabel[] ship2Materials;
	private JLabel[] ship3Materials;
	private JLabel[] ship4Materials;
}