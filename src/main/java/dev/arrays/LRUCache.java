package main.java.dev.arrays;

import java.util.*;

public class LRUCache {
    private Map<Integer,Integer> map;

    public LRUCache(int capacity) {
        if(capacity<0){
            return;
        }
        this.map = new LinkedHashMap<>(capacity,0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>capacity;
            }
        };

    }

    public int get(int key) {
        return this.map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
    public static void main(String args[]){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
    }








//public class LRUCache {
//    private int capacity;
//    //    private ArrayDeque<Integer> q;
//    private Map<Integer, Integer> m = new HashMap<>();
//    private List<Integer> q =new LinkedList<>();
//
//    public LRUCache(int capacity) {
//        if(capacity<0){
//            return;
//        }
//        this.capacity=capacity;
////        this.q=new ArrayDeque<>(capacity);
//    }
//
//    public int get(int key) {
//        if(m.containsKey(key)){
//            q.remove(q.lastIndexOf(key));
//            q.addFirst(key);
//        }
//        return m.getOrDefault(key,-1);
//    }
//
//    public void put(int key, int value) {
//        if(m.containsKey(key)){
//            m.replace(key,value);
//            q.remove(key);
//            q.addFirst(key);
//        }
//        else{
//            if(q.size()==capacity){
//                m.remove(q.removeLast());
//            }
//            m.put(key,value);
//            q.addFirst(key);
//        }
//    }
//    public static void main(String args[]){
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        System.out.println(lRUCache.get(1));    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        System.out.println(lRUCache.get(2));    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        System.out.println(lRUCache.get(1));    // return -1 (not found)
//        System.out.println(lRUCache.get(3));    // return 3
//        System.out.println(lRUCache.get(4));    // return 4
//    }
//}
