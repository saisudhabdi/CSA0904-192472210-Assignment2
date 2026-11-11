# Task 04 – Map Implementations

## 1. Problem Analysis

Java provides different Map implementations to store data as key-value pairs.

HashMap, TreeMap and LinkedHashMap provide different ordering and performance characteristics.

This experiment compares their insertion, lookup and iteration operations using medicine inventory data.

## 2. Objectives

- Understand Java Map implementations.
- Compare HashMap, TreeMap and LinkedHashMap.
- Measure insertion and lookup performance.
- Examine iteration order.
- Identify the most suitable Map implementation for medicine inventory.

## 3. Map Implementations Used

### HashMap
- Stores key-value pairs.
- Does not guarantee iteration order.
- Provides average O(1) insertion and lookup.

### TreeMap
- Stores keys in sorted order.
- Provides O(log n) insertion and lookup.
- Useful when sorted reports are required.

### LinkedHashMap
- Maintains insertion order.
- Provides average O(1) insertion and lookup.
- Useful when the original insertion order must be preserved.

## 4. Experimental Workloads

Three medicine inventory sizes are used:

- Small: 1,000 medicines
- Medium: 10,000 medicines
- Large: 100,000 medicines

## 5. Performance Prediction

HashMap is expected to provide faster average insertion and lookup.

TreeMap may require more time because it maintains sorted keys.

LinkedHashMap maintains insertion order with some additional memory overhead.

## 6. Operations Compared

- Inserting medicine records.
- Searching medicine records by ID.
- Iterating through all medicine records.
- Generating reports in different key orders.

## 7. Ordering Comparison

| Map | Iteration Order |
|---|---|
| HashMap | No guaranteed order |
| TreeMap | Sorted key order |
| LinkedHashMap | Insertion order |

## 8. Alternative Approach

A sorted array with binary search can also support medicine lookup.

Binary search takes O(log n) time, but inserting new records into a sorted array may require O(n) shifting.

## 9. Conclusion

The experiment compares the performance and ordering behaviour of HashMap, TreeMap and LinkedHashMap to identify a suitable data structure for medicine inventory management.

## 10. Experimental Results

The program tested three Map implementations using 1,000, 10,000 and 100,000 medicine records.

### Performance Comparison

| Records | HashMap | TreeMap | LinkedHashMap |
|---|---|---|---|
| 1,000 | Actual result | Actual result | Actual result |
| 10,000 | Actual result | Actual result | Actual result |
| 100,000 | Actual result | Actual result | Actual result |

Replace the values with the average execution times from the Java program.

### Iteration Order Results

- HashMap: No guaranteed ordering.
- TreeMap: Keys are displayed in sorted order.
- LinkedHashMap: Keys are displayed in insertion order.

## 11. Performance Analysis

- HashMap is suitable for fast average insertion and lookup.
- TreeMap is useful when sorted medicine reports are required.
- LinkedHashMap is useful when insertion order must be maintained.
- The actual execution times may vary depending on the computer and runtime environment.

## 12. Final Design Decision

HashMap is selected for general medicine inventory storage because it provides efficient average lookup and insertion.

TreeMap is suitable for sorted reports, while LinkedHashMap is suitable for maintaining insertion order.

## 13. Conclusion

The experiment demonstrates that different Map implementations have different ordering and performance characteristics. The appropriate implementation should be selected according to application requirements.
