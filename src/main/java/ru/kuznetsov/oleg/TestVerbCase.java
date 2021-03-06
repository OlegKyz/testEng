package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;

public class TestVerbCase extends Panel implements TestCase {
	private static int textFieldLength = 15;

	private String first, second, third, rus;
	private Label firstLabel;
	private TextField secondField, thirdField;
	private TextField rusField;
	private Label rusLabel;
	private Button showRightAnswersButton;
	private int secondTestResult, thirdTestResult;

	public TestVerbCase(String first, String second, String third, String rus) {
		secondTestResult = 0;
		thirdTestResult = 0;
		this.first = first.toLowerCase();
		this.second = second.toLowerCase();
		this.third = third.toLowerCase();
		this.rus = rus;
		firstLabel = new Label(first);
		secondField = new TextField(textFieldLength);
		thirdField = new TextField(textFieldLength);
		//rusField = new TextField(textFieldLength);
		rusLabel = new Label(rus);
		showRightAnswersButton = new Button("Show answers");

		setLayout(new FlowLayout());
		add(firstLabel);
		add(secondField);
		add(thirdField);
		add(rusLabel);
		add(showRightAnswersButton);

		secondField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (secondField.getText().toLowerCase().equals(second)) {
					secondField.setForeground(Color.BLUE);
					if (secondTestResult == 0) {
						secondTestResult = 1;
					}
				} else {
					secondField.setForeground(Color.RED);
				}
			}
		});

		thirdField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (thirdField.getText().toLowerCase().equals(third)) {
					thirdField.setForeground(Color.BLUE);
					if (thirdTestResult == 0) {
						thirdTestResult = 1;
					}
				} else {
					thirdField.setForeground(Color.RED);
				}
			}
		});

		// rusField.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent ae) {
		// 		if (rusField.getText().toLowerCase().equals(rus)) {
		// 			rusField.setForeground(Color.BLUE);
		// 		} else {
		// 			rusField.setForeground(Color.RED);
		// 		}
		// 	}
		// });

		showRightAnswersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				secondField.setText(second);
				thirdField.setText(third);
				if (secondTestResult == 0) {
					secondTestResult = -1;
				}
				if (thirdTestResult == 0) {
					thirdTestResult = -1;
				}
			}
		});
	}

	@Override
	public int getTestResult() {
		if (secondTestResult == -1 || thirdTestResult == -1) {
			return -1;
		}
		if (secondTestResult == 0 || thirdTestResult == 0) {
			return 0;
		}
		return 1;
	}

	@Override
	public void cleanTestResult() {
		secondField.setText("");
		thirdField.setText("");
		secondTestResult = 0;
		thirdTestResult = 0;
	}
}