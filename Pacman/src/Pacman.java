import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Pacman extends BasicGameState {
	
	Image pacman, life1, life2, life3, ghost1, ghost2, ghost3, ghost4;
	Image i;
	int pacmanX, pacmanY, pacmanLives, ghost1X, ghost1Y;

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		pacmanX = 250;
		pacmanY = 285;
		pacman = new Image("img/Pacman.png");
		pacmanLives = 3;
		life1 = new Image("img/Pacman.png");
		life2 = new Image("img/Pacman.png");
		life3 = new Image("img/Pacman.png");
		i = new Image("img/New Map.png");
		ghost1 = new Image("img/ghostRed.png");
		ghost1X = 10;
		ghost1Y = 10;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(i, 10, 10);
		g.drawImage(pacman, pacmanX, pacmanY);
		if(pacmanLives > 0) {
			g.drawImage(life1, 490, 0);
			if(pacmanLives > 1) {
				g.drawImage(life2, 490, 16);
				if(pacmanLives > 2) {
					g.drawImage(life3, 490, 32);
				}
			}
		}
		g.drawImage(ghost1, ghost1X, ghost1Y);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if(container.getInput().isKeyDown(Input.KEY_RIGHT)){
			pacmanX += 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_LEFT)){
			pacmanX -= 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_UP)){
			pacmanY -= 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_DOWN)){
			pacmanY += 1;
		}
		Rectangle r = new Rectangle(ghost1X,ghost1Y, 14, 14);
	    Rectangle p = new Rectangle(pacmanX, pacmanY, 12, 12);
		if(r.intersects(p)) {
			pacmanLives-=1;
			pacmanX = 250;
			pacmanY = 285;
		}
		
	    
		/*if(pacman.Intersects(ghost2)) {
			pacmanLives-=1;
		}
		if(pacman.Intersects(ghost3)) {
			pacmanLives-=1;
		}
		if(pacman.Intersects(ghost4)) {
			pacmanLives-=1;
		}*/
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

}
>>>>>>> origin/master
