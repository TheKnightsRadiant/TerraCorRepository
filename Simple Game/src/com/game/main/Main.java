package com.game.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main extends JComponent implements ActionListener{

	//Variables
	int timer = 0;
	Color color = Color.red;
	Color backgroundColor = Color.green;
	
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("New Game");
		Main game = new Main();
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setVisible(true);
		
		Timer t = new Timer(10, game);
		t.start();
	}
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
	
	
	protected void paintComponent(Graphics g) {
		
		//Background
		g.setColor(backgroundColor);
		g.fillRect(0, 0, 800, 600);
		
		//Circle
		g.setColor(color);
		for (int x = 5; x <= 745; x+=100)
			for (int y = 5; y <= 545; y+= 100)
				g.fillOval(x, y, 50, 50);
	}

	
	public void actionPerformed(ActionEvent e) {
		timer++;
		
		if (timer == 5) {
			color = Color.green;
			backgroundColor = Color.red;
		}
		if (timer == 10) {
			color = Color.red;
			backgroundColor = Color.green;

			timer = 0;
		
		}
		repaint();
	}

}
