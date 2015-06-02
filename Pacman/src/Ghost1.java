
public class Ghost1 {
	
	public static void move(){
		Pacman.ghost1X -= 100;
		try {
		    Thread.sleep(250);                 //3000 milliseconds is three seconds.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		Pacman.ghost1Y -= 100;
		try {
		    Thread.sleep(250);                 //3000 milliseconds is three seconds.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		Pacman.ghost1X += 100;
		try {
		    Thread.sleep(250);                 //3000 milliseconds is three seconds.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		Pacman.ghost1Y += 100;
		/*while(Pacman.pacmanLives != 0){
			for(int left = 0; left < 10; left++){
				
			}
			for(int down = 0; down < 10; down++){
				
			}
			for(int right = 0; right < 10; right++){
				
			}
			for(int up = 0; up < 10; up++){
				
			}
		}*/
		
	}

}
