package MyHashMap;

import java.util.HashMap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String,String> hsMap = new MyHashMap<String, String>();

        hsMap.put("set","geros");
        hsMap.put("set2","geros");
        hsMap.put("set3","Budda");
        hsMap.put("int1","geros");
        hsMap.put("int2","geros");
        hsMap.put("int3","geros");
        hsMap.put("set4","geros");


        System.out.println("hsMap = " + hsMap);
        hsMap.put("set3","geros");
        System.out.println("hsMap.remove(\"int2\") = " + hsMap.remove("int2"));
        System.out.println("hsMap = " + hsMap);
        System.out.println("hsMap.get(\"set3\") = " + hsMap.get("set3"));

    }
}
