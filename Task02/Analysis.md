# Q2 – WHEN IS ARRAYLIST AN APPROPRIATE ENGINEERING CHOICE?

## 1. Problem Analysis

A music-streaming application allows users to create and manage playlists. Users can add songs, insert songs at specific positions, remove songs and directly access the k-th song.

The objective is to compare ArrayList and LinkedList and determine which collection is more suitable for playlist management.

## 2. Objectives

- Compare ArrayList and LinkedList performance.
- Measure adding songs at the end.
- Measure insertion and removal at the front and middle.
- Measure access to the k-th song.
- Compare full-list iteration.
- Test three different playlist sizes.
- Evaluate ArrayDeque for the Up Next queue.

## 3. Collections Used

| Collection | Description |
|---|---|
| ArrayList | Uses a dynamically resizable array. |
| LinkedList | Uses linked nodes to store elements. |
| ArrayDeque | Uses a resizable array-based double-ended queue. |

## 4. Initial Performance Prediction

| Operation | ArrayList | LinkedList |
|---|---|---|
| Add at end | O(1) amortised | O(1) |
| Insert at front | O(n) | O(1) |
| Insert in middle | O(n) | O(n) to locate |
| Remove at front | O(n) | O(1) |
| Remove in middle | O(n) | O(n) to locate |
| Access k-th element | O(1) | O(n) |
| Full iteration | O(n) | O(n) |

## 5. Experimental Workloads

Three playlist sizes will be tested.

| Workload | Number of Songs |
|---|---:|
| Small | 1,000 |
| Medium | 10,000 |
| Large | 50,000 |

Each collection will be tested using the same operations and input sizes.

## 6. Space Complexity Analysis

- ArrayList stores elements in an internal array.
- LinkedList stores elements in separate linked nodes containing references.
- ArrayDeque stores elements in a resizable array and supports operations at both ends.

ArrayList and ArrayDeque generally have lower per-element storage overhead than LinkedList.

## 7. Changed Condition – Up Next Queue

The application introduces an Up Next queue where songs are frequently added at both ends and removed from the front.

ArrayDeque is suitable for this requirement because it supports efficient insertion and removal at both ends.

## 8. Alternative Concept – Plain Array

A plain array can store playlist songs.

However, inserting or removing an element requires shifting other elements to maintain the correct order.

Therefore, front and middle insertion or removal require O(n) time. Direct access to the k-th song takes O(1) time.

## 9. Final Objective

The experiment will identify when ArrayList is a reasonable choice for playlist management and when LinkedList or ArrayDeque is more suitable based on actual usage patterns and measured performance.
