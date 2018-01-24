package matos.thiago.word_counter;

import matos.thiago.word_counter.model.Book;
import matos.thiago.word_counter.model.Page;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

public enum Counter {

    // In a page, I have to compare word by word, and decide if it is equals to the searched word.
    // In each page, I have to know how many occurrences are the searched word.
    // I have to count the occurrences of all pages.

    IMPERATIVE((book, searchedWord) -> {
        long total = 0;
        for (Page page : book.getPages()) {
            for (String words : page.getWords()) {
                if (words.equals(searchedWord)) {
                    total++;
                }
            }
        }
        return total;
    }),

    DECLARATIVE((book, searchedWord) -> {
        final Predicate<String> searchedWords = givenWord -> givenWord.equalsIgnoreCase(searchedWord);

        final ToLongFunction<Page> occurrencesInPage = givenPage -> givenPage
                .getWords()
                .stream()
                .filter(searchedWords)
                .count();

        return book
                .getPages()
                .stream()
                .mapToLong(occurrencesInPage)
                .sum();
    });

    public BiFunction<Book, String, Long> method;

    Counter(BiFunction<Book, String, Long> method) {
        this.method = method;
    }

}
