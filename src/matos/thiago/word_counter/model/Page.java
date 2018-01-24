package matos.thiago.word_counter.model;

import java.util.Arrays;
import java.util.List;

public class Page {

    private List<String> words;

    public Page(String... words) {
        this.words = Arrays.asList(words);
    }

    public List<String> getWords() {
        return words;
    }

}
