import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Game extends StateBasedGame{
	
	public Game(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String argv[]) {
		try {
			AppGameContainer pacman = new AppGameContainer(new Game("Pacman"));
			pacman.setDisplayMode(512, 512, false);
			pacman.setTargetFrameRate(419);
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
	}
	
	
	

}
