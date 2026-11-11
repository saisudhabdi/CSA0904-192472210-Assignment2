
import java.util.*;

public class Main {

    static long testHashMap(int size) {
        Map<Integer, String> map = new HashMap<>();
        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            map.put(i, "Medicine" + i);
        }

        for (int i = 0; i < size; i++) {
            map.get(i);
        }

        return System.nanoTime() - start;
    }

    static long testTreeMap(int size) {
        Map<Integer, String> map = new TreeMap<>();
        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            map.put(i, "Medicine" + i);
        }

        for (int i = 0; i < size; i++) {
            map.get(i);
        }

        return System.nanoTime() - start;
    }

    static long testLinkedHashMap(int size) {
        Map<Integer, String> map = new LinkedHashMap<>();
        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            map.put(i, "Medicine" + i);
        }

        for (int i = 0; i < size; i++) {
            map.get(i);
        }

        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 100000};

        System.out.println("JAVA MAP PERFORMANCE COMPARISON");
        System.out.println("--------------------------------");

        for (int size : sizes) {

            long hashTime = 0;
            long treeTime = 0;
            long linkedTime = 0;

            for (int run = 0; run < 3; run++) {
                hashTime += testHashMap(size);
                treeTime += testTreeMap(size);
                linkedTime += testLinkedHashMap(size);
            }

            System.out.println("\nMedicine Records: " + size);
            System.out.println("HashMap Average: "
                    + hashTime / 3 + " ns");
            System.out.println("TreeMap Average: "
                    + treeTime / 3 + " ns");
            System.out.println("LinkedHashMap Average: "
                    + linkedTime / 3 + " ns");
        }

        System.out.println("\nITERATION ORDER TEST");

        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Integer, String> linkedMap = new LinkedHashMap<>();

        int[] keys = {30, 10, 20};

        for (int key : keys) {
            hashMap.put(key, "Medicine" + key);
            treeMap.put(key, "Medicine" + key);
            linkedMap.put(key, "Medicine" + key);
        }

        System.out.println("HashMap: " + hashMap.keySet());
        System.out.println("TreeMap: " + treeMap.keySet());
        System.out.println("LinkedHashMap: " + linkedMap.keySet());
    }
}
