package ArrayClass;

import java.util.NoSuchElementException;

public class myLinkedList {
    public class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public void addFirst(int item){
        var node = new Node(item);
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head = node;
        }
        count++;
    }

    public void addLast(int item){
        var node = new Node(item);
        if(head == null){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        count++;

    }

    public int indexOf(int item){
        int counter = 0;
        var searcher = head;
        while(searcher.next != null){
            if(searcher.value == item) return counter;
            searcher = searcher.next;
            counter++;
        }
        return -1;
    }

    public boolean contains(int item){
        var searcher = head;
        while(searcher.next != null){
            if(searcher.value == item) return true;
            searcher = searcher.next;
        }
        return false;
    }

    public void removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }

        if(head == tail){
            head = tail = null;
            return;
        }


        var second = head.next;
        head.next = null;
        head = second;
        count--;
    }

    public void removeLast(){

        if(head == null){
            throw new NoSuchElementException();
        }

        if(head == tail){
            head = tail = null;
            return;
        }

        var searcher = head;
        while(searcher != null){
            if(searcher.next == tail) break;
            searcher = searcher.next;
        }

        tail = searcher;
        tail.next = null;
        count--;
    }

    public int size(){
        return count;
    }

    private Node getPrevious(Node node){
        var traverse = head;
        while(traverse.next != node){
            traverse = traverse.next;
        }
        return traverse;
    }

    public int[] toArray(){
        int[] array = new int[size()];
        var traverse = head;
        int counter = 0;
        while(traverse != null){
            array[counter] = traverse.value;
            traverse = traverse.next;
            counter++;
        }
        return array;
    }

    public void reverse(){
        assert (head != null);
        var curr = head.next;
        var prev = head;


        while(curr!= null){
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = null;
        tail = head;
        head = prev;
    }


    public int findLastKthNode(int K) {
        if (K < 0 || K > size()) {
            throw new IndexOutOfBoundsException("Index range must be within the size and greater than -1");
        }
        var p1 = head;
        var p2 = head;
        for (int i = 0; i < size(); i++) {
            if (p2.next == null) return p1.value;    //returns p1 when p2 reaches the end
            if (i < K - 1) {
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return Integer.MAX_VALUE;
    }
}
