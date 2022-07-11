package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;

public class TestVerbCase extends Panel {
	private static int textFieldLength = 15;

	private String first, second, third, rus;
	private Label firstLabel;
	private TextField secondField, thirdField;
	private TextField rusField;
	private Label rusLabel;

	public TestVerbCase(String first, String second, String third, String rus) {
		this.first = first.toLowerCase();
		this.second = second.toLowerCase();
		this.third = third.toLowerCase();
		this.rus = rus;
		firstLabel = new Label(first);
		secondField = new TextField(textFieldLength);
		thirdField = new TextField(textFieldLength);
		//rusField = new TextField(textFieldLength);
		rusLabel = new Label(rus);

		setLayout(new FlowLayout());
		add(firstLabel);
		add(secondField);
		add(thirdField);
		add(rusLabel);

		secondField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (secondField.getText().toLowerCase().equals(second)) {
					secondField.setForeground(Color.BLUE);
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
	}
}