

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
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
		Circle food;
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
		g.drawOval(21, 21, 16, 16);
		g.setColor(Color.orange);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		pacman = new Image(Customize.colour);//controls for up, down, left, and right
		if(container.getInput().isKeyDown(Input.KEY_RIGHT) && pacmanX < 482 && wallsLeft == false){
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
		
		Rectangle p = new Rectangle(pacmanX, pacmanY, 12, 12);//Adding hitboxes to pacman and the 4 ghosts
		Rectangle g1 = new Rectangle(ghost1X,ghost1Y, 14, 14);
	    Rectangle g2 = new Rectangle(ghost2X,ghost2Y, 14, 14);
	    Rectangle g3 = new Rectangle(ghost3X,ghost3Y, 14, 14);
	    Rectangle g4 = new Rectangle(ghost4X,ghost4Y, 14, 14);
	    
		if(p.intersects(g1) || p.intersects(g2) || p.intersects(g3) || p.intersects(g4)) {//checking hitboxes for ghost to pacman, if they touch - removea lifeand set back to start
			pacmanX = 240;
			pacmanY = 385;
			pacmanLives-=1;
			game.enterState(7);
		}
		if(pacmanLives ==  0) {
			pacmanLives = 3;
			game.enterState(6);
		}
		if(p.intersects(rectangles.box1Left) || p.intersects(rectangles.box3Left1) || p.intersects(rectangles.box3Left2) || p.intersects(rectangles.box3Left3) || p.intersects(rectangles.box4Left)) {
			wallsLeft = true;
		} else {
			wallsLeft = false;
		}
		if(p.intersects(rectangles.box1Right) || p.intersects(rectangles.box2Right1) || p.intersects(rectangles.box2Right2) || p.intersects(rectangles.box3Right1) || p.intersects(rectangles.box3Right2) || p.intersects(rectangles.box3Right3) || p.intersects(rectangles.box4Right)) {
			wallsRight = true;
		} else {
			wallsRight = false;
		}
		if(p.intersects(rectangles.box1Top) || p.intersects(rectangles.box2Top1) || p.intersects(rectangles.box2Top2) || p.intersects(rectangles.box3Top1) || p.intersects(rectangles.box3Top2) || p.intersects(rectangles.box3Top3) || p.intersects(rectangles.box4Top)) {
			wallsTop = true;
		} else {
			wallsTop = false;
		}
		if(p.intersects(rectangles.box1Bottom) || p.intersects(rectangles.box3Bottom1) || p.intersects(rectangles.box3Bottom2) || p.intersects(rectangles.box3Bottom3) || p.intersects(rectangles.box4Bottom)) {
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


