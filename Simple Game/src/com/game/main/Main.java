package com.game.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main extends JComponent implements ActionListener{

	//Variables
	int timer = 0;
	String colorString = "red";
	Color color = Color.red;
	
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("New Game");
		Main game = new Main();
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		Timer t = new Timer(30, game);
		t.start();
	}
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
	
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(color);
		g.fillOval(375, 275, 50, 50);
		
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		g.drawString("This is a " + colorString + " circle.", 315, 400);
	}

	
	public void actionPerformed(ActionEvent e) {
		timer++;
		
		if (timer == 25) {
			color = Color.green;
			colorString = "green";
		}
		if (timer == 50) {
			color = Color.red;
			colorString = "red";
			timer = 0;
		}
		
		repaint();
	}

}
