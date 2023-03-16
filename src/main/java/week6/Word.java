package week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Word implements IWord {
    private List<String> value;

    public Word(String s) throws NotWordException {
        if(!s.matches("[A-Za-z]+"))
            throw new NotWordException(s);
        value = Arrays.asList(s.split(""));
    }

    private Word(List<String> list) {
        value = list;
    }

    @Override
    public int size() {
        return value.size();
    }

    @Override
    public void printWord() {
        value.forEach(a->System.out.print(a));
        System.out.println();
    }

    @Override
    public IWord reverseWord() {
        List<String> tempValue = new ArrayList<>(value);
        Collections.reverse(tempValue);
        return new Word(tempValue);
    }

    @Override
    public boolean isPalindrome() {

        return this.reverseWord().equals(this);
    }



    public class NotWordException extends Exception {
        public NotWordException(String s){
            super("String " + s + " Is not a word");
        }

    }
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof IWord))
            return false;
        Word word = (Word)o;
        return word.value.equals(this.value);
    }

}
