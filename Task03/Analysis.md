# Task 03 – HashCode and Equals Contract

## 1. Problem Analysis

Java HashSet uses the hashCode() and equals() methods to identify duplicate objects.

If two objects are equal according to equals(), they must return the same hash code. Otherwise, HashSet may store duplicate objects.

## 2. Objectives

- Understand the relationship between hashCode() and equals().
- Identify duplicate Student objects using HashSet.
- Implement hashCode() correctly.
- Test the behaviour of HashSet and TreeSet.
- Understand the importance of immutable keys.

## 3. Concepts Used

- hashCode()
- equals()
- HashSet
- TreeSet
- HashMap
- Object equality

## 4. Initial Performance Prediction

HashSet provides average O(1) insertion, deletion and search operations when hash codes are distributed properly.

If hashCode() is not implemented consistently with equals(), duplicate detection may fail.

## 5. Experimental Test Cases

### Test Case 1 – Unique Students

Insert students with different registration numbers.

Expected result: All unique students should be stored.

### Test Case 2 – Duplicate Students

Insert two Student objects with the same registration number.

Expected result: Only one object should remain in the HashSet after hashCode() is implemented correctly.

### Test Case 3 – TreeSet Comparator

Insert two students with different registration numbers but the same name into a TreeSet whose comparator checks only the name.

Expected result: TreeSet may treat them as equal because the comparator returns zero.

## 6. HashCode and Equals Implementation

The hashCode() method must use the same identifying field used by equals().

For this experiment, the registration number is used as the unique student identifier.

## 7. Complexity Analysis

| Operation | Average Time Complexity |
|---|---|
| HashSet insertion | O(1) |
| HashSet search | O(1) |
| HashSet deletion | O(1) |
| TreeSet insertion | O(log n) |
| TreeSet search | O(log n) |

## 8. Alternative Approaches

- TreeSet with a correct Comparator.
- HashMap using registration number as the key.
- Immutable Student objects to prevent changes to equality-related fields.

## 9. Conclusion

The experiment demonstrates that hashCode() and equals() must follow the Java contract. Correct implementation prevents duplicate Student objects in HashSet and supports reliable collection operations.

## 10. Experimental Results

### Test 1 – Unique Students

Two students with different registration numbers were inserted.

Result: HashSet stored both students successfully.

### Test 2 – Duplicate Students

Two Student objects with the same registration number were inserted.

Before implementing hashCode(), the result depended on hash-code collisions.

After implementing hashCode(), HashSet correctly identified the duplicate and stored only one copy.

### Test 3 – TreeSet Comparator

Two students had different registration numbers but the same name.

The TreeSet comparator compared only student names. Therefore, it treated both students as equal and stored only one.

## 11. Final Observation

- equals() compares students using their registration numbers.
- hashCode() generates a hash based on the same registration number.
- Equal objects must always have equal hash codes.
- TreeSet uses its comparator to determine ordering and uniqueness.
- Immutable identifying fields help prevent collection-related errors.

## 12. Final Conclusion

The experiment confirms that hashCode() and equals() must be implemented consistently for reliable HashSet behaviour. A suitable comparator is also essential when using TreeSet.
