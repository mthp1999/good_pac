<<<<<<< HEAD

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
		pacman = new Image(Customize.colour);
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
	    Rectangle box1Top = new Rectangle(45, 40, 110, 1);
	    Rectangle box1Bottom = new Rectangle(45, 150, 110, 1);
	    Rectangle box2Top1 = new Rectangle(0, 270, 42, 1);
	    Rectangle box2Right1 = new Rectangle(42, 290, 1, 185);
	    Rectangle box2Top2 = new Rectangle(42, 455, 162, 1);
	    Rectangle box2Right2 = new Rectangle(204, 475, 1, 37);
	    Rectangle box3Top1 = new Rectangle (215, 144, 60, 1);
	    Rectangle box3Top2 = new Rectangle(169, 224, 66, 1);
	    Rectangle box3Top3 = new Rectangle(275, 224, 70, 1);
	    Rectangle box3Right1 = new Rectangle(275, 144, 1, 100);
	    Rectangle box3Right2 = new Rectangle(345, 244, 1, 41);
	    Rectangle box3Right3 = new Rectangle(275, 285, 1, 87);
	    Rectangle box3Left1 = new Rectangle(215, 139, 1, 100);
	    Rectangle box3Left2 = new Rectangle(149, 239, 1, 41);
	    Rectangle box3Left3 = new Rectangle(215, 285, 1, 87);
	    Rectangle box3Bottom1 = new Rectangle(149, 285, 60, 1);
	    Rectangle box3Bottom2 = new Rectangle(215, 372, 66, 1);
	    Rectangle box3Bottom3 = new Rectangle(275, 285, 70, 1);
	    Rectangle box4Top = new Rectangle(409, 190, 39, 1);
	    Rectangle box4Left = new Rectangle(409, 190, 1, 227);
	    Rectangle box4Right = new Rectangle(468, 210, 1, 207);
	    Rectangle box4Bottom = new Rectangle(429, 417, 39, 1);
	    
		if(p.intersects(g1) || p.intersects(g2) || p.intersects(g3) || p.intersects(g4)) {
			pacmanLives-=1;
			pacmanX = 240;
			pacmanY = 385;
		}
		if(pacmanLives ==  0) {
			pacmanLives = 3;
			game.enterState(6);
		}
		if(p.intersects(box1Left) || p.intersects(box3Left1) || p.intersects(box3Left2) || p.intersects(box3Left3) || p.intersects(box4Left)) {
			wallsLeft = true;
		} else {
			wallsLeft = false;
		}
		if(p.intersects(box1Right) || p.intersects(box2Right1) || p.intersects(box2Right2) || p.intersects(box3Right1) || p.intersects(box3Right2) || p.intersects(box3Right3) || p.intersects(box4Right)) {
			wallsRight = true;
		} else {
			wallsRight = false;
		}
		if(p.intersects(box1Top) || p.intersects(box2Top1) || p.intersects(box2Top2) || p.intersects(box3Top1) || p.intersects(box3Top2) || p.intersects(box3Top3) || p.intersects(box4Top)) {
			wallsTop = true;
		} else {
			wallsTop = false;
		}
		if(p.intersects(box1Bottom) || p.intersects(box3Bottom1) || p.intersects(box3Bottom2) || p.intersects(box3Bottom3) || p.intersects(box4Bottom)) {
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

=======

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
		pacman = new Image(/*Customize.colour*/ "img/Pacman.png");
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
	    Rectangle box1Top = new Rectangle(45, 40, 110, 1);
	    Rectangle box1Bottom = new Rectangle(45, 150, 110, 1);
	    Rectangle box2Top1 = new Rectangle(0, 270, 42, 1);
	    Rectangle box2Right1 = new Rectangle(42, 290, 1, 185);
	    Rectangle box2Top2 = new Rectangle(42, 455, 162, 1);
	    Rectangle box2Right2 = new Rectangle(204, 475, 1, 37);
	    Rectangle box3Top1 = new Rectangle (215, 144, 60, 1);
	    Rectangle box3Top2 = new Rectangle(169, 224, 66, 1);
	    Rectangle box3Top3 = new Rectangle(275, 224, 70, 1);
	    Rectangle box3Right1 = new Rectangle(275, 144, 1, 100);
	    Rectangle box3Right2 = new Rectangle(345, 244, 1, 41);
	    Rectangle box3Right3 = new Rectangle(275, 285, 1, 87);
	    Rectangle box3Left1 = new Rectangle(215, 139, 1, 100);
	    Rectangle box3Left2 = new Rectangle(149, 239, 1, 41);
	    Rectangle box3Left3 = new Rectangle(215, 285, 1, 87);
	    Rectangle box3Bottom1 = new Rectangle(149, 285, 60, 1);
	    Rectangle box3Bottom2 = new Rectangle(215, 372, 66, 1);
	    Rectangle box3Bottom3 = new Rectangle(275, 285, 70, 1);
	    Rectangle box4Top = new Rectangle(409, 190, 39, 1);
	    Rectangle box4Left = new Rectangle(409, 190, 1, 227);
	    Rectangle box4Right = new Rectangle(468, 210, 1, 207);
	    Rectangle box4Bottom = new Rectangle(429, 417, 39, 1);
	    
		if(p.intersects(g1) || p.intersects(g2) || p.intersects(g3) || p.intersects(g4)) {
			pacmanLives-=1;
			pacmanX = 240;
			pacmanY = 385;
		}
		if(pacmanLives ==  0) {
			pacmanLives = 3;
			game.enterState(6);
		}
		if(p.intersects(box1Left) || p.intersects(box3Left1) || p.intersects(box3Left2) || p.intersects(box3Left3) || p.intersects(box4Left)) {
			wallsLeft = true;
		} else {
			wallsLeft = false;
		}
		if(p.intersects(box1Right) || p.intersects(box2Right1) || p.intersects(box2Right2) || p.intersects(box3Right1) || p.intersects(box3Right2) || p.intersects(box3Right3) || p.intersects(box4Right)) {
			wallsRight = true;
		} else {
			wallsRight = false;
		}
		if(p.intersects(box1Top) || p.intersects(box2Top1) || p.intersects(box2Top2) || p.intersects(box3Top1) || p.intersects(box3Top2) || p.intersects(box3Top3) || p.intersects(box4Top)) {
			wallsTop = true;
		} else {
			wallsTop = false;
		}
		if(p.intersects(box1Bottom) || p.intersects(box3Bottom1) || p.intersects(box3Bottom2) || p.intersects(box3Bottom3) || p.intersects(box4Bottom)) {
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

>>>>>>> origin/master
