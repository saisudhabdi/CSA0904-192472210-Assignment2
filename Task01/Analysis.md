# Q1 – BUILDING TEXT UNDER LOAD: STRING, STRINGBUILDER OR STRINGBUFFER?

## 1. Problem Analysis

A railway reservation system generates e-tickets by combining different details such as PNR, passenger name, coach, berth, fare and journey information into a single printable text block.

Three Java approaches are considered: String, StringBuilder and StringBuffer. The objective is to investigate their performance under different workloads.

## 2. Objectives

- Compare String, StringBuilder and StringBuffer.
- Understand String immutability and object creation.
- Measure execution time for different workloads.
- Estimate intermediate String object creation.
- Compare memory usage.
- Identify the best approach for a multithreaded booking system.

## 3. Approaches Used

| Approach | Description |
|---|---|
| String | Uses the + operator to combine text. |
| StringBuilder | Uses append() to modify a mutable character sequence. |
| StringBuffer | Uses synchronised append() methods for thread safety. |

## 4. Initial Performance Prediction

| Approach | Expected Performance | Reason |
|---|---|---|
| String | Slower for repeated concatenation | Immutable objects create additional strings. |
| StringBuilder | Faster | Mutable and avoids repeated intermediate strings. |
| StringBuffer | Slightly slower than StringBuilder | Synchronisation adds overhead. |

## 5. Experimental Workloads

Three different workloads will be designed to compare performance.

| Workload | Number of Tickets | Fields per Ticket |
|---|---:|---:|
| Small | 100 | 6 |
| Medium | 10,000 | 50 |
| Large | 20,000 | 200 |

## 6. Measurements

The following measurements will be collected:

- Execution time using System.nanoTime().
- Average execution time across repeated runs.
- Estimated intermediate String objects created.
- Memory usage before and after execution.

## 7. Time and Space Complexity Analysis

| Approach | Expected Time Complexity | Additional Space |
|---|---|---|
| String concatenation | O(n²) character copying | Intermediate String objects |
| StringBuilder | O(n) amortised appending | Mutable character buffer |
| StringBuffer | O(n) amortised appending | Mutable synchronised buffer |

Here, n represents the total number of characters appended.

## 8. Design Decision

- String is suitable for fixed or small text values.
- StringBuilder is recommended for generating individual e-tickets.
- StringBuffer is suitable when multiple threads must safely modify the same shared text buffer.

For the multithreaded booking server, StringBuilder will be used for individual ticket generation, while StringBuffer can be considered for a shared booking log.

## 9. Conclusion

The experiment will determine how String, StringBuilder and StringBuffer behave under different workloads. The measured execution time and memory usage will be compared with the initial predictions to identify the most suitable approach for railway e-ticket generation.

## 10. Experimental Results

The three approaches were tested using small, medium and large workloads. Each execution time represents the average of three runs.

### Small Workload

| Approach | Average Time (ns) |
|---|---:|
| String | 778348 |
| StringBuilder | 422656 |
| StringBuffer | 444858 |

### Medium Workload

| Approach | Average Time (ns) |
|---|---:|
| String | 44158616 |
| StringBuilder | 19805076 |
| StringBuffer | 16897414 |

### Large Workload

| Approach | Average Time (ns) |
|---|---:|
| String | 198974037 |
| StringBuilder | 23192023 |
| StringBuffer | 27535692 |

## 11. Result Comparison

- In the small workload, StringBuilder recorded the lowest execution time.
- In the medium workload, StringBuffer recorded the lowest execution time.
- In the large workload, StringBuilder recorded the lowest execution time.
- String concatenation took considerably longer in the large workload.

The results show that repeated String concatenation becomes expensive as the workload increases.

## 12. Memory and Object Creation Analysis

The program also recorded approximate memory changes and estimated object creation.

The String approach creates intermediate String objects during repeated concatenation.

StringBuilder and StringBuffer create one mutable builder object per ticket in this implementation. Their internal buffers may expand as more characters are appended.

Memory measurements are approximate because JVM garbage collection and memory allocation can affect the results.

## 13. Alternative Concept Analysis

String.join() and StringJoiner can also combine multiple fields.

Example:

String ticket = String.join(" | ", pnr, passengerName, coach, berth, fare);

These approaches provide convenient ways to combine text.

String.format() can also format ticket information, but repeated formatting may introduce additional processing overhead.

For repeated construction of large tickets, StringBuilder remains a suitable choice.

## 14. Final Design Decision

- String is suitable for fixed or small text values.
- StringBuilder is recommended for constructing individual e-tickets because it is mutable and efficient.
- StringBuffer is appropriate when multiple threads need to modify the same shared text buffer.

For the railway booking system, StringBuilder will be used for individual ticket generation, while StringBuffer will be considered for a shared booking log.

## 15. Conclusion

The experiment demonstrated that the choice of string-handling class affects performance under different workloads.

StringBuilder performed well in the small and large workloads, while StringBuffer performed best in the medium workload.

The results support using mutable string classes instead of repeated String concatenation for large-scale ticket generation.
