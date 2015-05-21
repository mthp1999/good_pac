import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class StartMenu extends BasicGameState {

	Image startUnpressed, title, customize, about, highScore;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
		startUnpressed = new Image("img/Start_Unpressed.png");
		title = new Image("img/40itd-pacman_title.png");
		customize = new Image("img/Customize_Unpressed.png");
		about = new Image("img/About_Unpressed.png");
		highScore = new Image("img/High Scores_Unpressed.png");
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(title, 0, 10);
		g.drawImage(startUnpressed, 119, 175);
		g.drawImage(customize, 119, 250);
		g.drawImage(highScore, 119, 325);
		g.drawImage(about, 119, 400);
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if (container.getInput().isMouseButtonDown(0) && container.getInput().getMouseX() > 118 && container.getInput().getMouseX() < 395 && container.getInput().getMouseY() > 174 && container.getInput().getMouseY() < 226) {
			System.out.println("yay");
			game.enterState(1);
		}
		if (container.getInput().isMouseButtonDown(0) && container.getInput().getMouseX() > 118 && container.getInput().getMouseX() < 395 && container.getInput().getMouseY() > 399 && container.getInput().getMouseY() < 451) {
			System.out.println("yay");
			game.enterState(2);
		}
	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
