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
