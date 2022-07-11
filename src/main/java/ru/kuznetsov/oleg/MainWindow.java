package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainWindow extends Frame {
	private final static String irregularTestPath = 
		"src\\main\\resources\\irregularVerbs";
	private final static String wordsTestPath = 
		"src\\main\\resources\\words";

	Panel testsPanel;
	CardLayout cardL;
	Button irregularVerbsButton, wordsButton;
	TestManager[] irregularVerbsTestsManagers;
	TestManager[] wordsTestsManagers;
	TestWindow irregularVerbsTestsWindow;

	public MainWindow() {
		setLayout(new FlowLayout());
		irregularVerbsButton = new Button("Irregular verbs");
		wordsButton = new Button("Words");
		add(irregularVerbsButton);
		add(wordsButton);

		cardL = new CardLayout();
		testsPanel = new Panel();
		testsPanel.setLayout(cardL);

		Panel irregularVerbsPanel = new Panel();
		irregularVerbsPanel.setLayout(new GridLayout(0, 5, 10, 10));
		File irregularVerbsTestsDir = new File(irregularTestPath);
		String[] irregularVerbsTestsFilesNames = irregularVerbsTestsDir.list();
		int irregularVerbsTestsCount = irregularVerbsTestsFilesNames.length;
		irregularVerbsTestsManagers = new TestManager[irregularVerbsTestsCount];
		for (int i = 0; i < irregularVerbsTestsCount; ++i) {	
			irregularVerbsTestsManagers[i] = 
				new TestManager(irregularTestPath, irregularVerbsTestsFilesNames[i], false);
			irregularVerbsPanel.add(irregularVerbsTestsManagers[i]);
		}

		Panel wordsPanel = new Panel();
		wordsPanel.setLayout(new GridLayout(0, 5, 10, 10));
		File wordsTestsDir = new File(wordsTestPath);
		String[] wordsTestsFilesNames = wordsTestsDir.list();
		int wordsTestsCount = wordsTestsFilesNames.length;
		wordsTestsManagers = new TestManager[wordsTestsCount];
		for (int i = 0; i < wordsTestsCount; ++i) {
			wordsTestsManagers[i] = 
				new TestManager(wordsTestPath, wordsTestsFilesNames[i], true);
			wordsPanel.add(wordsTestsManagers[i]);
		}

		testsPanel.add(wordsPanel, "Words");
		testsPanel.add(irregularVerbsPanel, "Irregular Verbs");
		

		add(testsPanel);

		irregularVerbsButton.addActionListener((ae) ->
			cardL.show(testsPanel, "Irregular Verbs"));

		wordsButton.addActionListener((ae) ->
			cardL.show(testsPanel, "Words"));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	private void printTestFiles(File testDir) {
		try {
			File[] irregularVerbsTestFiles = 
				testDir.listFiles();
			for (File buf : irregularVerbsTestFiles) {
				System.out.println(buf.getName());
				BufferedReader reader = 
					new BufferedReader(new FileReader(buf));
				String line = reader.readLine();
				while (line != null) {
					System.out.println("----" + line);
					line = reader.readLine();
				}
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}