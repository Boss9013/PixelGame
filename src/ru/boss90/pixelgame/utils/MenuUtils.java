package ru.boss90.pixelgame.utils;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class MenuUtils {

	public static void load(String text) {
		try {
			
		    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font//Ponter_Rounded.ttf")).deriveFont(40f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font//Ponter_Rounded.ttf")));
			Container container = GameUtils.perm.getContentPane();
			container.removeAll();
			GameUtils.play.setBounds(0,0,200,40);
			GameUtils.play.setLocation(190,290);
			GameUtils.exit.setBounds(0,0,200,40);
			GameUtils.exit.setLocation(430,315);
			GameUtils.textInMenu.setText(text);
			GameUtils.textInMenu.setSize(200,200);
			GameUtils.textInMenu.setFont(customFont);
			GameUtils.textInMenu.setBounds(0,0,400,90);
			GameUtils.textInMenu.setLocation(295,205);
		    JLabel fon = new JLabel(new ImageIcon("textures//fonMenu.png"));
			fon.setLocation(0,0);
			fon.setBounds(0,0,800,800);
			container.add(GameUtils.textInMenu);
			container.add(GameUtils.play);
			container.add(GameUtils.exit);
			container.add(fon);
			
		}catch(Exception ignored) {}
	}
	
}
