package leetcode;

public class AddLinkedListNumbers {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode originL1 = l1;
//        l1.next = new ListNode(4);
//        l1 = l1.next;
//        l1.next = new ListNode(3);
//        l1 = l1.next;
//        l1.next = null;
//
//        ListNode l2 = new ListNode(5);
//        ListNode originL2 = l2;
//        l2.next = new ListNode(6);
//        l2 = l2.next;
//        l2.next = new ListNode(4);
//        l2 = l2.next;
//        l2.next = new ListNode(8);
//        l2 = l2.next;
//        l2.next = null;

        ListNode l1 = new ListNode(9);
        ListNode originL1 = l1;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = null;

        ListNode l2 = new ListNode(9);
        ListNode originL2 = l2;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = null;

        ListNode result = addTwoNumbers(originL1, originL2);
        for (int i = 0; i < 1000; i++) {
            System.out.print(result.val);
            if (result.next == null) {
                break;
            }
            result = result.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode originResult = result;
        int overTen = 0;

        for (int i = 1; i <= 100; i++) {
            if (l1 == null && l2 == null) {
                if (overTen > 0) {
                    result.val = overTen;
                    result.next = null;
                }
                break;
            }

            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            int sum = l1Val + l2Val + overTen;

            if (sum < 10) {
                result.val = sum;
                overTen = 0;
            } else {
                result.val = sum - 10;
                overTen = 1;
            }

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            if (overTen == 1 || l1 != null || l2 != null) {
                result.next = new ListNode();
            }
            result = result.next;
        }

        return originResult;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
