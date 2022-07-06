package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;

public class TestVerbCase extends Panel {
	private static int textFieldLength = 15;

	private String first, second, third;
	private Label firstLabel;
	private TextField secondField, thirdField;

	//private Panel testPanel;

	public TestVerbCase(String first, String second, String third) {
		this.first = first.toLowerCase();
		this.second = second.toLowerCase();
		this.third = third.toLowerCase();
		firstLabel = new Label(first);
		secondField = new TextField(textFieldLength);
		thirdField = new TextField(textFieldLength);
		//testPanel = new Panel();

		// testPanel.setLayout(new FlowLayout());
		// testPanel.add(firstLabel);
		// testPanel.add(secondField);
		// testPanel.add(thirdField);

		setLayout(new FlowLayout());
		add(firstLabel);
		add(secondField);
		add(thirdField);

		secondField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (secondField.getText().toLowerCase().equals(second)) {
					secondField.setText("True");
				} else {
					secondField.setText("False");
				}
			}
		});

		thirdField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (thirdField.getText().toLowerCase().equals(third)) {
					thirdField.setText("True");
				} else {
					thirdField.setText("False");
				}
			}
		});
	}

	// public Panel getTestPanel() {
	// 	return testPanel;
	// }
}