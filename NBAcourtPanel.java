* Name: Nihal Punjani
 * Date: 07.28.20 
 * Program Description: This file creates a GUI for a basketball court that will be used in the NBAPlayoff file
 */

//importing java classes for graphics, panel, and ArrayList
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class NBAcourtPanel extends JPanel {
	

	private static final long serialVersionUID = 1L;
	//declaring a graphics variable
	Graphics g;
	//declaring a JPanel variable
	JPanel p;
	//declaring a NBATeam variable
	NBATeam spurs;
	
	//constructor with the parameter of spurs
	public NBAcourtPanel(NBATeam spurs) {
		//assigning this instance of spurs to the parameter spurs
		this.spurs = spurs;
	}
	
	//protected void method with the parameter g
	protected void paintComponent (Graphics g) {
		//calling the parent class method paintComponent with the parameter g
		super.paintComponent(g);
		//initializing a Graphics2D object
		Graphics2D BballCourt= (Graphics2D) g.create();
		//initializing an integer variable for width
		int width = this.getWidth() - 50;
		//initializing an integer variable for height
		int height = this.getHeight() - 50;
		//initializing an integer variable to set position for x
		int x = ((this.getWidth()-width) / 2);
		//initializing an integer variable to set position for y
		int y = ((this.getHeight()- height) / 2);
		
		//setting the color to orange
		BballCourt.setColor(Color.ORANGE);
		//creates a rectangle for court
		BballCourt.fillRect(x, y, width, height);
		//setting the color to red
		BballCourt.setColor(Color.RED);
		//creates the circle for the center of the court
		BballCourt.fillOval(x+ width / 2 - (height/2) + 45, y + 50, height - 90, height - 90);
		//setting the color to yellow
		BballCourt.setColor(Color.YELLOW);
		//draws a line in the middle of the rectangle
		BballCourt.drawLine(x + width / 2, y, x + width / 2, y + height);
		//draws the arc for the left side of the court
		BballCourt.drawArc(x - (height/2) + 30, y + 40, height - 50, height - 80, 90, -180);
		//draws the arc for the right side of the court
		BballCourt.drawArc(x + width / 2 + height / 2, y + 40, height - 50, height - 80, -90, -180);
		//setting the font
		BballCourt.setFont(new Font("TimesRoman", Font.PLAIN, 16));
		//setting the color to black
		BballCourt.setColor(Color.BLACK);
		//sets the positions for the names of the players
		int yPos = y + 100;
		int xPos = x + width / 2+ 80 + height / 2;
		
		//array list to get the name players
		ArrayList<NBAPlayer> players = spurs.getNbaPlayers();
		//for-loop to display the player names on the court
		for(int i = 0; i< players.size(); i++) {
			BballCourt.drawString(players.get(i).getName(), xPos, yPos + (i * 20));
		}

	}

}
