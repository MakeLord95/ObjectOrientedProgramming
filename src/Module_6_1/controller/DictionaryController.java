package Module_6_1.controller;

import Module_6_1.model.Dictionary;
import Module_6_1.view.DictionaryView;

import java.util.Arrays;

public class DictionaryController {
    private final DictionaryView dictionaryView;
    private final Dictionary dictionary = new Dictionary();

    /*
     * Initializes the controller
     */
    public DictionaryController(DictionaryView dictionaryView) {
        this.dictionaryView = dictionaryView;

        /*
         * Adding some words to the dictionary
         */
        dictionary.addWord("Test", "Works");
        dictionary.addWord("Hello", "World");
    }

    /*
     * Launches the application
     */
    public static void main(String[] args) {
        DictionaryView.launch(DictionaryView.class);
    }

    /*
     * Adds a word to the dictionary
     */
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

    /*
     * Gets the meaning of a word
     */
    public String getWordMeaning(String word) {
        try {
            return dictionary.getMeaning(word);
        } catch (Exception e) {
            return "Empty field!";
        }
    }

    public void getDictionary() {
        for (int i = 0; i < dictionary.getDictionary().size(); i++) {
            System.out.printf("%s, %s\n", dictionary.getDictionary().keySet().toArray()[i], dictionary.getDictionary().values().toArray()[i]);
        }
    }
}
