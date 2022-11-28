package Queue;


import MyLinkedList.MyLinkedList;

class MyQueue<T> extends MyLinkedList {

    public T peek() {
       return (T) getFirst();
    }

    public T poll() {
        return (T) remove(0);
    }

}
