package ru.boss90.pixelgame.enums;

public enum StepType {

	RIGHT("�����", 0, 5),
	LEFT("����", 0, -5),
	UP("�����", -5, 0),
	DOWN("����", 5, 0);
	
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
