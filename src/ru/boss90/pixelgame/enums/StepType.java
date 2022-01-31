package ru.boss90.pixelgame.enums;

public enum StepType {

	RIGHT("Право", 0, 5),
	LEFT("Лево", 0, -5),
	UP("Вверх", -5, 0),
	DOWN("Вниз", 5, 0);
	
	private int y;
	private int x;
    private StepType(String name, int y, int x) {
        this.y = y;
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public int getX() {
        return this.x;
    }
}
