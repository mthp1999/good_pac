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
		// TODO Auto-generated method stub
		back = new Button("img/Back");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawString("Created by Matthew and Masum ©2015 \nCredits to Shimmy568", 0, 470);
		g.drawString("Welcome to Man-Pac! \n\nTo play, click *Back* and click *Start* \n\nThe main objective of this game is to \navoid the ghosts and collect the white dots\n\nTo move, use the arrow keys \n\nOnce you die, you have to wait 3 seconds \nbefore you can respawn", 75, 150);
		back.draw(g, 230, 10);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if(back.update(container.getInput())) {
			game.enterState(0);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
