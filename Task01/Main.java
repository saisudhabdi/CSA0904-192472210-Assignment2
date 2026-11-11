public class Main {
    interface BuilderTask {
        long execute(int tickets, String[] fields);
    }static long buildUsingString(int tickets, String[] fields) {
        long total = 0;
        for (int i = 0; i < tickets; i++) {
            String ticket = "";
            for (String field : fields) {
                ticket = ticket + field;
            }total += ticket.length();
        }return total;
    }static long buildUsingStringBuilder(int tickets, String[] fields) {
        long total = 0;
        for (int i = 0; i < tickets; i++) {
            StringBuilder ticket = new StringBuilder();
            for (String field : fields) {
                ticket.append(field);
            }total += ticket.length();
        } return total;
    } static long buildUsingStringBuffer(int tickets, String[] fields) {
        long total = 0;
        for (int i = 0; i < tickets; i++) {
            StringBuffer ticket = new StringBuffer();
            for (String field : fields) {
                ticket.append(field);}
            total += ticket.length();
        }return total;
    }static void measure(String name, BuilderTask task,
                        int tickets, String[] fields) {
                            long totalTime = 0;
        long totalMemory = 0;
        long checksum = 0;
        int repetitions = 3;
        for (int r = 0; r < repetitions; r++) {
            System.gc();
            Runtime runtime = Runtime.getRuntime();
            long beforeMemory = runtime.totalMemory()
                    - runtime.freeMemory();
            long start = System.nanoTime();
            checksum = task.execute(tickets, fields);
            long end = System.nanoTime();
            long afterMemory = runtime.totalMemory()
                    - runtime.freeMemory();
            totalTime += (end - start);
            totalMemory += (afterMemory - beforeMemory);
        }long averageTime = totalTime / repetitions;
        long averageMemory = totalMemory / repetitions;
        long estimatedObjects;
        if (name.equals("String")) {
            estimatedObjects = (long) tickets * fields.length;
        } else {
            estimatedObjects = (long) tickets * 2;
        }System.out.println(name + "," + tickets + ","
                + fields.length + "," + averageTime + ","
                + averageMemory + "," + estimatedObjects
                + "," + checksum);
    }static void runWorkload(String name, int tickets, int fieldCount) {
        String[] fields = new String[fieldCount];
        for (int i = 0; i < fieldCount; i++) {
            fields[i] = "Field" + i + "|";
        }System.out.println("\nWORKLOAD: " + name);
        System.out.println("Approach,Tickets,Fields,AverageTime(ns),"
                + "MemoryChange(bytes),EstimatedObjects,Checksum");
        measure("String", Main::buildUsingString,
                tickets, fields);
        measure("StringBuilder", Main::buildUsingStringBuilder,
                tickets, fields);
        measure("StringBuffer", Main::buildUsingStringBuffer,
                tickets, fields);
    }public static void main(String[] args) {
        System.out.println("RAILWAY E-TICKET PERFORMANCE TEST");
        System.out.println("=================================");
        runWorkload("Small", 100, 6);
        runWorkload("Medium", 10000, 50);
        runWorkload("Large", 20000, 200);
        System.out.println("\nEXPERIMENT COMPLETED");
    }
}
