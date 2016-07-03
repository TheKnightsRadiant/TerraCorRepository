package com.game.src.main;

import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class BufferedImageLoader {

	private BufferedImage image;
	
	public BufferedImage loadImage(String path) throws IOException {
		
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}
	
}
