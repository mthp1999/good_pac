import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class StartMenu extends BasicGameState {

	Button startUnpressed, customize, about;
	
	Image title;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		
		startUnpressed = new Button("img/Start"); //images and buttons are initialized
		title = new Image("img/Title.png");
		customize = new Button("img/Customize");
		about = new Button("img/About");
		Game.f1 = new TrueTypeFont(new Font("NewTimesRoman", 0 , 30), false); //font is set for the game
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		
		g.drawImage(title, 0, 10); //buttons and pictures are rendered
		startUnpressed.draw(g, 119, 175);
		customize.draw(g, 119, 250);
		about.draw(g, 119, 325);	
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {	
		
		if(startUnpressed.update(container.getInput())) {
			Pacman.numScore = 0; //score set to 0 to begin with
			game.enterState(3);
		}
		if(customize.update(container.getInput())) {//states are set according to button
			game.enterState(5);
		}
		if(about.update(container.getInput())) {
			game.enterState(2);
		}
	}

	@Override
	public int getID() {
		
		return 0; //class id
	}

}
