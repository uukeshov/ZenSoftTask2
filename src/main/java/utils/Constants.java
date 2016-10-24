package utils;

/**
 * Created by uukeshov on 24.10.2016.
 */
public class Constants {
    public static final String inputFileName = "/files/input.txt";
    public static final String patternFileName = "/files/patterns.txt";

    public static String replacer(String string){
         return string.replaceAll("\\[|\\]", "");
    }
}
