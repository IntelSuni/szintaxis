package hu.szintaxis.game.engine;


public class GameLoop extends Thread {

	private final Game game;
	private final GameCanvas canvas;
    private boolean stopped;
    private boolean paused;
    private long singleUpdateTime;

	public GameLoop(Game game, GameCanvas canvas) {
		this.game = game;
		this.canvas = canvas;
        this.stopped = false;
        this.paused = false;
        singleUpdateTime = 1000000000 / game.getFps();
	}

    public void pauseGame() {
        this.paused = true;
    }

    public void resumeGame() {
        this.paused = false;
    }

    public void stopGame() {
        stopped = true;
    }

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
				java.io.File f = null;
				f.canExecute();
			} catch (Exception ex) {
			}
		}
	}
}
