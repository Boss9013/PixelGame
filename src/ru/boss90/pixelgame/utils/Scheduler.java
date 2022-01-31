package ru.boss90.pixelgame.utils;

import java.awt.Point;
import java.util.TimerTask;

public class Scheduler extends TimerTask{

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		
		ObjectUtils.objects.forEach(object ->
			object.move(object.getLocation().x-PlayerUtils.player.getLocation().x-5,object.getLocation().y-PlayerUtils.player.getLocation().y-5));
		ObjectUtils.update();
		GameUtils.update();
		
		for(Point locObjects : ObjectUtils.locObjects) {
			if(PlayerUtils.player.getLocation().distance(locObjects.getX(), locObjects.getY())<50) {
				MenuUtils.load("Вы проиграли :C");
				PlayerUtils.size=0;
				return;
			}
		}
		
	}
	
}