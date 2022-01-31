package ru.boss90.pixelgame.utils;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ObjectUtils {

	public static boolean isLoad=true;
	public static JLabel object = null;
	public static JLabel object2 = null;
	public static JLabel object3 = null;
	public static JLabel object4 = null;
	public static JLabel object5 = null;
	public static ArrayList<Point> locObjects = new ArrayList<>();
	public static ArrayList<JLabel> objects = new ArrayList<>();
	
	public static ArrayList<JLabel> load() {
		
		try {
		//Загружаем текстуру башни етой
		BufferedImage textureObject = ImageIO.read(new File("textures//Tree.png"));
		//прогружаем текстуру объектам
		object = new JLabel(new ImageIcon(textureObject));
		object2 = new JLabel(new ImageIcon(textureObject));
		object3 = new JLabel(new ImageIcon(textureObject));
		object4 = new JLabel(new ImageIcon(textureObject));
		object5 = new JLabel(new ImageIcon(textureObject));
		//записываем объекты в общий список
		objects.clear();
		objects.add(object);
		objects.add(object2);
		objects.add(object3);
		objects.add(object4);
		objects.add(object5);
		//сетаем локацию нашим деревьйам
		objects.forEach(object ->object.setBounds(0,0,90,90));
    	objects.forEach(object -> object.setLocation(new Random().nextInt(700),new Random().nextInt(700)));
		//добавлйаем локацию в эту залупу
    	locObjects.clear();
		locObjects.add(object.getLocation());
		locObjects.add(object2.getLocation());
		locObjects.add(object3.getLocation());
		locObjects.add(object4.getLocation());
		locObjects.add(object5.getLocation());
    	isLoad=false;
		
		}catch(Exception ignored) {ErrorUtils.sendError(ignored.toString());}
		
		return objects;
	}
	
	public static void update() {
		locObjects.clear();
        locObjects.add(object.getLocation());
		locObjects.add(object2.getLocation());
		locObjects.add(object3.getLocation());
		locObjects.add(object4.getLocation());
		locObjects.add(object5.getLocation());
	}
	
}
