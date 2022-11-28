package MyLinkedList;



public class MyLikedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> newList = new MyLinkedList<String>();
        newList.add("Hello");
        newList.add("Frank");
        newList.add("buy");
        newList.add("Ser");
        System.out.println("newList = " + newList);
        System.out.println("newList.size() = " + newList.size());
        System.out.println("newList.get(3) = " + newList.get(3));
        System.out.println("newList.remove(2) = " + newList.remove(2));
        System.out.println("newList = " + newList);
        newList.clear();
        System.out.println("newList = " + newList);


    }
}
