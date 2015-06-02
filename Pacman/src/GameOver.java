import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class GameOver extends BasicGameState{

	Image gameOver; //when you die three times, it goes to this page
	Button retry, backToMenu;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		gameOver = new Image("img/Game Over.png");//images and buttons are initialized
		retry = new Button("img/Retry");
		backToMenu = new Button("img/BackToMenu");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		
		g.drawImage(gameOver, 0, 0); //it says game over in an image and two buttons are also rendered
		retry.draw(g, 5, 5);
		backToMenu.draw(g, 5, 65);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		if(retry.update(container.getInput())) {
			game.enterState(3); //the state it enters when the button is clicked
		}
		if(backToMenu.update(container.getInput())) {
			game.enterState(0);
		}
	}

	@Override
	public int getID() {
		
		return 6;//class id
	}

}
