package ru.kuznetsov.oleg;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App 
{
	private final static int mainWindowWidth = 400;
	private final static int mainWindowHeight = 400;

    public static void main( String[] args )
    {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setSize(mainWindowWidth, mainWindowHeight);
        mainWindow.setTitle("TestEng");
        mainWindow.setVisible(true);
    }
}

