
import java.util.*;

class Patient {
    String name;
    int severity;
    int arrivalOrder;
    int arrivalTime;

    Patient(String name, int severity, int arrivalOrder) {
        this.name = name;
        this.severity = severity;
        this.arrivalOrder = arrivalOrder;
        this.arrivalTime = 0;
    }
}

public class Main {

    static List<Patient> createPatients() {
        List<Patient> patients = new ArrayList<>();

        patients.add(new Patient("Arun", 5, 1));
        patients.add(new Patient("Bala", 1, 2));
        patients.add(new Patient("Kiran", 4, 3));
        patients.add(new Patient("David", 2, 4));
        patients.add(new Patient("Ravi", 5, 5));
        patients.add(new Patient("John", 3, 6));
        patients.add(new Patient("Sam", 1, 7));
        patients.add(new Patient("Rahul", 4, 8));

        return patients;
    }

    static void runOriginal() {
        PriorityQueue<Patient> queue =
            new PriorityQueue<>(
                Comparator.comparingInt((Patient p) -> p.severity)
                    .thenComparingInt(p -> p.arrivalOrder)
            );

        queue.addAll(createPatients());

        System.out.println("ORIGINAL TRIAGE SYSTEM");
        System.out.println("----------------------");

        int currentTime = 0;
        int totalWaiting = 0;

        while (!queue.isEmpty()) {
            Patient p = queue.poll();

            int waitingTime = currentTime - p.arrivalTime;
            totalWaiting += waitingTime;

            System.out.println(p.name
                + " | Severity: " + p.severity
                + " | Waiting: " + waitingTime);

            currentTime++;
        }

        System.out.println("Average waiting time: "
            + (double) totalWaiting / 8);
    }

    static void runRedesigned() {
        List<Patient> waitingPatients = createPatients();

        System.out.println("\nREDESIGNED TRIAGE SYSTEM");
        System.out.println("------------------------");

        int currentTime = 0;
        int totalWaiting = 0;

        while (!waitingPatients.isEmpty()) {

            PriorityQueue<Patient> queue =
                new PriorityQueue<>((p1, p2) -> {

                    int wait1 = currentTimeValue - p1.arrivalTime;
                    int wait2 = currentTimeValue - p2.arrivalTime;

                    // Critical emergencies always come first.
                    boolean critical1 = p1.severity == 1;
                    boolean critical2 = p2.severity == 1;

                    if (critical1 != critical2) {
                        return critical1 ? -1 : 1;
                    }

                    int effective1 = Math.max(
                        1, p1.severity - wait1 / 2);

                    int effective2 = Math.max(
                        1, p2.severity - wait2 / 2);

                    int result = Integer.compare(
                        effective1, effective2);

                    if (result == 0) {
                        result = Integer.compare(
                            p1.arrivalOrder, p2.arrivalOrder);
                    }

                    return result;
                });

            queue.addAll(waitingPatients);

            Patient selected = queue.poll();

            int waitingTime = currentTime - selected.arrivalTime;
            totalWaiting += waitingTime;

            System.out.println(selected.name
                + " | Severity: " + selected.severity
                + " | Waiting: " + waitingTime);

            waitingPatients.remove(selected);
            currentTime++;
            currentTimeValue = currentTime;
        }

        System.out.println("Average waiting time: "
            + (double) totalWaiting / 8);
    }

    static int currentTimeValue = 0;

    public static void main(String[] args) {
        runOriginal();
        runRedesigned();
    }
}
