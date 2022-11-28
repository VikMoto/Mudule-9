package MyHashMap;

import MyLinkedList.MyLinkedList;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap<K,V> {

    private final K key = null;
    private final V element = null;

    static class Node<K,V> {
        private K key;
        private V element;
        Node<K,V> next;
       // Node<T> prev;

        public Node(K key, V element, Node<K,V> next ) {
            this.key = key;
            this.element = element;
            this.next = next;
            //this.prev = prev;
        }
    }



    private Node<K,V> first = null;
    private Node<K,V> last = null;
    private int size;

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
        for (int i = 0; i < size; i++) {
            result.add(Objects.toString(node(i).key)).add(Objects.toString(node(i).element)).add(" ");
        }
        return "[" + result + "]";
    }


    private void linkedFirst(K key,V elem) {
        Node<K, V> f = first;
        Node<K, V> newNode = new Node<K, V>( key, elem, f);
        first = newNode;
        if(f == null) last = newNode;

        size++;
    }

    private void linkedLast(K k,V x) {
        Node<K, V> l = last;
        Node<K, V> newNode = new Node<K, V>(k, x, null);
        last = newNode;
        if(l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    void linkAfter(K key, V elem, Node<K, V> after) {
        Node<K, V> ff = after.next;
        Node<K, V> newNode = new Node<K, V>(key,elem,after.next);

        after.next = newNode;
        if (ff == null) first = newNode;

        size++;
    }

    private K unlinkFirst(Node<K, V> f) {
        final K key = f.key;
        final V element = f.element;
        final Node<K, V> next =  f.next;
        f.element = null;
        f.next = null;
        first = next;
        if (next == null) last = null;
        size--;
        return key;
    }

//    private K unlinkLast(Node<K, V> l) {
//        final K key = l.key;
//        final V element = l.element;
//        final Node<K, V> prev = l.prev;
//        l.element = null;
//        l.prev = null;
//        last = prev;
//
//        if(prev == null) first = null;
//        else prev.next = null;
//        size--;
//        return key;
//    }

    K unlink(@NotNull Node<K, V> x) {
        final K key = x.key;
        final V element = x.element;
        final Node<K, V> next = x.next;
        int index = getNodeIndex(key);
        final Node<K, V> prev = node(index-1);

        if (next == null) {
            last = prev;
        } else {
            x.next = null;
        }

        if(prev == null) {
            first = next;
        }else {
            prev.next = next;
        }

        x.element = null;
        size--;
        return key;
    }

    private int getNodeIndex(K key) {
        Node<K, V> x = first;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (x.key.equals(key)) { return index;}
            else {
                x = x.next;
                index++;
            }
        }
        return -1;

    }

    private V getElemByKey(K key) {
        Node<K, V> x = first;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (x.key.equals(key)) {
                return x.element;
            } else {
                x = x.next;
                index++;
            }
        }
        return null;
    }



    public void put(K key,V element) {
        if(!contains(key)) {
            linkedLast(key, element);
        } else {
            System.out.println("key exist" + "  key:" + key + " elem " + element );
        }

    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */

    public void put(int index, K key,V element) {
        if (index == size) {
            linkedLast(key,element);
        } else linkAfter(key,element,node(index));
    }


    Node<K,V> node(int index) {
        // assert isElementIndex(index);

        if (index >=0 && index < size ) {
            Node<K,V> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            throw new  IndexOutOfBoundsException();
        }
    }
    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */

    public void set(int index, K key,V element) {
        Objects.checkIndex(index,size-1);
        Node<K, V> node = node(index);
        node.key = key;
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


    public K getKeyByIndex(int index) {
        Objects.checkIndex(index,size);
        return node(index).key;
    }


    public K getKeyFirst() {
        return first.key;
    }


    public K getKeyLast() {
        return last.key;
    }

    public K remove(K key) {
        Node<K, V> x = first;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (x.key.equals(key)) {
                unlink(node(index));
                return x.key;
            } else {
                x = x.next;
                index++;
            }
        }
        return null;
    }




    public boolean contains(K key) {
       Node<K,V> current = first;
        for (int i = 0; i < size; i++) {
            if(current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;

    }


    public boolean isEmpty() {
        return first == null;

    }

    public int size() {
        return size;

    }

    public void clear() {
        first = last = null;
        size = 0;

    }

    public V get(K key) {
        return getElemByKey(key);
    }


}


