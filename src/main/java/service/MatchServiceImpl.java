package service;

import info.debatty.java.stringsimilarity.Levenshtein;
import utils.ParsedDataSingleton;

/**
 * Created by uukeshov on 23.10.2016.
 */
public class MatchServiceImpl implements MatchService {
    private ParsedDataSingleton PDS = ParsedDataSingleton.getInstance();

    public void containsMod() {
        PDS.getResultData().clear();
        for (int i = 0; i < PDS.getInputData().size(); i++) {
            for (int k = 0; k < PDS.getPatternsData().size(); k++) {
                if (PDS.getInputData().get(i).contains(PDS.getPatternsData().get(k))) {
                    PDS.addResultData(PDS.getInputData().get(i));
                }
            }
        }
    }

    public void EqualMod() {
        PDS.getResultData().clear();
        for (int i = 0; i < PDS.getInputData().size(); i++) {
            for (int k = 0; k < PDS.getPatternsData().size(); k++) {
                if (PDS.getInputData().get(i).equals(PDS.getPatternsData().get(k))) {
                    PDS.addResultData(PDS.getInputData().get(i));
                }
            }
        }
    }

    public void DefinedEditDistanceMod() {
        PDS.getResultData().clear();
        for (int i = 0; i < PDS.getInputData().size(); i++) {
            for (int k = 0; k < PDS.getPatternsData().size(); k++) {
                double editDistance = new Levenshtein().distance(PDS.getInputData().get(i), PDS.getPatternsData().get(k));
                if (editDistance == 1 || editDistance == 0) {
                    PDS.addResultData(PDS.getInputData().get(i));
                }
            }
        }
    }
}
