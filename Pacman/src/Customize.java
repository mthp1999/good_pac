
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Customize extends BasicGameState{

	public static String colour = "img/Pacman.png";
	Button green, purple, orange, yellow;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		green = new Button("img/GreenPacman");
		purple = new Button("img/PurplePacman");
		orange = new Button("img/OrangePacman");
		yellow = new Button("img/YellowPacman");
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		green.draw(g, 100, 100);
		purple.draw(g,  100, 200);
		orange.draw(g, 100, 300);
		yellow.draw(g, 100, 400);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if(yellow.update(container.getInput())) {
			colour = "img/Pacman.png";
			try {
			    Thread.sleep(100);                 
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
		// TODO Auto-generated method stub
		return 5;
	}

}

