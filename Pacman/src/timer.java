import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class timer extends BasicGameState{

	Image three, two, one, zero;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		three = new Image("img/3.png");
		two = new Image("img/2.png");
		one = new Image("img/1.png");
		zero = new Image("img/0.png");
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawImage(three, 0, 0);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		g.drawImage(two, 0, 0);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		g.drawImage(one, 0, 0);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		g.drawImage(zero, 0, 0);
		try {
		    Thread.sleep(250);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		game.enterState(3);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		
	}

	@Override
	public int getID() {
		
		return 7;
	}

}
