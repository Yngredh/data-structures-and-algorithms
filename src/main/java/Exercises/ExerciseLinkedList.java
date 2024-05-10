package Exercises;

public class ExerciseLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * [2] LeetCode <p style="color: yellow;">Medium</p>
     * <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
     * @TimeComplexity O(?)
     * @SpaceComplexity O(?)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(digit);
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public static ListNode detectCycle(ListNode head) {
        if(head.next == null) return null;
        ListNode curr = head;

        while(curr.next != null) {
            ListNode compare = head;
            while(compare != curr) {
                if(curr.next == compare) return curr;
                compare = compare.next;
            }
            curr = curr.next;
        }
        return null;
    }
}

