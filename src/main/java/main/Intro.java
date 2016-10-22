package main;

import service.ParseSeviceImpl;
import service.ParseService;
import ui.MainFrame;

/**
 * Created by uukeshov on 20.10.2016.
 */
public class Intro {
    public static void main(String[] args) {
        ParseService parseService = new ParseSeviceImpl();
        parseService.parser("input.txt");
        parseService.parser("patterns.txt");
        MainFrame mainFrame = new MainFrame();
        mainFrame.showRadioButton();
        mainFrame.setVisible(true);
        mainFrame.buttonHandle();

    }
}
