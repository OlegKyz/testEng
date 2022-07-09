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

	private final int testsMaxCountInPage = 10;

	private Panel buttonsPanel;
	private Panel testsPanel;
	private CardLayout cardLayout;
	private Button nextButton, prevButton, finishButton;

	public TestWindow(String fileName) {
		//setLayout(new GridLayout(0, 1, 10, 10));
		setLayout(new FlowLayout());
		setSize(400, 500);

		initializeTestsPanel(fileName);
		initializeButtonsPanel();
		add(testsPanel);
		add(buttonsPanel);

		nextButton.addActionListener((ae) ->
			cardLayout.next(testsPanel));

		prevButton.addActionListener((ae) ->
			cardLayout.previous(testsPanel));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
			}
		});
	}

	private void initializeTestsPanel(String fileName) {
		cardLayout = new CardLayout();
		testsPanel = new Panel();
		testsPanel.setLayout(cardLayout);

		try {
			File testFile = new File(irregularTestPath + "\\" + fileName);
			BufferedReader reader = new BufferedReader(new FileReader(testFile));
			String line = reader.readLine();
			
			Panel currentPagePanel = new Panel();
			currentPagePanel.setLayout(new GridLayout(0, 1, 10, 10));
			int testsCountInCurrentPage = 0;
			while (line != null) {
				if (testsCountInCurrentPage >= testsMaxCountInPage) {
					testsPanel.add(currentPagePanel);
					currentPagePanel = new Panel();
					currentPagePanel.setLayout(new GridLayout(0, 1, 10, 10));
					testsCountInCurrentPage = 0;
				}
				String[] buf = line.split("@");
				TestVerbCase testCase = new TestVerbCase(buf[0], buf[1], buf[2]);
				currentPagePanel.add(testCase);
				++testsCountInCurrentPage;
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initializeButtonsPanel() {
		buttonsPanel = new Panel();
		buttonsPanel.setLayout(new FlowLayout());
		nextButton = new Button("Next");
		prevButton = new Button("Prev");
		finishButton = new Button("Finish");
		buttonsPanel.add(finishButton);
		buttonsPanel.add(prevButton);
		buttonsPanel.add(nextButton);
	}
}