package com.game.src.main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.swing.*;

public class Game extends Canvas implements Runnable {

	//Variables
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "2D Space Game";	
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	
	private boolean is_shooting = false;
	
	private Player p;
	private Controller c;
	
	
	//Initialization Method
	public void init() {
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("/sprite_sheet.png");
			background = loader.loadImage("/background.png");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new KeyInput(this));
		
		p = new Player(200, 200, this);
		c = new Controller(this);
	}
	
	
	//Start Method
	private synchronized void start() {
		if (running) 
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	//Stop Method
	private synchronized void stop() {
		if (!running) 
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	
	//Run Method
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("Ticks: " + updates + " | FPS: " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	
	//Tick Method
	private void tick() {
		p.tick();
		c.tick();
	}
	
	
	//Render Method
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////////
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		
		g.drawImage(background, 0, 0, null);
		
		p.render(g);
		c.render(g);
		
		/////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_D) {
			p.setVelX(5);
		} else if (key == KeyEvent.VK_A) {
			p.setVelX(-5);
		} else if (key == KeyEvent.VK_S) {
			p.setVelY(5);
		} else if (key == KeyEvent.VK_W) {
			p.setVelY(-5);
		}
		if (key == KeyEvent.VK_SPACE && !is_shooting) {
			is_shooting = true;
			c.addBullet(new Bullet(p.getX(), p.getY(), this));
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_D) {
			p.setVelX(0);
		} else if (key == KeyEvent.VK_A) {
			p.setVelX(0);
		} else if (key == KeyEvent.VK_S) {
			p.setVelY(0);
		} else if (key == KeyEvent.VK_W) {
			p.setVelY(0);
		}
		if (key == KeyEvent.VK_SPACE) {
			is_shooting = false;
		}
	}
	
	
	//Main Method
	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
	
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}
	
}