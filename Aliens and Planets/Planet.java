import javax.swing.JLabel;
import javax.swing.ImageIcon;

class Planet extends JLabel
{
	// Constants



	// Fields

	private int planetNr;

	//Constructor
	public Planet(String string, ImageIcon icon, int position, int planetNrInput)
	{
		setText(string);
		setIcon(icon);
		setHorizontalAlignment(position);
		planetNr = planetNrInput;

	}


	//Getters


	//Setters

	
	public synchronized void explorePlanet(Ship inputShip)
	{
		inputShip.pauseThread();
		inputShip.setLocation(
			this.getX() + (this.getWidth()-inputShip.getWidth())/2,
			this.getY() + this.getHeight());
		inputShip.pauseThread();
		inputShip.setLocation(inputShip.getSpaceX(), inputShip.getSpaceY());
		inputShip.addResource(planetNr);
	}

}