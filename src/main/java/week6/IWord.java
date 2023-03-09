package week6;

import java.util.List;
import java.util.function.Predicate;

public interface IWord {
    static void printWords(List<IWord> words, Predicate<IWord> predicate) {
        words.forEach(word -> {
            if (predicate.test(word)) word.printWord();
        });
    }

    int size();

    void printWord();

    IWord reverseWord();

    boolean isPalindrome();
}

// print using forEach method on words
