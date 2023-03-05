package week1;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E>{
    Object[] values = new Object[1];
    int index = 0;
    public ArrayStack(){

    }

    @Override
    public void push(E e) {
        if(index == values.length-1) {
            Object[] newValues = new Object[values.length * 2];
            for (int i = 0; i < values.length; i++) {
                newValues[i]=values[i];
            }
            values = newValues;
        }
        values[index]=e;
        index++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        return (E)values[index--];
    }

    @Override
    public boolean isEmpty() {
        return index ==0;
    }

    @Override
    public boolean isFull() {
        return values.length-1 == index;
    }

    @Override
    public void show() {
        for (int i = index-1; i >= 0; i--) {
            System.out.println(values[i]);
        }
    }
}
