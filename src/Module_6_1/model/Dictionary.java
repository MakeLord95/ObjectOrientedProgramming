package Module_6_1.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    /*
     * Adds a word to the dictionary
     */
    public void addWord(String word, String meaning) {
        if (word.isEmpty() || meaning.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            dictionary.put(word.toLowerCase(), meaning.toLowerCase());
        }
    }

    /*
     * Gets the meaning of a word
     */
    public String getMeaning(String word) {
        String meaning = dictionary.get(word.toLowerCase());

        if (meaning != null) {
            return String.format("%s", dictionary.get(word));
        } else if (word.isEmpty()) {
            throw new NullPointerException();
        } else {
            return String.format("%s is not in the dictionary", word);
        }
    }
}
