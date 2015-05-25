import java.awt.Image;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class About extends BasicGameState {
	
	Image back;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		back = new Image("img/Back_Unpressed.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		g.drawString("Created by Matthew and Masum ©2015 \nCredits to Shimmy568", 0, 470);
		g.drawString("Welcome to pacman \n\nTo play, click *back* and click *play* \n\nThe main objective of this game is to \navoid the ghosts and collect the white dots\n\nTo move, use the directional keys", 75, 180);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
