package ru.boss90.pixelgame.utils;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ErrorUtils {

	public static void sendError(String error) {
		JDialog errorMsg = GameUtils.errorMsg;

		errorMsg.setLayout(new FlowLayout());
		errorMsg.setBounds(100, 100, 500, 100);
		errorMsg.setTitle("Ошибка :C");
		JLabel nameError = new JLabel("Произошла ошибка. Ошибка: "+error);
		errorMsg.add(nameError);
		
		errorMsg.setVisible(true);
	}
}
