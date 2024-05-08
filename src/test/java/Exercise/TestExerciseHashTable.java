package Exercise;

import org.junit.Test;

import static Exercises.ExerciseHashTable.containsDuplicate;
import static Exercises.ExerciseHashTable.majorityElement;
import static Exercises.ExerciseHashTable.firstRecurringNumber;
import static org.junit.Assert.*;

public class TestExerciseHashTable {

    @Test
    public void testContainsDuplicate() {
        int[] nums = {1000000000,1000000000,11};
        int[] nums2 = {1,5,-2,-4,0};
        int[] nums3 = {0};
        assertTrue(containsDuplicate(nums));
        assertFalse(containsDuplicate(nums2));
        assertFalse(containsDuplicate(nums3));
    }

    @Test
    public void testFirstRecurringNumber() {
        int[] case1 = new int[] {2,5,5,2,3,4};
        int[] case2 = new int[] {2,5,9,3,4,9};
        int[] case3 = new int[] {2,9,9,3,4};
        assertEquals(5, firstRecurringNumber(case1));
        assertEquals(0, firstRecurringNumber(case2));
        assertEquals(9, firstRecurringNumber(case3));
    }

    @Test
    public void majorityElementTest() {
        int[] case1 = {2,2,1,1,1,2,2};
        int[] case2 = {3,2,3};
        assertEquals(2, majorityElement(case1));
        assertEquals(3, majorityElement(case2));
    }
}
