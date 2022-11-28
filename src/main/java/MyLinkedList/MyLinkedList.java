package MyLinkedList;

import java.util.*;
import java.util.Objects;
import java.util.List;

public class MyLinkedList<T> {

    private final T element = null;

    static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> prev, T element, Node<T> next ) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }



    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
        for (int i = 0; i < size; i++) {
            result.add(Objects.toString(node(i).element));
        }
        return "[" + result + "]";
    }

//    public static <T> List<T> of(T... elements) {
//        MyLinkedList<T> linkedList = new MyLinkedList.Node<>();
//        for (T element : elements) {
//            linkedList.add(element);
//        }
//        return linkedList;
//        // throw new ExerciseNotCompletedException(); // todo: implement this method
//    }


    private void linkedFirst(T x) {
       Node<T> f = first;
       Node<T> newNode = new Node<>(null, x, f);
       first = newNode;
       if(f == null) {
           last = newNode;
       } else {
           f.prev = newNode;
       }
       size++;
    }

    private void linkedLast(T x) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, x, null);
        last = newNode;
        if(l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    void linkBefore(T elem,Node<T> before) {
        Node<T> pred = before.prev;
        Node<T> newNode = new Node<>(pred,elem,before);
        before.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private T unlinkFirst(Node<T> f) {
        final T element = f.element;
        final Node<T> next =  f.next;
        f.element = null;
        f.next = null;
        first = next;
        if (next == null) last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private T unlinkLast(Node<T> l) {
        final T element = l.element;
        final Node<T> prev = l.prev;
        l.element = null;
        l.prev = null;
        last = prev;

        if(prev == null) first = null;
        else prev.next = null;
        size--;
        return element;
    }

    T unlink(Node<T> x) {
        final T element = x.element;
        final Node<T> prev = x.prev;
        final Node<T> next = x.next;

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        if(prev == null) {
            first = next;
        }else {
            prev.next = next;
            x.prev = null;
        }

        x.element = null;
        size--;
        return element;
    }


    public void add(T element) {

        linkedLast(element);
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */

    public void add(int index, T element) {
        if (index == size) {
            linkedLast(element);
        } else linkBefore(element,node(index));
    }


    Node<T> node(int index) {
        // assert isElementIndex(index);

        if (index < size/2 ) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */

    public void set(int index, T element) {
        Objects.checkIndex(index,size-1);
        Node<T> node = node(index);
        node.element = element;

    }

//    private Node<T> getNodeByIndex(int index) {
//        Node<T> current = first;
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
//
//        return current;
//    }
    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */

    public T get(int index) {
        Objects.checkIndex(index,size);
        return node(index).element;
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */

    public T getFirst() {

            return first.element;

    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */

    public T getLast() {

            return last.element;

        //throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */

    public T remove(int index) {
        Objects.checkIndex(index,size);
        return unlink(node(index));
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */

    public boolean contains(T element) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if(current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;

    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */

    public boolean isEmpty() {
        return first == null;

    }



    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */

    public int size() {
        return size;

    }

    /**
     * Removes all list elements
     */

    public void clear() {
        first = last = null;
        size = 0;

    }
}

