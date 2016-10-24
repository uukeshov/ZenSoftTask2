package service;

import utils.Constants;
import utils.ParsedDataSingleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by uukeshov on 22.10.2016.
 */
public class ParseSeviceImpl implements ParseService {
    ParsedDataSingleton dataSingleton = ParsedDataSingleton.getInstance();

    public void parser(String fileName) {

        StringBuilder sb = new StringBuilder();
        try {
            URL url = getClass().getResource(fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                if (fileName == Constants.inputFileName) {
                    dataSingleton.addInputData(line);
                }

                if (fileName == Constants.patternFileName) {
                    dataSingleton.addPatternsData(line);
                }
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(sb.toString());
    }
}