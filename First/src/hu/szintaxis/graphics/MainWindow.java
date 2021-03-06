package hu.szintaxis.graphics;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

/**
 * Az j�t�k grafikus v�ltozat�nak alkalmaz�s ablak�t megval�s�t� oszt�ly.
 *
 */
public class MainWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	public JPanel panel;
	/*
	 * Hangyairt� �s hangyaszag semleges�t� radio gombok.
	 */
	public JRadioButton rdbtnExtermimator, rdbtnNeutralizer;
	/*
	 * Hangyairt� �s hangyaszag semleges�t� c�mk�k.
	 */
	public JLabel lblExterminator, lblNeutralitzer;
	/*
	 * �j j�t�k, Sz�net, Seg�ts�g �s Kil�p�s gombok.
	 */
	public JButton btnNewGame, btnPause, btnHelp, btnExit;
	
	/**
	 * L�trehozza �s inicializ�lja az alkalmaz�s ablakot.
	 */
	public MainWindow() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		btnNewGame = new JButton("New game");
		panel.add(btnNewGame);
		
		btnPause = new JButton("Pause");
		panel.add(btnPause);
		
		btnHelp = new JButton("Help");
		panel.add(btnHelp);
		
		btnExit = new JButton("Exit");
		panel.add(btnExit);
				
		rdbtnExtermimator = new JRadioButton("Exterminator");
		panel.add(rdbtnExtermimator);
		// Alap�rtelmezetten a hangyairt� spray van kiv�lasztva.
		rdbtnExtermimator.setSelected(true);
		
		lblExterminator = new JLabel("[ 20 ]");
		panel.add(lblExterminator);
		
		rdbtnNeutralizer = new JRadioButton("Neutralizer");
		panel.add(rdbtnNeutralizer);
		
		lblNeutralitzer = new JLabel("[ 20 ]");
		panel.add(lblNeutralitzer);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnExtermimator);
		btnGroup.add(rdbtnNeutralizer);
				
		Component horizontalGlue_7 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_7);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_6);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_5);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_4);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_3);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_2);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
	}
}
