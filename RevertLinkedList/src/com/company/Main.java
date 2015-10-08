package com.company;

public class Main {

    public static void main(String[] args) {

        ListNode first = new ListNode (0);
        initList(first, 10);
        printList(first);
        ListNode revertListStart = reverseList(first);
        printList(revertListStart);
    }

    private static ListNode reverseList(ListNode currentNode)
    {
        return findNext(null, currentNode);
    }


    private static ListNode findNext(ListNode parentNode, ListNode currentNode)
    {
        ListNode nextNode = currentNode.next;
        ListNode revertedListFirst;
        if (null == nextNode)
        {
            revertedListFirst = currentNode;
            revertedListFirst.next = parentNode;
        }
        else
        {
            revertedListFirst = findNext(currentNode, nextNode);
            currentNode.next = parentNode;
        }
        return revertedListFirst;
    }

    private static void initList(ListNode first, int length)
    {
        ListNode currentNode = first;
        for (int i=1; i<length; i++)
        {
            ListNode nextNode = new ListNode(i);
            currentNode.next  = nextNode;
            currentNode = nextNode;
        }
        currentNode.next = null;
    }

    private static void printList(ListNode currentNode)
    {
        System.out.println(currentNode.val);
        ListNode nextNode = currentNode.next;
        if (null!=nextNode)
        {
            printList(nextNode);
        }
    }
}

