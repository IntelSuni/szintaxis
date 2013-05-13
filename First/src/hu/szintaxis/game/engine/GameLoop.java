package hu.szintaxis.game.engine;

/**
 * A j�t�k grafikus v�ltozat�t futtat� sz�l.
 * 
 */
public class GameLoop extends Thread {

	private final Game game;
	private final GameCanvas canvas;
    private boolean stopped;
    private boolean paused;
    private long singleUpdateTime;

    /**
     * L�trehozza a futtat� sz�l objektumot.
     * @param game a j�t�k, amelyen l�trehozza
     * @param canvas a v�szon, amelyre rajzol
     */
	public GameLoop(Game game, GameCanvas canvas) {
		this.game = game;
		this.canvas = canvas;
        this.stopped = false;
        this.paused = false;
        singleUpdateTime = 1000000000 / game.getFps();
	}

	/**
	 * Sz�netelteti a j�t�kot.
	 */
    public void pauseGame() {
        this.paused = true;
    }

    /**
     * Folytatja a j�t�kot.
     */
    public void resumeGame() {
        this.paused = false;
    }

    /**
     * Meg�ll�tja a j�t�kot.
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
