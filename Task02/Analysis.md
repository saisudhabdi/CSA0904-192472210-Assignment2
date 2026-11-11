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

## 10. Experimental Methodology

The ArrayList and LinkedList collections were tested using identical playlist data.

Each operation was executed three times, and the average execution time was calculated using System.nanoTime().

The following operations were measured:

1. Adding songs at the end.
2. Inserting songs at the front.
3. Inserting songs in the middle.
4. Removing songs from the front.
5. Removing songs from the middle.
6. Accessing the k-th song.
7. Iterating through the complete playlist.

Three playlist sizes were used: 1,000, 10,000 and 50,000 songs.

## 11. Experimental Results

The measured execution times are recorded in nanoseconds.

### Small Playlist – 1,000 Songs

| Operation | ArrayList (ns) | LinkedList (ns) |
|---|---:|---:|
| Add End | To be recorded | To be recorded |
| Insert Front | To be recorded | To be recorded |
| Insert Middle | To be recorded | To be recorded |
| Remove Front | To be recorded | To be recorded |
| Remove Middle | To be recorded | To be recorded |
| Access Kth | To be recorded | To be recorded |
| Full Iteration | To be recorded | To be recorded |

### Medium Playlist – 10,000 Songs

| Operation | ArrayList (ns) | LinkedList (ns) |
|---|---:|---:|
| Add End | To be recorded | To be recorded |
| Insert Front | To be recorded | To be recorded |
| Insert Middle | To be recorded | To be recorded |
| Remove Front | To be recorded | To be recorded |
| Remove Middle | To be recorded | To be recorded |
| Access Kth | To be recorded | To be recorded |
| Full Iteration | To be recorded | To be recorded |

### Large Playlist – 50,000 Songs

| Operation | ArrayList (ns) | LinkedList (ns) |
|---|---:|---:|
| Add End | To be recorded | To be recorded |
| Insert Front | To be recorded | To be recorded |
| Insert Middle | To be recorded | To be recorded |
| Remove Front | To be recorded | To be recorded |
| Remove Middle | To be recorded | To be recorded |
| Access Kth | To be recorded | To be recorded |
| Full Iteration | To be recorded | To be recorded |

## 12. ArrayDeque Evaluation

ArrayDeque was tested for the Up Next queue.

It supports insertion and removal at both ends and is suitable for queue-based playlist operations.

## 13. Conclusion

ArrayList is suitable when frequent indexed access and iteration are required.

LinkedList can be useful when insertion and removal occur at the ends or through an already-positioned iterator.

ArrayDeque is suitable for managing the Up Next queue.

The final collection choice will be based on the measured experimental results.
