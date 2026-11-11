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
