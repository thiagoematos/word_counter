package matos.thiago.word_counter.model;

import java.util.Arrays;
import java.util.List;

public class Book {

    private List<Page> pages;

    public Book(Page... pages) {
        this.pages = Arrays.asList(pages);
    }

    public List<Page> getPages() {
        return pages;
    }

}
