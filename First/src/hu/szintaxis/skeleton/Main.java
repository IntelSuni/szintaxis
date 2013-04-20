package hu.szintaxis.skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import System.Game;

public class Main {

	/**
	 * A Skeleton program belépési pontja. Felajánlja a lehetséges teszteseteket, amelyek végrehajthatóak.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

//		Skeleton s = new Skeleton();
//		BufferedReader bufferedReader = new BufferedReader(
//				new InputStreamReader(System.in));
//
//		do {
//			s.printTests();
//			try {
//				int i = Integer.parseInt(bufferedReader.readLine());
//				s.startTest(i);
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (NumberFormatException e) {
//				System.out.println("Kérem egy számot adjon!");
//				System.out.println();
//			}
//		} while (true);
		
		
		Game game = new Game();
		game.newGame();
		
		
	}
}
