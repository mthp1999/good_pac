import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class HighScore extends BasicGameState{
	Button back;
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
	
		back = new Button("img/Back");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		Game.f1.drawString(150, 25, "Highscores");
		g.drawRect(75, 75, 350, 350);
		back.draw(g, 220, 450);
//		drawScores(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if(back.update(container.getInput())){
			game.enterState(0);
		}
	}
	
	private void drawScores(Graphics g){
		for(int i = 0; i < 10; i++){
			//draws the numbers for position
			g.drawString((i + 1) + ") ", 80, 80 + i * 30);
			//this is drawing the name on the left side of the box and the score on the right
			g.drawString(Game.scoreList[i].Pacman, 110, 80 + i * 30);
			g.drawString(String .valueOf(Game.scoreList[i].Score), 370 - g.getFont().getWidth(String.valueOf(Game.scoreList[i].Score)), 80 + 30 * i);
		}
	}
	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}

}
