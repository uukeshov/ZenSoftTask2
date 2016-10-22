package service;

import utils.ParsedDataSingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by uukeshov on 22.10.2016.
 */
public class ParseSeviceImpl implements ParseService {
    ParsedDataSingleton dataSingleton = ParsedDataSingleton.getInstance();

    public void parser(String fileName) {
        Scanner scanner = null;
        String nextToken;
        File file = new File(fileName);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            nextToken = scanner.nextLine();
            if (fileName == "input.txt") {
                dataSingleton.addInputData(nextToken);
            }
            if (fileName == "patterns.txt") {
                dataSingleton.addPatters(nextToken);
            }
        }
        scanner.close();
    }
}
