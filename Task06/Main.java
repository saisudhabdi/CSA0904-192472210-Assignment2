
import java.util.*;

class Patient {
    String name;
    int severity;
    int arrivalOrder;

    Patient(String name, int severity, int arrivalOrder) {
        this.name = name;
        this.severity = severity;
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public String toString() {
        return name + " - Severity: " + severity
                + ", Arrival: " + arrivalOrder;
    }
}

public class Main {

    public static void main(String[] args) {

        Comparator<Patient> priority =
                Comparator.comparingInt((Patient p) -> p.severity)
                        .thenComparingInt(p -> p.arrivalOrder);

        PriorityQueue<Patient> triageQueue =
                new PriorityQueue<>(priority);

        triageQueue.add(new Patient("Arun", 3, 1));
        triageQueue.add(new Patient("Bala", 1, 2));
        triageQueue.add(new Patient("Kiran", 2, 3));
        triageQueue.add(new Patient("David", 1, 4));
        triageQueue.add(new Patient("Ravi", 4, 5));
        triageQueue.add(new Patient("John", 2, 6));
        triageQueue.add(new Patient("Sam", 5, 7));
        triageQueue.add(new Patient("Rahul", 3, 8));

        System.out.println("HOSPITAL TRIAGE SYSTEM");
        System.out.println("----------------------");
        System.out.println("Treatment Order:");

        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }

        System.out.println("\nPRIORITYQUEUE PERFORMANCE");
        System.out.println("-------------------------");

        int[] sizes = {1000, 10000, 100000};

        for (int size : sizes) {

            long totalTime = 0;

            for (int run = 0; run < 3; run++) {

                PriorityQueue<Patient> queue =
                        new PriorityQueue<>(priority);

                long start = System.nanoTime();

                for (int i = 0; i < size; i++) {
                    queue.add(new Patient(
                            "Patient" + i,
                            (i % 5) + 1,
                            i
                    ));
                }

                while (!queue.isEmpty()) {
                    queue.poll();
                }

                totalTime += System.nanoTime() - start;
            }

            System.out.println("Patients: " + size);
            System.out.println("Average time: "
                    + totalTime / 3 + " ns");
        }
    }
}
