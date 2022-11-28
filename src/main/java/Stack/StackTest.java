package Stack;

public class StackTest {
    public static void main(String[] args) {
        MyLinkedStack<String> stack = new MyLinkedStack<>();
        //Stack<String> stSTand = new Stack<>();
         stack.push("Read");
        stack.push("Buy");
        stack.push("Say");
        stack.push("Good");
        stack.push("Sold");
        System.out.println("stack = " + stack);
        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);
        System.out.println("stack.size() = " + stack.size());

    }
}
