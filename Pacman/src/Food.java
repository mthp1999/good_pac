import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Food{

	
	public static int[] foodY = new int [201];
	public static Image[] food = new Image[15];
	
	public static Random r = new Random();
	
	public static void main (String[] args) throws SlickException {
	
		foodY[201] = r.nextInt(501);
		
		for (int x = 0; x <15; x++){
			foodX[x] = r.nextInt(501);
			foodY[x] = r.nextInt(501);
			System.out.println(foodX[x]);
		}
		/*for (int c = 0; c < 15; c++){
			food[c] = new Image("img/foodBall.png");
		}
		food[0] = new Image("img/foodBall.png");
	*/}

}
