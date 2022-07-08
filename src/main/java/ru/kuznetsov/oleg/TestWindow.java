package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestWindow extends Frame {
	private final static String irregularTestPath = 
		"src\\main\\resources\\irregularVerbs";

	public TestWindow(String fileName) {
		setLayout(new GridLayout(0, 1, 10, 10));
		setSize(400, 400);
		//System.out.println(irregularTestPath + "\\" + fileName);
		try {
			File testFile = new File(irregularTestPath + "\\" + fileName);
			BufferedReader reader = new BufferedReader(new FileReader(testFile));
			String line = reader.readLine();
			int i = 0;
			while (line != null) {
				String[] buf = line.split("@");
				//System.out.println(buf[0] + " " + buf[1] + " " + buf[2]);
				TestVerbCase testCase = new TestVerbCase(buf[0], buf[1], buf[2]);
				add(testCase);
				line = reader.readLine();
				++i;
				if (i >= 10) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
			}
		});
	}
}