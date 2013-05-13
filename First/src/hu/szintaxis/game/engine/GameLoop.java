package hu.szintaxis.game.engine;

/**
 * A játék grafikus változatát futtató szál.
 * 
 */
public class GameLoop extends Thread {

	private final Game game;
	private final GameCanvas canvas;
    private boolean stopped;
    private boolean paused;
    private long singleUpdateTime;

    /**
     * Létrehozza a futtató szál objektumot.
     * @param game a játék, amelyen létrehozza
     * @param canvas a vászon, amelyre rajzol
     */
	public GameLoop(Game game, GameCanvas canvas) {
		this.game = game;
		this.canvas = canvas;
        this.stopped = false;
        this.paused = false;
        singleUpdateTime = 1000000000 / game.getFps();
	}

	/**
	 * Szünetelteti a játékot.
	 */
    public void pauseGame() {
        this.paused = true;
    }

    /**
     * Folytatja a játékot.
     */
    public void resumeGame() {
        this.paused = false;
    }

    /**
     * Megállítja a játékot.
     */
    public void stopGame() {
        stopped = true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Thread#run()
     */
	@Override
	public void run() {
		game.init();

		while (!game.isOver() && !stopped) {

			long now = System.nanoTime();
			
            if (!paused) {
                game.update();
                canvas.repaint();
            }
            
            long then = System.nanoTime();
            
            long updateTime = then - now;
            
            long sleepTime = (singleUpdateTime - updateTime) / 1000000;
			try {
				Thread.sleep(Math.max(sleepTime, 0));
			} catch (Exception ex) {
			}
		}
		
		System.exit(0);
	}
}
