
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
	int pacmanX, pacmanY, pacmanLives, ghost1X, ghost1Y, ghost2X, ghost2Y, ghost3X, ghost3Y, ghost4X, ghost4Y;
	boolean wallsLeft, wallsRight, wallsTop, wallsBottom;

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		pacmanX = 240;
		pacmanY = 385;
		pacman = new Image("img/Pacman.png");
		pacmanLives = 3;
		life1 = new Image("img/Pacman_Small.png");
		life2 = new Image("img/Pacman_Small.png");
		life3 = new Image("img/Pacman_Small.png");
		i = new Image("img/New Map.png");
		ghost1 = new Image("img/ghostRed.png");
		ghost2 = new Image("img/ghostLightBlue.png");
		ghost3 = new Image("img/ghostPink.png");
		ghost4 = new Image("img/ghostYellow.png");
		ghost1X = 10;
		ghost1Y = 10;
		ghost2X = 20;
		ghost2Y = 20;
		ghost3X = 30;
		ghost3Y = 30;
		ghost4X = 40;
		ghost4Y = 40;
		wallsLeft = false;
		wallsRight = false;
		wallsTop = false;
		wallsBottom = false;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(i, 0, 0);
		g.drawImage(pacman, pacmanX, pacmanY);
		if(pacmanLives > 0) {
			g.drawImage(life1, 500, 0);
			if(pacmanLives > 1) {
				g.drawImage(life2, 500, 16);
				if(pacmanLives > 2) {
					g.drawImage(life3, 500, 32);
				}
			}
		}
		g.drawImage(ghost1, ghost1X, ghost1Y);
		g.drawImage(ghost2, ghost2X, ghost2Y);
		g.drawImage(ghost3, ghost3X, ghost3Y);
		g.drawImage(ghost4, ghost4X, ghost4Y);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if(container.getInput().isKeyDown(Input.KEY_RIGHT) && pacmanX < 468 && wallsLeft == false){
			pacmanX += 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_LEFT) && pacmanX > 0 && wallsRight == false){
			pacmanX -= 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_UP) && pacmanY > 0 && wallsBottom == false){
			pacmanY -= 1;
		}
		if(container.getInput().isKeyDown(Input.KEY_DOWN) && pacmanY < 483 && wallsTop == false){
			pacmanY += 1;
		}
	    
		Rectangle p = new Rectangle(pacmanX, pacmanY, 12, 12);
		Rectangle g1 = new Rectangle(ghost1X,ghost1Y, 14, 14);
	    Rectangle g2 = new Rectangle(ghost2X,ghost2Y, 14, 14);
	    Rectangle g3 = new Rectangle(ghost3X,ghost3Y, 14, 14);
	    Rectangle g4 = new Rectangle(ghost4X,ghost4Y, 14, 14);
	    Rectangle box1Left = new Rectangle(45, 45, 1, 105);
	    Rectangle box1Right = new Rectangle(155, 45, 1, 105);
	    Rectangle box1Top = new Rectangle(45, 45, 110, 1);
	    Rectangle box1Bottom = new Rectangle(45, 150, 110, 1);
		if(p.intersects(g1) || p.intersects(g2) || p.intersects(g3) || p.intersects(g4)) {
			pacmanLives-=1;
			pacmanX = 240;
			pacmanY = 385;
		}
		if(pacmanLives ==  0) {
			game.enterState(6);
		}
		if(p.intersects(box1Left)) {
			wallsLeft = true;
		} else {
			wallsLeft = false;
		}
		if(p.intersects(box1Right)) {
			wallsRight = true;
		} else {
			wallsRight = false;
		}
		if(p.intersects(box1Top)) {
			wallsTop = true;
		} else {
			wallsTop = false;
		}
		if(p.intersects(box1Bottom)) {
			wallsBottom = true;
		} else {
			wallsBottom = false;
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}

