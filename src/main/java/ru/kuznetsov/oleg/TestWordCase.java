package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;

public class TestWordCase extends Panel {
	private static int textFieldLength = 15;

	private String rusWord, engWord;
	private Label engLabel;
	private TextField rusField;

	public TestWordCase(String engW, String rusW) {
		rusWord = rusW.toLowerCase();
		engWord = engW.toLowerCase();

		rusField = new TextField(textFieldLength);
		engLabel = new Label(engWord);

		setLayout(new FlowLayout());
		add(engLabel);
		add(rusField);

		rusField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (rusField.getText().toLowerCase().equals(rusWord)) {
					rusField.setForeground(Color.BLUE);
				} else {
					rusField.setForeground(Color.RED);
				}
			}
		});
	}
}