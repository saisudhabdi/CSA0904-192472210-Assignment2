
import java.util.*;

class Patient {
    String name;
    int severity;
    int arrivalOrder;
    int arrivalTime;

    Patient(String name, int severity, int order, int time) {
        this.name = name;
        this.severity = severity;
        this.arrivalOrder = order;
        this.arrivalTime = time;
    }
}

public class Main {

    static List<Patient> createPatients() {
        List<Patient> patients = new ArrayList<>();

        patients.add(new Patient("Ari", 5, 1, 0));
        patients.add(new Patient("Bea", 5, 2, 0));
        patients.add(new Patient("Chen", 4, 3, 0));
        patients.add(new Patient("Dina", 2, 4, 0));
        patients.add(new Patient("Evan", 2, 5, 1));
        patients.add(new Patient("Farah", 2, 6, 2));
        patients.add(new Patient("Gopal", 2, 7, 3));
        patients.add(new Patient("Hari", 2, 8, 4));
        patients.add(new Patient("Isha", 2, 9, 5));
        patients.add(new Patient("Emergency", 1, 10, 3));

        return patients;
    }

    static void runSystem(boolean aging) {

        List<Patient> waiting = createPatients();
        List<Patient> available = new ArrayList<>();

        int time = 0;
        int totalWaiting = 0;
        int maximumWaiting = 0;

        System.out.println(aging
            ? "\nREDESIGNED TRIAGE SYSTEM"
            : "ORIGINAL TRIAGE SYSTEM");

        System.out.println("-------------------------");

        while (!waiting.isEmpty() || !available.isEmpty()) {

            for (int i = waiting.size() - 1; i >= 0; i--) {
                Patient p = waiting.get(i);

                if (p.arrivalTime <= time) {
                    available.add(p);
                    waiting.remove(i);
                }
            }

            if (available.isEmpty()) {
                time++;
                continue;
            }

            final int currentTime = time;

            available.sort((p1, p2) -> {

                // Critical patients always receive first priority.
                if (p1.severity == 1 && p2.severity != 1)
                    return -1;

                if (p2.severity == 1 && p1.severity != 1)
                    return 1;

                int priority1 = p1.severity;
                int priority2 = p2.severity;

                if (aging) {
                    int wait1 = currentTime - p1.arrivalTime;
                    int wait2 = currentTime - p2.arrivalTime;

                    priority1 = Math.max(2,
                        p1.severity - wait1 / 2);

                    priority2 = Math.max(2,
                        p2.severity - wait2 / 2);
                }

                int result = Integer.compare(priority1, priority2);

                if (result == 0) {
                    result = Integer.compare(
                        p1.arrivalOrder, p2.arrivalOrder);
                }

                return result;
            });

            Patient selected = available.remove(0);

            int patientWaiting = time - selected.arrivalTime;

            totalWaiting += patientWaiting;
            maximumWaiting = Math.max(
                maximumWaiting, patientWaiting);

            System.out.println(selected.name
                + " | Severity: " + selected.severity
                + " | Waiting: " + patientWaiting);

            time++;
        }

        System.out.println("Average waiting time: "
            + (double) totalWaiting / 10);

        System.out.println("Maximum waiting time: "
            + maximumWaiting);
    }

    public static void main(String[] args) {
        runSystem(false);
        runSystem(true);
    }
}
