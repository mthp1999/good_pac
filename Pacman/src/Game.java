
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

	public Game(String name) {
		super(name);
		// WE MADE ALL THE PICTURES... NOTHING FROM THE INTERNET WAS USED
	}

	@SuppressWarnings("resource")
	public static void main(String argv[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("What fps do you want?");
		System.out.println("This decides the speed of pacman, (2 is slower, 600 is faster)");
		int x = in.nextInt(); //x is to get user input for fps
		try {
			AppGameContainer pacman = new AppGameContainer(new Game("Pacman"));
			pacman.setDisplayMode(512, 512, false); // sets the size of the window
			pacman.setTargetFrameRate(x - 1); // sets the fps
			pacman.setClearEachFrame(true); //clears the screen at the beginning of each frame
			pacman.start(); //starts the game
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new StartMenu()); // each of these states are initialized
		addState(new Map());
		addState(new About());
		addState(new Pacman());
		addState(new GameOver());
		addState(new Customize());
		addState(new DeathTimer());
	}
	
	
	
	

}

