
import java.util.Scanner;

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
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	public static void main(String argv[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your name");
		Score.name = in.nextLine();
		System.out.println("What fps do you want?");
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
		
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new StartMenu());
		addState(new Map());
		addState(new About());
		addState(new Pacman());
		addState(new GameOver());
		addState(new Customize());
		addState(new HighScore());
		addState(new Timer());
	}
	
	
	
	

}

