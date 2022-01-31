package ru.boss90.pixelgame.main;

import java.util.Timer;
import ru.boss90.pixelgame.utils.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		new GameUtils();
		
		Timer timer = new Timer();
	    Scheduler scheduler = new Scheduler();
	    timer.scheduleAtFixedRate(scheduler, 1000, 1000);
		
	}
	
}
