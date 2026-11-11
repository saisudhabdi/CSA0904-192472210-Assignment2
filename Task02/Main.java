import java.util.*;

public class Main {

    static volatile long result = 0;

    interface Test {
        long run(List<Integer> list, int operations);
    }

    static long measure(String name, List<Integer> original,
                        int operations, Test test) {

        long totalTime = 0;

        for (int r = 0; r < 3; r++) {

            List<Integer> copy = newList(name);

            copy.addAll(original);

            long start = System.nanoTime();

            result = test.run(copy, operations);

            long end = System.nanoTime();

            totalTime += end - start;
        }

        return totalTime / 3;
    }

    static List<Integer> newList(String name) {
        if (name.equals("ArrayList")) {
            return new ArrayList<>();
        }
        return new LinkedList<>();
    }

    static void benchmark(int size) {

        List<Integer> original = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            original.add(i);
        }

        int operations = 500;

        System.out.println("\nPLAYLIST SIZE: " + size);
        System.out.println("Collection,Operation,AverageTime(ns)");

        String[] names = {"ArrayList", "LinkedList"};

        for (String name : names) {

            List<Integer> list = newList(name);

            list.addAll(original);

            long addEnd = measure(name, original, operations,
                    (l, n) -> {
                        for (int i = 0; i < n; i++)
                            l.add(-1);
                        return l.size();
                    });

            long insertFront = measure(name, original, operations,
                    (l, n) -> {
                        for (int i = 0; i < n; i++)
                            l.add(0, -1);
                        return l.size();
                    });

            long insertMiddle = measure(name, original, operations,
                    (l, n) -> {
                        for (int i = 0; i < n; i++)
                            l.add(l.size() / 2, -1);
                        return l.size();
                    });

            long removeFront = measure(name, original, operations,
                    (l, n) -> {
                        for (int i = 0; i < n; i++)
                            l.remove(0);
                        return l.size();
                    });

            long removeMiddle = measure(name, original, operations,
                    (l, n) -> {
                        for (int i = 0; i < n; i++)
                            l.remove(l.size() / 2);
                        return l.size();
                    });

            long access = measure(name, original, operations,
                    (l, n) -> {
                        long sum = 0;
                        for (int i = 0; i < n; i++)
                            sum += l.get(l.size() / 2);
                        return sum;
                    });

            long iteration = measure(name, original, 1,
                    (l, n) -> {
                        long sum = 0;
                        for (int value : l)
                            sum += value;
                        return sum;
                    });

            System.out.println(name + ",Add End," + addEnd);
            System.out.println(name + ",Insert Front," + insertFront);
            System.out.println(name + ",Insert Middle," + insertMiddle);
            System.out.println(name + ",Remove Front," + removeFront);
            System.out.println(name + ",Remove Middle," + removeMiddle);
            System.out.println(name + ",Access Kth," + access);
            System.out.println(name + ",Full Iteration," + iteration);
        }
    }

    static void testArrayDeque() {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        long start = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            queue.addLast(i);
            queue.addFirst(-i);
            queue.removeFirst();
            queue.removeLast();
        }

        long end = System.nanoTime();

        System.out.println("\nARRAYDEQUE UP NEXT TEST");
        System.out.println("Operations: 40000");
        System.out.println("Time (ns): " + (end - start));
        System.out.println("Remaining Songs: " + queue.size());
    }

    public static void main(String[] args) {

        System.out.println("MUSIC PLAYLIST PERFORMANCE TEST");
        System.out.println("================================");

        benchmark(1000);
        benchmark(10000);
        benchmark(50000);

        testArrayDeque();

        System.out.println("\nEXPERIMENT COMPLETED");
    }
}
