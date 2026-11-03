class LinkedList {
    static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node sentinel = new Node(-1, null);

    public LinkedList() {}

    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        var curr = sentinel.next;
        while (index-- != 0 && curr != null) {
            curr = curr.next;
        }
        if (curr == null) {
            return -1;
        }
        return curr.val;
    }

    public void insertHead(int val) {
        sentinel.next = new Node(val, sentinel.next);
    }

    public void insertTail(int val) {
        var curr = sentinel;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val, null);
    }

    public boolean remove(int index) {
        if (index < 0) {
            return false;
        }
        var curr = sentinel;
        while (index-- != 0 && curr != null) {
            curr = curr.next;
        }
        if (curr == null || curr.next == null) {
            return false;
        }
        curr.next = curr.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        Node curr = sentinel.next;
        var list = new ArrayList<Integer>();
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }
}
