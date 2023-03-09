package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintPalindromes {
    List<IWord> enteredWords = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        PrintPalindromes palindromes = new PrintPalindromes();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfWords = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfWords; i++) {
            Word nextWord;
            try {
                nextWord = new Word(br.readLine());
            } catch (Word.NotWordException e) {
                throw new RuntimeException(e);
            }
            palindromes.enteredWords.add(nextWord);
        }
        Palindrome.printPalindromes(palindromes.enteredWords);
    }

    static class Palindrome {
        public static void printPalindromes(List<IWord> words) {
            IWord.printWords(words, IWord::isPalindrome);
        }
    }

}
