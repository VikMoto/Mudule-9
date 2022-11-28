package MyArrLst;

import java.util.*;
import java.util.stream.Stream;

class MyArrayList<T>  {
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 5;
    private int size;

    /**
     * This constructor creates an instance of {@link MyArrayList} with a specific capacity of an array inside.
     *
     * @param initCapacity - the initial capacity of the list
     * @throws IllegalArgumentException – if the specified initial capacity is negative or 0.
     */
    public MyArrayList(int initCapacity) {
       if(initCapacity <= 0) {
           new IllegalArgumentException();
       }
       elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * This constructor creates an instance of {@link MyArrayList} with a default capacity of an array inside.
     * A default size of inner array is 5;
     */
    public MyArrayList() {

        this(DEFAULT_CAPACITY);
    }


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
        for (int i = 0; i < size; i++) {
            result.add(Objects.toString(get(i)));
        }
        return "[" + result + "]";
    }

    /**
     * Adds an element to the array.
     *
     * @param element element to add
     */
//    @Override
//    public void add(T element) {
//       resizeIdNeeded();
//       elements[size] = element;
//       size++;
//    }


    public boolean add(T element) {
        resizeIdNeeded();
        elements[size] = element;
        size++;
        return true;
    }



    private void resizeIdNeeded() {
       if (elements.length == size){
           Object[] newArr = new Object[elements.length*2];
           System.arraycopy(elements,0,newArr,0,size);
           elements = newArr;
       }
    }


    public void add(int index, T element) {

    }


    public T get(int index) {
       Objects.checkIndex(index,size);

        return (T) elements[index];
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
//    @Override
//    public T getFirst() {
//        if(isEmpty()) throw new NoSuchElementException();
//        return get(0);
//    }
//
//    /**
//     * Returns the last element of the list. Operation is performed in constant time O(1)
//     *
//     * @return the last element of the list
//     * @throws java.util.NoSuchElementException if list is empty
//     */
//    @Override
//    public T getLast() {
//       return elements[size-1];
//    }


    public T set(int index, T element) {

        return element;
    }


    public T remove(int index) {
        Objects.checkIndex(index,size);
        T removeElem = (T) elements[index];
        resizeIdNeeded();
        System.arraycopy(elements,index+1,elements,index,size-index-1);
        size--;
        return removeElem;
    }







//    @Override
//    public boolean contains(T element) {
//        boolean result = false;
//        for (Object val: elements) {
//            if(element.equals(val)) {
//                result = true;
//            }else {
//                result = false;
//            }
//        }
//        return result;
//    }


    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(Object o) {
        boolean result = false;
        for (Object elem: elements) {
            if(o.equals(elem)) {
                result = true;
            }else {
                result = false;
            }
        }
        return result;
    }








    /**
     * @return amount of saved elements
     */

    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */

    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> testList = new MyArrayList<Integer>(-5);
        testList.add(54);
        testList.add(12);
        testList.add(5467);
        testList.add(3333333);

        System.out.println("testList.size() = " + testList.size());
        System.out.println("testList = " + testList);

        testList.remove(2);
        System.out.println("-------------------------------------");
        System.out.println("testList = " + testList);
    }
}