package week1;

public class ArrayStack implements Stack{
    String[] values = new String[1];
    int index = 0;
    public ArrayStack(){

    }
    @Override
    public void push(String e) {
    if(index == values.length-1) {
        String[] newValues = new String[values.length * 2];
        for (int i = 0; i < values.length; i++) {
            newValues[i]=values[i];
            values = newValues;
        }
    }
    index++;
    values[index]=e;
    }

    @Override
    public String pop() {
        return values[index--];
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
        for (int i = values.length-1; i >= 0; i--) {
            System.out.println(values[i]);
        }
    }
}
