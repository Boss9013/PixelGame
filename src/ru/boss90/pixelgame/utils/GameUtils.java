package ru.boss90.pixelgame.utils;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.*;
import ru.boss90.pixelgame.enums.StepType;
import ru.boss90.pixelgame.events.*;

public class GameUtils extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	public static JPanel player = new JPanel();
	public static JDialog errorMsg = new JDialog();
	public static JLabel score = new JLabel("Очков: 0");
	public static JButton play = new JButton("Начать заново");
	public static JButton exit = new JButton("Выйти");
	public static JLabel textInMenu = new JLabel("Вы проиграли :C");
	public static GameUtils perm;
	public static boolean isEsc;
	
	@SuppressWarnings("serial")
	public GameUtils() throws URISyntaxException {
		super("Пиксельнайа игра");
		
		try {
			perm=this;
			setBounds(850, 850, 850, 850);
			this.setResizable(false);
			Image img = Toolkit.getDefaultToolkit().getImage("textures/fon.png");
		      this.setContentPane(new JPanel() {
		          @Override
		          public void paintComponent(Graphics g) {
		             super.paintComponent(g);
		             g.drawImage(img, 0, 0, null);
		             repaint();
		          }
		       });
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	setVisible(true);
	    	load();
	    	exit.addActionListener(new ActionButtonExitEvent());
	    	play.addActionListener(new  ActionButtonPlayEvent());
	    	addKeyListener(this);
	    	
		}catch(Exception ignored) {ErrorUtils.sendError(ignored.toString());}
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		try {
			
			if(event.getKeyCode()==KeyEvent.VK_DOWN) PlayerUtils.nextStep(StepType.DOWN);
			if(event.getKeyCode()==KeyEvent.VK_UP) PlayerUtils.nextStep(StepType.UP);
			if(event.getKeyCode()==KeyEvent.VK_RIGHT) PlayerUtils.nextStep(StepType.RIGHT);
			if(event.getKeyCode()==KeyEvent.VK_LEFT) PlayerUtils.nextStep(StepType.LEFT);
			if(event.getKeyCode()==KeyEvent.VK_ESCAPE) {
				if(isEsc) {
					load();
					isEsc=false;
					return;
				}
				
				MenuUtils.load("Меню");
				
				isEsc=true;
			}
			
		}catch(Exception ignored) {}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
	}

	@Override
	public void keyTyped(KeyEvent event) {
	}
	
	public static void load() {
		Container container = perm.getContentPane();
		container.removeAll();
		container.add(PlayerUtils.load());
		score.setText("Очков: "+PlayerUtils.size);
		score.setBounds(0,0,90,10);
		score.setLocation(365,0);
		container.add(score);
    	container.add(PointUtils.create());
    	for(JLabel object : ObjectUtils.load()) {
    		container.add(object);
    	}
	}
	
	public static void update() {
		perm.repaint();
		perm.getGraphics().dispose();
	}
	
}
