package week1;

public interface Stack<E> {
    void push(E e);
    E pop();
    boolean isEmpty();
    boolean isFull();
    void show();
}
