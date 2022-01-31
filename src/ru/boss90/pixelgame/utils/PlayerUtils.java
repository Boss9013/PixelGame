package ru.boss90.pixelgame.utils;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import ru.boss90.pixelgame.enums.StepType;
import java.util.*;

public class PlayerUtils {

	public static JLabel player = null;
	public static ArrayList<String> random = new ArrayList<>();
	public static String selected;
	public static StepType lastStep;
	public static int size;
	
	public static JLabel load() {
		
		random.add("textures/player/player.png");
		random.add("textures/player/player2.png");
		
		try {
		
			selected=random.get(new Random().nextInt(2));
			BufferedImage texturePlayer = ImageIO.read(new File(selected));
			player = new JLabel(new ImageIcon(selected));
			player.setBounds(0,0,50+size,50+size);
			player.setLocation(0,0);
			player.setIcon(new ImageIcon(new ImageIcon(texturePlayer).getImage().getScaledInstance(player.getIcon().getIconWidth()+size, player.getIcon().getIconHeight()+size, Image.SCALE_DEFAULT)));
		
		}catch(Exception error) {System.out.println(error);}
		return player;
	}
	
	@SuppressWarnings("deprecation")
	public static void nextStep(StepType type) {
		try {
			if(player.getLocation().distance(PointUtils.apple.getLocation().x, PointUtils.apple.getLocation().y)<20) {
				PointUtils.move();
				size=size+10;
				GameUtils.load();
			}
			
			if(player.getLocation().getX()>800) {
				player.setLocation(0,0);
				return;
			}
			if(player.getLocation().getX()<0) {
				player.setLocation(0,0);
				return;
			}
			if(player.getLocation().getY()>800) {
				player.setLocation(0,0);
				return;
			}
			if(player.getLocation().getY()<0) {
				player.setLocation(0,0);
				return;
			}
			for(Point locObjects : ObjectUtils.locObjects)
				if(player.getLocation().distance(locObjects.getX(), locObjects.getY())<50) {
					MenuUtils.load("Вы проиграли :C");
					size=0;
					return;
				}
			if(!MusicUtils.playing)
				MusicUtils.playSound("sounds//shagi.wav");
			player.move(player.getLocation().x+type.getX(), player.getLocation().y+type.getY());
			lastStep=type;
		}catch(Exception error) {}
	}
}
