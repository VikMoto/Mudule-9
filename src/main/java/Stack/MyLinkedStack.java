package Stack;


import MyLinkedList.MyLinkedList;

import java.util.EmptyStackException;

class MyLinkedStack<T> extends MyLinkedList {

    public T push(T item) {
        add(item);
        return item;
    }


    public synchronized T pop() {
        T       obj;
        int     len = size();

        obj = peek();
        remove(len - 1);

        return obj;
    }


    public synchronized T peek() {
        int     len = size();

        if (len == 0)
            throw new EmptyStackException();
        return (T) getLast();
    }


    public boolean empty() {
        return size() == 0;
    }



}
