package main;

import service.ParseService;
import service.ParseSeviceImpl;
import ui.MainFrame;
import utils.Constants;

/**
 * Created by uukeshov on 20.10.2016.
 */
public class Intro {
    public static void main(String[] args) {
         ParseService parseService = new ParseSeviceImpl();
         parseService.parser(Constants.inputFileName);
         parseService.parser(Constants.patternFileName);
         MainFrame mainFrame = new MainFrame();
         mainFrame.showRadioButton();
         mainFrame.setVisible(true);
         mainFrame.buttonHandle();
     }
}
