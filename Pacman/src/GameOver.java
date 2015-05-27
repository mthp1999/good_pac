import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class GameOver extends BasicGameState{

	Image gameOver;
	Button retry, backToMenu;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		gameOver = new Image("img/Game Over.png");
		retry = new Button("img/Retry");
		backToMenu = new Button("img/BackToMenu");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(gameOver, 0, 0);
		retry.draw(g, 5, 5);
		backToMenu.draw(g, 5, 65);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if(retry.update(container.getInput())) {
			game.enterState(3);
		}
		if(backToMenu.update(container.getInput())) {
			game.enterState(0);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 6;
	}

}
