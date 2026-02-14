package leetcode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x;
            if (l1 != null) {
                x = l1.val;
            } else {
                x = 0;
            }
            int y;
            if (l2 != null) {
                y = l2.val;
            } else {
                y = 0;
            }
            int sum = x + y + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}


// ListNode l3 = new ListNode(0);
// ListNode curr1 = l1;
// ListNode curr2 = l2;
// int remainder = 0;
// while (curr1 != null && curr2 != null){
//     int sum = curr1.val + curr2.val;
//     if(sum > 9){
//         reminder = sum - 10;
//         l3.next =
//     } else {
//         l3.next = sum;
//     }
//     curr1 = curr1.next;
//     curr2 = curr2.next;
