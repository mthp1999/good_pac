import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class About extends BasicGameState {
	
	Button back;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		back = new Button("img/Back");
	}

	@Override
	/**
	 * Method to show the about in the menu
	 */
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawString("Created by Matthew and Masum ©2015 \nCredits to Shimmy568", 0, 470);
		g.drawString("Welcome to Man-Pac! \n\nTo play, click *Back* and click *Start* \n\nThis is a two player game \n\nThe ghost is controlled by WASD and man-pac is \ncontrolled by the arrow keys \n\nThe ghost has to try and catch man-pac \nwhile man-pac tries to escape and \ncollect the yellow dots\n\nOnce a character dies, both will have to wait \n3 seconds before they can respawn", 25, 100);
		back.draw(g, 230, 10);//coordinates for the back button
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		if(back.update(container.getInput())) {// if back is pressed, this allows it to go back to main menu 
			game.enterState(0);
		}
	}

	@Override
	public int getID() {
		
		return 2; //id for the class
	}

}
