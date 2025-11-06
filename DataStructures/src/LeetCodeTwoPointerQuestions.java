public class LeetCodeTwoPointerQuestions {

     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        System.out.println("Original List");
        printList(head);
        System.out.println("Reverse List");
        printList(reverseList(head));


    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow= slow.next;
        }
        slow = reverseList(slow);
        fast = head;

        while(slow !=null){
            if(fast.val != slow.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }


    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        ListNode node = reverseList(head.next);
        nextNode.next= head;
        head.next = null;
        return node;
    }

    private static void printList(ListNode head){
         while(head != null){
             System.out.print(head.val + " ");
             head  = head.next;
         }
    }



    public static int pairSum(ListNode head){
         ListNode slow = head, fast = head;
         int middleCount =0, max = Integer.MIN_VALUE;
         while(fast!=null && fast.next!=null){
             fast=  fast.next.next;
             slow = slow.next;
             middleCount++;
         }

         slow = reverseList(slow);
         while(middleCount >0){
             int sum = head.val + slow.val;
             max = Math.max(max,sum);
             head= head.next;
             slow = slow.next;
             middleCount--;
         }
         return max;
    }

}



