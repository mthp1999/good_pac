import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


@SuppressWarnings("unused")
public class Map extends BasicGameState{

	Image i;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		i = new Image("img/New Map.png"); //map image is initialized
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		g.drawImage(i, 10, 10); //map is placed on the window
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		//there is nothing to update
		
	}

	@Override
	public int getID() {
		
		return 1; //class id
	}
	

}
