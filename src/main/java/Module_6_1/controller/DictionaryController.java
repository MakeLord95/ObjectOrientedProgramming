package Module_6_1.controller;

import Module_6_1.model.Dictionary;
import Module_6_1.view.DictionaryView;

import java.util.Arrays;

public class DictionaryController {
    private final DictionaryView dictionaryView;
    private final Dictionary dictionary = new Dictionary();

    public DictionaryController(DictionaryView dictionaryView) {
        this.dictionaryView = dictionaryView;

        dictionary.addWord("Book", "A set of pages.");
        dictionary.addWord("Car", "A road vehicle.");
        dictionary.addWord("House", "A building for human habitation.");
        dictionary.addWord("Computer", "An electronic device.");
        dictionary.addWord("Phone", "A telephone.");
    }

    public static void main(String[] args) {
        DictionaryView.launch(DictionaryView.class);
    }

    public void addWordToDictionary() {
        try {
            String answer = Arrays.toString(dictionaryView.getTextInBoxes().split(","));

            String word = answer.split(",")[0].trim().replace("[", "");
            String meaning = answer.split(",")[1].trim().replace("]", "");

            dictionary.addWord(word, meaning);

        } catch (Exception e) {
            dictionaryView.illegalArgument();
        }
    }

    public String getWordMeaning(String word) {
        try {
            return dictionary.getMeaning(word);
        } catch (Exception e) {
            return "Empty field!";
        }
    }
}
