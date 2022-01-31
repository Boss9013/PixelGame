package ru.boss90.pixelgame.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PointUtils {

	public static JLabel apple;
	
	public static JLabel create() {
		
		try {
			
			BufferedImage textureObject = ImageIO.read(new File("textures//apple.png"));
			apple = new JLabel(new ImageIcon(textureObject));		
			apple.setBounds(0,0,50,50);
	    	apple.setLocation(new Random().nextInt(700),new Random().nextInt(700));
			
		}catch(Exception ignored) {}
		
		return apple;
	}
	
	public static void move() {
		apple.setBounds(0,0,50,50);
    	apple.setLocation(new Random().nextInt(700),new Random().nextInt(700));
	}
}
