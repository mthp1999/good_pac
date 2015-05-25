import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class StartMenu extends BasicGameState {

	Button startUnpressed, customize, about, highScore;
	Image title;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
		startUnpressed = new Button("img/Start_Unpressed");
		title = new Image("img/40itd-pacman_title.png");
		customize = new Button("img/Customize_Unpressed");
		about = new Button("img/About_Unpressed");
		highScore = new Button("img/High Scores_Unpressed");
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(title, 0, 10);
//		g.draw(startUnpressed, 119, 175);
//		g.drawe(customize, 119, 250);
//		g.drawImage(highScore, 119, 325);
//		g.drawImage(about, 119, 400);
//		
		
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
