package ru.boss90.pixelgame.events;

import java.awt.event.*;
import ru.boss90.pixelgame.utils.*;

public class ActionButtonPlayEvent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
			
		String path = System.getProperty("user.dir");
		
		try {
			PlayerUtils.size=0;
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K && cd /"+path.substring(0, 1)+" "+path.substring(0, 1)+":/ && cd "+path+" && java -jar Game.jar && exit");
			System.exit(0);
		}catch(Exception ignored) {}
		
	}
}