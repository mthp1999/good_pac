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
	//public static Button startUnpressed, customize, about, highScore;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
		startUnpressed = new Button("img/Start");
		title = new Image("img/Title.png");
		customize = new Button("img/Customize");
		about = new Button("img/About");
		Game.f1 = new TrueTypeFont(new Font("NewTimesRoman", 0 , 30), false);
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(title, 0, 10);
		startUnpressed.draw(g, 119, 175);
		customize.draw(g, 119, 250);
		about.draw(g, 119, 325);
//		g.draw(startUnpressed, 119, 175);
//		g.drawe(customize, 119, 250);
//		g.drawImage(highScore, 119, 325);
//		g.drawImage(about, 119, 400);
//		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {	
		
		if(startUnpressed.update(container.getInput())) {
			Pacman.numScore = 0;
			game.enterState(3);
		}
		if(customize.update(container.getInput())) {
			game.enterState(5);
		}
		if(about.update(container.getInput())) {
			game.enterState(2);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
