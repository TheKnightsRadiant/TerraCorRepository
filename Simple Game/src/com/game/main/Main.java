package com.game.main;

import java.awt.*;

import javax.swing.*;

public class Main extends JComponent{

	public static void main(String[] args) {
		
		JFrame window = new JFrame("New Game");
		Main game = new Main();
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.red);
		g.fillOval(375, 275, 50, 50);
		
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		g.drawString("This is a red circle", 315, 400);
	}

}
