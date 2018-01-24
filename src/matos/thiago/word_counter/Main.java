package matos.thiago.word_counter;

import matos.thiago.word_counter.model.Book;
import matos.thiago.word_counter.model.Page;

public class Main {

    public static void main(String[] args) {
        // Given
        Book cleanCode =
                new Book(new Page("Clean", "Code", "Legible", "Code"));
        String searchedWord = "Dirty";

        // When
        Long quantity = Counter.DECLARATIVE.method.apply(cleanCode, searchedWord);

        // Then
        System.out.printf("There is no occurrences of word %s: %b\n", searchedWord, (quantity == 0));

        // Given
        searchedWord = "Clean";
        quantity = Counter.DECLARATIVE.method.apply(cleanCode, searchedWord);

        // Then
        System.out.printf("There is one occurrences of word %s: %b\n", searchedWord, (quantity == 1));

        // Given
        searchedWord = "Code";
        quantity = Counter.IMPERATIVE.method.apply(cleanCode, searchedWord);

        // Then
        System.out.printf("There are two occurrences of word %s: %b\n", searchedWord, (quantity == 2));
    }

}
