package week1;

public class StackTest {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("h");
        stack.push("e");
        stack.push("l");
        stack.pop();
        stack.push("l");
        stack.push("o");
        stack.show();
    }
}
