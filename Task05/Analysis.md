# Task 05 – Generic Leaderboard and Comparator

## 1. Problem Analysis

A leaderboard ranks participants based on multiple performance criteria.

Java Generics and Comparator are used to create a reusable leaderboard that can sort participants according to points, goal difference and name.

## 2. Objectives

- Understand Java Generics.
- Implement a reusable Leaderboard class.
- Use Comparator for custom sorting.
- Apply multiple sorting conditions.
- Test correct and incorrect comparator implementations.

## 3. Concepts Used

- Generics
- Comparator
- Comparable
- Collections.sort()
- Lambda expressions
- Multi-level sorting

## 4. Leaderboard Requirements

Participants must be ranked using these conditions:

1. Higher points should receive a higher rank.
2. If points are equal, higher goal difference should receive a higher rank.
3. If both are equal, names should be sorted alphabetically.

## 5. Initial Performance Prediction

Comparator-based sorting is expected to take O(n log n) time.

The leaderboard should support different participant types through Java Generics.

## 6. Sorting Rules

| Priority | Condition | Order |
|---|---|---|
| 1 | Points | Descending |
| 2 | Goal Difference | Descending |
| 3 | Name | Alphabetical |

## 7. Faulty Comparator Test

A faulty comparator will be tested to observe incorrect ranking behaviour.

The correct comparator must return:
- A negative value when the first participant ranks higher.
- Zero when both participants are equal in ranking.
- A positive value when the second participant ranks higher.

## 8. Alternative Approach

Comparable can be implemented inside the participant class to define its natural ordering.

However, Comparator is more flexible because different ranking rules can be created without modifying the participant class.

## 9. Complexity Analysis

| Operation | Time Complexity |
|---|---|
| Adding a participant | O(1) average |
| Sorting leaderboard | O(n log n) |
| Accessing a participant by index | O(1) |

## 10. Conclusion

The experiment demonstrates how Java Generics and Comparator can be used to build a reusable leaderboard with multiple ranking conditions.
