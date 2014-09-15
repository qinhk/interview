package hongke.interview.leetcode.questions;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by hongke on 9/15/14.
 */
public class LRUCache {

    Map<Integer, Integer> cache;
    final int capacity;


    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = cache.remove(key);
        if (result != null) {
            cache.put(key, result);
        }
        return result == null ? -1 : result;
    }


    public void set(int key, int value) {
        if (cache.size() >= capacity && !cache.containsKey(key)) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.remove(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache test = new LRUCache(1);
        test.set(2, 1);
        System.out.println(test.get(2));
        test.set(3, 2);
        System.out.println(test.get(2));
        System.out.println(test.get(3));

        System.out.println();
        test = new LRUCache(1);
        test.set(2, 1);
        test.set(2, 2);
        System.out.println(test.get(2));
        test.set(1, 1);
        test.set(4, 1);
        System.out.println(test.get(2));

        System.out.println();
        test = new LRUCache(2);
        System.out.println(test.get(2));
        test.set(2, 6);
        System.out.println(test.get(1));
        test.set(1, 5);
        test.set(1, 2);
        System.out.println(test.get(1));
        System.out.println(test.get(2));

        System.out.println();
        test = new LRUCache(2);
        test.set(2, 1);
        test.set(1, 1);
        test.set(2, 3);
        test.set(4, 1);
        System.out.println(test.get(1));
        System.out.println(test.get(2));

        //[get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)]
        //set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)
    }
}
