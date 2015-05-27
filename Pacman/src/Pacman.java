import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Pacman extends BasicGameState {
	
	Image pacman;
	Image i;
	int x, y;

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		x = 250;
		y = 285;
		pacman = new Image("img/Pacman.png");
		i = new Image("img/pacman_layout1.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(i, 10, 10);
		g.drawImage(pacman, x, y);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if(container.getInput().isKeyDown(Input.KEY_RIGHT)){
			x += 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_LEFT)){
			x -= 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_UP)){
			y -= 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_DOWN)){
			y += 1;
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

}
