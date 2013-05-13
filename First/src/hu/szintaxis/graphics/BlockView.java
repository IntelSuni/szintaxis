package hu.szintaxis.graphics;

import java.awt.Graphics2D;

import System.Block;
import System.View;

/**
 * Az akadály kirajzolásáért felelõs osztály.
 */
public class BlockView implements View {

	public Block m_Block;

	/**
	 * Létrehozza a nézetet.
	 */
	public BlockView(){

	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}

	/*
	 * (non-Javadoc)
	 * @see System.View#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}