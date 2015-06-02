
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;


public class Game extends StateBasedGame{
	
	public static TrueTypeFont f1;
	public static Object[] scoreList;
	public static Timer timer = new Timer();

	public Game(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	public static void main(String argv[]) {
		Scanner in = new Scanner(System.in);
		//System.out.println("Please enter your name");
		//Score.name = in.nextLine();
		System.out.println("What fps do you want?");
		System.out.println("This decides the speed of pacman, (1 is slower, 600 is faster)");
		int x = in.nextInt();
		try {
			AppGameContainer pacman = new AppGameContainer(new Game("Pacman"));
			pacman.setDisplayMode(512, 512, false);
			pacman.setTargetFrameRate(x - 1);
			pacman.setClearEachFrame(true);
			pacman.start();
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.schedule( new TimerTask() {
		    public void run() {
		       Food.foodRefresh(1);
		       System.out.println("Works");
		    }
		 }, 0, 5*1000);
		
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new StartMenu());
		addState(new Map());
		addState(new About());
		addState(new Pacman());
		addState(new GameOver());
		addState(new Customize());
		addState(new DeathTimer());
	}
	
	
	
	

}

