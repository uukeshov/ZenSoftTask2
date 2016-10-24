package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uukeshov on 23.10.2016.
 */
public class ParsedDataSingleton {
    private List<String> inputData = new ArrayList<String>();
    private List<String> patternsData = new ArrayList<String>();
    private List<String> resultData = new ArrayList<String>();
    private static ParsedDataSingleton ourInstance = new ParsedDataSingleton();

    public static ParsedDataSingleton getInstance() {
        return ourInstance;
    }

    private ParsedDataSingleton() {
    }

    public List<String> getInputData() {
        return inputData;
    }

    public void setInputData(List<String> inputData) {
        this.inputData = inputData;
    }

    public List<String> getPatternsData() {
        return patternsData;
    }

    public void setPatternsData(List<String> patternsData) {
        this.patternsData = patternsData;
    }

    public List<String> getResultData() {
        return resultData;
    }

    public void setResultData(List<String> resultData) {
        this.resultData = resultData;
    }

    public void addPatternsData(String s) {
        patternsData.add(s);
    }

    public void addInputData(String s) {
        inputData.add(s);
    }

    public void addResultData(String s) {
        resultData.add(s);
    }

    @Override
    public String toString() {
        return "ParsedDataSingleton{" +
                "inputData=" + inputData +
                ", patternsData=" + patternsData +
                ", resultData=" + resultData +
                '}';
    }
}
