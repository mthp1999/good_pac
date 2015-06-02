import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class DeathTimer extends BasicGameState{

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		try {
		    Thread.sleep(3000);                 //3000 milliseconds is three seconds.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt(); //once you die, there is a 3 second wait before the characters respawn
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
