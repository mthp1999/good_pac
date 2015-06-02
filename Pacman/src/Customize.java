
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Customize extends BasicGameState{

	public static String colour = "img/Pacman.png";
	Button green, purple, orange, yellow; //customization options
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		green = new Button("img/GreenPacman");//initializes a button to the picture, using the button class to get it to work
		purple = new Button("img/PurplePacman");
		orange = new Button("img/OrangePacman");
		yellow = new Button("img/YellowPacman");
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		green.draw(g, 125, 100); //renders each of the buttons for different colours
		purple.draw(g,  125, 200);
		orange.draw(g, 125, 300);
		yellow.draw(g, 125, 400);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		if(yellow.update(container.getInput())) {//button class starts working once mouse is over the buttons
			colour = "img/Pacman.png";
			try {
			    Thread.sleep(100);                 //wait function used to prevent bug from causing it to go to the about section
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			game.enterState(0);
		}
		if(green.update(container.getInput())) {
			colour = "img/Pacman_Green.png";
			try {
			    Thread.sleep(100);                 
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			game.enterState(0);
		}
		if(purple.update(container.getInput())) {
			colour = "img/Pacman_Purple.png";
			try {
			    Thread.sleep(100);                 
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			game.enterState(0);
		}
		if(orange.update(container.getInput())) {
			colour = "img/Pacman_Orange.png";
			try {
			    Thread.sleep(100);                 
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			game.enterState(0);
		}
	}

	@Override
	public int getID() {
		
		return 5;//id for the class
	}

}

