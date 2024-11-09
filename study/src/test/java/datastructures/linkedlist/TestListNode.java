package datastructures.linkedlist;

import java.util.ArrayList;

public class TestListNode {
//    ------------------------------------------
//    21. Merge Two Sorted Lists

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // init the head of the list
        ListNode newList;
        if (list1.val >= list2.val) {
            newList = new ListNode(list2.val);
            list2 = list2.next;
        } else {
            newList = new ListNode(list1.val);
            list1 = list1.next;
        }
        // ptr for iterating/populating list
        ListNode curr = newList;

        while(list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            curr = curr.next;
        }

        return newList;
    }

    public void testMergeTwoLists() {
        // uhhhh i dunno how to setup junit here. thats'a TODO
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1); expected.add(1);expected.add(2);expected.add(3);expected.add(4);expected.add(4);

        ListNode actual = mergeTwoLists(list1, list2);
        for (Integer num : expected) {
            assert actual.val == num;
        }
    }
//    --------------------------------------
}
