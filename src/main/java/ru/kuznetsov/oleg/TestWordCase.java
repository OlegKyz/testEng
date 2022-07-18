package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;

public class TestWordCase extends Panel implements TestCase {
	private static int textFieldLength = 15;

	private String rusWord, engWord;
	private Label engLabel;
	private TextField rusField;
	private Button showRightAnswerButton;
	private int testResult;

	public TestWordCase(String engW, String rusW) {
		testResult = 0;
		rusWord = rusW.toLowerCase();
		engWord = engW.toLowerCase();
		showRightAnswerButton = new Button("Show answer");

		rusField = new TextField(textFieldLength);
		engLabel = new Label(engWord);

		setLayout(new FlowLayout());
		add(engLabel);
		add(rusField);
		add(showRightAnswerButton);

		rusField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (rusField.getText().toLowerCase().equals(rusWord)) {
					rusField.setForeground(Color.BLUE);
				} else {
					rusField.setForeground(Color.RED);
				}
				if (testResult == 0) {
					testResult = 1;
				}
			}
		});

		showRightAnswerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				rusField.setText(rusWord);
				if (testResult == 0) {
					testResult = -1;
				}
			}
		});
	}

	@Override
	public int getTestResult() {
		return testResult;
	}

	@Override
	public void cleanTestResult() {
		testResult = 0;
	}
}