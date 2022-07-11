package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;

public class TestManager extends Panel {
	private Button runButton;
	private TestWindow testWindow;
	private Label testName;
	boolean isWordTest;

	public TestManager(String dirPath, String fileName, boolean isWordT) {
		testWindow = null;
		testName = new Label(fileName);
		isWordTest = isWordT;
		
		runButton = new Button("Run");
		runButton.addActionListener((ae) -> {
			if (testWindow == null) {
				testWindow = new TestWindow(dirPath, fileName, isWordTest);
			}
			testWindow.setVisible(true);
		});
		setLayout(new GridLayout(0, 1, 10, 10));
		add(testName);
		add(runButton);

		setBackground(Color.GREEN);
	}
}