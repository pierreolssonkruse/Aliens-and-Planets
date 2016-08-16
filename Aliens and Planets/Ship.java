import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.Random;
import java.awt.Color;

class Ship extends JLabel implements Runnable
{
	//	Constants

	private final int PAUS_TIME = 1500;
	private final int LEGEND_SIZE = 35;
    private final int LEGEND_FONT_SIZE = 20;

	// Field declarations

	private int spaceX, spaceY, antalPlaneter, targetPlanet, score;
	private Thread thread;
	private boolean forever, inventoryIsFull;
	private boolean[] resourceChecklist;
	private Random random;
	private Planet[] planets;
	private JLabel scoreBoard;
	private JLabel[] materialLabels;







	// Constructor

	public Ship(String string, ImageIcon icon, int position, Planet[] inputPlanets)
	{	
		// set looks
		setText(string);
		setIcon(icon);
		setHorizontalAlignment(position);

		// set home location
		spaceX = this.getX();
		spaceY = this.getY();
		forever = true;

		// create planets
		planets = inputPlanets;
		antalPlaneter = planets.length;
		targetPlanet = 0;

		random = new Random();

		// Create inventory
	 resourceChecklist = new boolean[antalPlaneter];

		// clear inventory
		for(int slot = 0; slot < antalPlaneter; slot++)
		{
		 resourceChecklist[slot] = false;
		}

		
		thread = new Thread(this);
	}

	// Run method

	public void run()
	{
		while(forever)
		{
			//	Kolla inventory, om full - töm
			inventoryIsFull = true;
			for(int i = antalPlaneter - 1; i > 0; i--)
			{
				if (resourceChecklist[i] == false)
				{
					targetPlanet = i;
					inventoryIsFull = false;
				}
			}
			if(inventoryIsFull)
				emptyResources();
				targetPlanet = random.nextInt(antalPlaneter);

			// Anropa planets synkmetod
			planets[targetPlanet].explorePlanet(this);	
		}
	}
	// getters

	

	public int getSpaceX()
	{
		return spaceX;
	}
	public int getSpaceY()
	{
		return spaceY;
	}
	 

	// setters

	public void setMaterialLabels(JLabel[] inputMaterialLabels)
	{
		materialLabels = inputMaterialLabels;
	} 

	public void setSpaceLocation()
	{
		spaceX = this.getX();
		spaceY = this.getY();
	}

	public void startThread()
	{
		thread.start();
	}
	public void emptyResources()
	{
		for(int slot = 0; slot < antalPlaneter; slot++)
		{
			resourceChecklist[slot] = false;
			materialLabels[slot].setForeground(Color.BLACK);

		}
	}
	public void addResource(int slot)
	{
		resourceChecklist[slot] = true;
		materialLabels[slot].setForeground(Color.WHITE);
		try
		{
			Thread.sleep(PAUS_TIME);
		}
		catch (InterruptedException e){}
	}

	public void pauseThread()
	{
		try
		{
			Thread.sleep(1000 + random.nextInt(2000));
		}
		catch (InterruptedException e){}
	}

}