# Task 07 – Day-4 Design Challenge

## 1. Selected Limitation

The selected limitation is starvation in the Hospital Triage System developed in Task 06.

The original PriorityQueue processes patients according to severity. However, patients with lower severity may wait for a long time when critical patients continuously arrive.

## 2. Problem Diagnosis

The original system uses severity as the main priority and arrival order for patients with equal severity.

Its limitation is that it does not consider how long a patient has been waiting.

Continuous arrival of critical patients can delay patients with less severe conditions.

## 3. Objective

The objective is to improve fairness and reduce starvation while maintaining emergency treatment priority.

## 4. Proposed Redesign

Implement a priority-aging mechanism.

The redesigned system will:

- Consider patient severity.
- Track patient waiting time.
- Increase priority for patients who wait beyond a defined threshold.
- Preserve FIFO order when effective priorities are equal.
- Continue to prioritise critical emergencies.

## 5. Expected Improvements

- Reduced waiting time for less severe patients.
- Improved fairness.
- Better management of patient queues.
- More balanced treatment scheduling.

## 6. Performance Prediction

The redesigned system may require additional processing to calculate effective priority.

The basic PriorityQueue operations remain O(log n), but recalculating priorities may require rebuilding the queue.

## 7. Trade-offs

| Original System | Redesigned System |
|---|---|
| Uses severity only | Uses severity and waiting time |
| Simple implementation | More complex implementation |
| Lower processing overhead | Additional priority calculations |
| Risk of starvation | Reduced starvation risk |

## 8. Validation Plan

The original and redesigned systems will be tested using the same patient arrival sequence.

The comparison will examine:

- Patient treatment order.
- Waiting time.
- Starvation behaviour.
- Processing time.

## 9. Conclusion

The redesign introduces waiting-time-based priority adjustment to improve fairness in hospital triage. Emergency severity remains important, while patients who wait for extended periods receive additional consideration.


## 10. Experimental Results

Both the original and redesigned hospital triage systems were executed using the same 10 patients.

### Original Triage System

- Average waiting time: 2.7 time units
- Maximum waiting time: 9 time units
- Patients were selected mainly according to fixed severity.

### Redesigned Triage System

- Average waiting time: 2.7 time units
- Maximum waiting time: 7 time units
- Priority aging gradually improves the priority of patients who wait longer.

## 11. Performance Comparison

| Measurement | Original System | Redesigned System |
|---|---:|---:|
| Number of patients | 10 | 10 |
| Average waiting time | 2.7 | 2.7 |
| Maximum waiting time | 9 | 7 |

The maximum waiting time decreased by 22.2%.

Calculation:

Reduction = ((9 - 7) / 9) × 100 = 22.2%

## 12. Analysis of Results

The redesigned system reduced the maximum waiting time from 9 to 7 time units.

The average waiting time remained unchanged at 2.7 time units. This indicates that priority aging improved fairness by reducing the longest waiting time rather than reducing the overall average.

Critical patients with severity level 1 continue to receive the highest priority.

## 13. Trade-offs and Limitations

- Priority aging requires additional waiting-time calculations.
- Some higher-priority patients may wait slightly longer.
- The simulation uses a small test dataset.
- Real hospital systems require clinical validation and additional safety rules.

## 14. Final Conclusion

The redesigned hospital triage system uses priority aging to reduce the risk of starvation among patients with lower initial priority.

Experimental results show a 22.2% reduction in maximum waiting time while maintaining the same average waiting time.

Therefore, priority aging provides a fairer scheduling approach while preserving emergency priority.
