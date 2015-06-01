import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Pacman extends BasicGameState {
	
	Image pacman, life1, life2, life3, ghost1, ghost2, ghost3, ghost4, i;
	Image[] food = new Image[15];
	int[] foodX = new int [15];
	int[] foodY = new int [15];
	int numScore = 0;
	String score = "Score";
	int pacmanX, pacmanY, pacmanLives, ghost1X, ghost1Y, ghost2X, ghost2Y, ghost3X, ghost3Y, ghost4X, ghost4Y;
	boolean wallsLeft, wallsRight, wallsTop, wallsBottom;
	Random r = new Random();

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
		Food.foodClassss();
		/*food[0] = new Image("img/foodBall.png");
		foodX[1] = r.nextInt(501);
		foodY[1] = r.nextInt(501);*/
		
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
		g.drawRect(60, 61, 96, 89);
		g.drawRect(0, 290, 42, 303);
		g.drawRect(42, 475, 162, 37);
		g.drawRect(235, 144, 40, 228);
		g.drawRect(169, 244, 176, 41);
		g.drawRect(429, 210, 39, 207);
		g.drawImage(Food.food[0], Food.foodX[0], Food.foodY[0]);
		g.drawImage(Food.food[1], Food.foodX[1], Food.foodY[1]);
		g.drawImage(Food.food[2], Food.foodX[2], Food.foodY[2]);
		g.drawImage(Food.food[3], Food.foodX[3], Food.foodY[3]);
		g.drawImage(Food.food[4], Food.foodX[4], Food.foodY[4]);
		g.drawImage(Food.food[5], Food.foodX[5], Food.foodY[5]);
		g.drawImage(Food.food[6], Food.foodX[6], Food.foodY[6]);
		g.drawImage(Food.food[7], Food.foodX[7], Food.foodY[7]);
		g.drawImage(Food.food[8], Food.foodX[8], Food.foodY[8]);
		g.drawImage(Food.food[9], Food.foodX[9], Food.foodY[9]);
		g.drawImage(Food.food[10], Food.foodX[10], Food.foodY[10]);
		g.drawImage(Food.food[11], Food.foodX[11], Food.foodY[11]);
		g.drawImage(Food.food[12], Food.foodX[12], Food.foodY[12]);
		g.drawImage(Food.food[13], Food.foodX[13], Food.foodY[13]);
		g.drawImage(Food.food[14], Food.foodX[14], Food.foodY[14]);
		g.setColor(Color.white);
		g.drawString(score, 450, 490);
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
		
		score = new Integer(numScore).toString();
		Rectangle p = new Rectangle(pacmanX, pacmanY, 30, 32);//Adding hitboxes to pacman and the 4 ghosts
		Rectangle g1 = new Rectangle(ghost1X,ghost1Y, 14, 14);
	    Rectangle g2 = new Rectangle(ghost2X,ghost2Y, 14, 14);
	    Rectangle g3 = new Rectangle(ghost3X,ghost3Y, 14, 14);
	    Rectangle g4 = new Rectangle(ghost4X,ghost4Y, 14, 14);
	    Rectangle food1 = new Rectangle(Food.foodX[0], Food.foodY[0], 8, 8);
	    Rectangle food2 = new Rectangle(Food.foodX[1], Food.foodY[1], 8, 8);
	    Rectangle food3 = new Rectangle(Food.foodX[2], Food.foodY[2], 8, 8);
	    Rectangle food4 = new Rectangle(Food.foodX[3], Food.foodY[3], 8, 8);
	    Rectangle food5 = new Rectangle(Food.foodX[4], Food.foodY[4], 8, 8);
	    Rectangle food6 = new Rectangle(Food.foodX[5], Food.foodY[5], 8, 8);
	    Rectangle food7 = new Rectangle(Food.foodX[6], Food.foodY[6], 8, 8);
	    Rectangle food8 = new Rectangle(Food.foodX[7], Food.foodY[7], 8, 8);
	    Rectangle food9 = new Rectangle(Food.foodX[8], Food.foodY[8], 8, 8);
	    Rectangle food10 = new Rectangle(Food.foodX[9], Food.foodY[9], 8, 8);
	    Rectangle food11 = new Rectangle(Food.foodX[10], Food.foodY[10], 8, 8);
	    Rectangle food12 = new Rectangle(Food.foodX[11], Food.foodY[11], 8, 8);
	    Rectangle food13 = new Rectangle(Food.foodX[12], Food.foodY[12], 8, 8);
	    Rectangle food14 = new Rectangle(Food.foodX[13], Food.foodY[13], 8, 8);
	    Rectangle food15 = new Rectangle(Food.foodX[14], Food.foodY[14], 8, 8);
	    
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
		if(p.intersects(food1)){
			numScore += 100;
			Food.foodRefresh(0);
		}
		if(p.intersects(food2)){
			numScore += 100;
			Food.foodRefresh(1);
		}
		if(p.intersects(food3)){
			numScore += 100;
			Food.foodRefresh(2);
		}
		if(p.intersects(food4)){
			numScore += 100;
			Food.foodRefresh(3);
		}
		if(p.intersects(food5)){
			numScore += 100;
			Food.foodRefresh(4);
		}
		if(p.intersects(food6)){
			numScore += 100;
			Food.foodRefresh(5);
		}
		if(p.intersects(food7)){
			numScore += 100;
			Food.foodRefresh(6);
		}
		if(p.intersects(food8)){
			numScore += 100;
			Food.foodRefresh(7);
		}
		if(p.intersects(food9)){
			numScore += 100;
			Food.foodRefresh(8);
		}
		if(p.intersects(food10)){
			numScore += 100;
			Food.foodRefresh(9);
		}
		if(p.intersects(food11)){
			numScore += 100;
			Food.foodRefresh(10);
		}
		if(p.intersects(food12)){
			numScore += 100;
			Food.foodRefresh(11);
		}
		if(p.intersects(food13)){
			numScore += 100;
			Food.foodRefresh(12);
		}
		if(p.intersects(food14)){
			numScore += 100;
			Food.foodRefresh(13);
		}
		if(p.intersects(food15)){
			numScore += 100;
			Food.foodRefresh(14);
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
	
	/*public static int[] foodXorY(int[] array) throws SlickException{
		
		int[] arrays = new int[15];
		
		for(int x = 0; x < 15; x++){
			
			
			return arrays[x];
		}
		
		
		

	}*/
	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}


