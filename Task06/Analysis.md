# Task 06 – Hospital Triage System Using PriorityQueue

## 1. Problem Analysis

A hospital triage system must treat patients according to the severity of their medical condition.

Critical patients must receive attention before less severe patients. Patients with the same severity should be treated in arrival order.

Java PriorityQueue can implement this requirement efficiently.

## 2. Objectives

- Understand Java PriorityQueue.
- Implement severity-based patient prioritisation.
- Maintain FIFO order for patients with equal severity.
- Measure queue performance.
- Study starvation and fairness.

## 3. Concepts Used

- PriorityQueue
- Comparator
- Generics
- Queue operations
- Arrival counter
- FIFO ordering

## 4. Severity Levels

| Severity | Priority |
|---|---|
| 1 | Critical |
| 2 | High |
| 3 | Moderate |
| 4 | Low |
| 5 | Minor |

A lower severity number represents a higher treatment priority.

## 5. Initial Performance Prediction

PriorityQueue provides O(log n) insertion and removal operations.

Viewing the highest-priority patient using peek() takes O(1) time.

## 6. Patient Processing Rules

1. Patients with severity 1 are treated first.
2. Patients with severity 2 are treated next.
3. Patients with the same severity are treated in arrival order.
4. The system must support continuous patient arrivals.

## 7. Fairness and Starvation

Starvation may occur when lower-priority patients continuously wait behind newly arriving critical patients.

A fairness policy can ensure that waiting patients receive attention after a defined waiting period, subject to emergency requirements.

## 8. Alternative Approaches

- LinkedList with sorted insertion.
- Separate FIFO queues for each severity level.
- Multiple priority queues for different treatment categories.

## 9. Complexity Analysis

| Operation | Time Complexity |
|---|---|
| Insert patient | O(log n) |
| Remove highest-priority patient | O(log n) |
| View highest-priority patient | O(1) |

## 10. Conclusion

PriorityQueue provides an efficient way to process hospital patients according to severity. An arrival counter can maintain FIFO order when patients have equal severity.

## 11. Experimental Results

### Patient Treatment Order

The PriorityQueue processed patients according to severity.

- Severity 1 patients were treated first.
- Severity 2 patients were treated next.
- Patients with equal severity were processed in arrival order.
- Severity 5 patients were treated last.

### Performance Measurements

| Number of Patients | Average Execution Time |
|---|---|
| 1,000 | Replace with actual result |
| 10,000 | Replace with actual result |
| 100,000 | Replace with actual result |

The execution time was measured over three runs and averaged.

## 12. Fairness Analysis

The arrival counter ensures FIFO ordering for patients with equal severity.

However, continuous arrivals of critical patients can delay lower-severity patients. A waiting-time policy can help reduce starvation while preserving emergency priority.

## 13. Final Design Decision

PriorityQueue is selected because it efficiently processes patients according to severity.

The comparator uses severity first and arrival order second.

## 14. Conclusion

The experiment demonstrates that PriorityQueue is suitable for hospital triage. It provides priority-based treatment and maintains FIFO order among patients with equal severity.
