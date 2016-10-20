import info.debatty.java.stringsimilarity.Levenshtein;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by uukeshov on 20.10.2016.
 */
public class Intro {
    private static List<String> inputList = new ArrayList<String>();
    private static List<String> patternList = new ArrayList<String>();
    private static List<String> resultList = new ArrayList<String>();

    public static void main(String[] args) {
        parseFile("input.txt");
        parseFile("patterns.txt");
        modContains();
        modEqual();
        modDefinedEditDistance();
    }

    private static void parseFile(String fileName) {
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
                inputList.add(nextToken);
            }
            if (fileName == "patterns.txt") {
                patternList.add(nextToken);
            }
        }
        scanner.close();
    }

    private static void modEqual() {
        resultList.clear();
        for (int i = 0; i < inputList.size(); i++) {
            for (int k = 0; k < patternList.size(); k++) {
                if (inputList.get(i).equals(patternList.get(k))) {
                    resultList.add(inputList.get(i));
                }
            }
        }
        print(resultList);
    }

    private static void modContains() {
        resultList.clear();
        for (int i = 0; i < inputList.size(); i++) {
            for (int k = 0; k < patternList.size(); k++) {
                if (inputList.get(i).contains(patternList.get(k))) {
                    resultList.add(inputList.get(i));
                }
            }
        }
        print(resultList);
    }

    private static void modDefinedEditDistance() {
        resultList.clear();
        for (int i = 0; i < inputList.size(); i++) {
            for (int k = 0; k < patternList.size(); k++) {
                double editDistance = new Levenshtein().distance(inputList.get(i), patternList.get(k));
                if (editDistance == 1 || editDistance == 0) {
                    resultList.add(inputList.get(i));
                }
            }
        }
        print(resultList);
    }

    private static void print(List list) {
        System.out.println(list.toString());
        System.out.println("***************");
    }
}
