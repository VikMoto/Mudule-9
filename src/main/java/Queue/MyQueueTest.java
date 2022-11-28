package Queue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.add("Hello");
        queue.add("Tark");
        queue.add("Nero");
        queue.add("Tell");
        queue.add("Kino");
        queue.add("Vise");
        queue.add("Bill");


        System.out.println("myQueue = " + queue);
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue = " + queue);
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue = " + queue);

    }
}
