import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Food{

	public static int[] foodX = new int [15];
	public static int[] foodY = new int [15];
	public static Image[] food = new Image[15];
	public static Random r = new Random();
	public static void foodClassss () {
		
		

		for (int x = 0; x <15; x++){

			foodX[x] = r.nextInt(501);
			foodY[x] = r.nextInt(501);
			System.out.println(foodY[x]);
		}
		
		for (int x = 0; x < 15; x++){
			try {
				food[x] = new Image("img/foodBall.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void foodRefresh(int x){
		foodX[x] = r.nextInt(501);
		foodY[x] = r.nextInt(501);
	}

}
