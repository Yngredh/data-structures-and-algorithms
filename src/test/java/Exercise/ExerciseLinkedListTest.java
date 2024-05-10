package Exercise;

import org.junit.Test;

import static Exercises.ExerciseLinkedList.ListNode;
import static Exercises.ExerciseLinkedList.detectCycle;
import static Exercises.ExerciseLinkedList.addTwoNumbers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExerciseLinkedListTest {

    @Test
    public void addTwoNumberTest() {
        ListNode num2 = new ListNode(2);
        ListNode num4 = new ListNode(4);
        ListNode num3 = new ListNode(3);
        num2.next = num4;
        num4.next = num3;

        ListNode num5 = new ListNode(5);
        ListNode num6 = new ListNode(6);
        ListNode num9 = new ListNode(9);
        num5.next = num6;
        num6.next= num9;

        ListNode result = addTwoNumbers(num2, num5);
        assertTrue(assertLinkedListEquals(new int[]{2, 1, 8}, result));
    }

    @Test
    public void testDetectCycle() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        ListNode result = detectCycle(l1);
        assertEquals(l3, result);
        System.out.print("The cycle begins at node: " + result.val);
    }

    private boolean assertLinkedListEquals(int[] expected, ListNode actual) {
        int expI = expected[0];
        int actI = actual.val;
        for (int i = 0; i < expected.length -1; i++) {
            if (expI != actI) return false;
            expI = expected[i];
            actI = actual.next.val;
        }
        return true;
    }
}