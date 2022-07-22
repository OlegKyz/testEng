package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;

public class TestManager extends Panel {
	private Button runButton;
	private TestWindow testWindow;
	private Label testName;
	private Label rightLabel, wrongLabel, missedLabel, allLabel;
	private boolean isWordTest;

	public TestManager(String dirPath, String fileName, boolean isWordT) {
		testWindow = null;
		testName = new Label(fileName);
		rightLabel = new Label("Right: null");
		wrongLabel = new Label("Wrong: null");
		missedLabel = new Label("Missed: null");
		allLabel = new Label("All: null");
		isWordTest = isWordT;
		
		runButton = new Button("Run");
		runButton.addActionListener((ae) -> {
			if (testWindow == null) {
				testWindow = new TestWindow(dirPath, fileName, isWordTest, this);
			}
			testWindow.setVisible(true);
		});
		setLayout(new GridLayout(0, 1, 10, 10));
		add(testName);
		add(rightLabel);
		add(wrongLabel);
		add(missedLabel);
		add(allLabel);
		add(runButton);

		setBackground(Color.GREEN);
	}

	public void setTestResults(int right, int wrong, int missed) {
		rightLabel.setText("Right: " + right);
		wrongLabel.setText("Wrong: " + wrong);
		missedLabel.setText("Missed: " + missed);
		allLabel.setText("All: " + (right + wrong + missed));
	}
}