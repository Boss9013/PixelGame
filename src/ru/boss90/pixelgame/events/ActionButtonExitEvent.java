package ru.boss90.pixelgame.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonExitEvent implements ActionListener{	

	@Override
	public void actionPerformed(ActionEvent event) {
			
		System.exit(0);
	}
	
}
