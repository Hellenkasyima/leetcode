public class MyCircularQueue {
    private final int[] q;
    private int head;     // index of front element
    private int count;    // current number of elements
    private final int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        q = new int[k];
        head = 0;
        count = 0;
    }

    // insert at tail; return false if full
    public boolean enQueue(int value) {
        if (count == capacity) return false;
        int tailIndex = (head + count) % capacity;
        q[tailIndex] = value;
        count++;
        return true;
    }

    // remove front; return false if empty
    public boolean deQueue() {
        if (count == 0) return false;
        head = (head + 1) % capacity;
        count--;
        return true;
    }

    public int Front() {
        if (count == 0) return -1;
        return q[head];
    }

    public int Rear() {
        if (count == 0) return -1;
        int tailIndex = (head + count - 1) % capacity;
        if (tailIndex < 0) tailIndex += capacity;
        return q[tailIndex];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    // small test
    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        System.out.println(q.enQueue(1)); // true
        System.out.println(q.enQueue(2)); // true
        System.out.println(q.enQueue(3)); // true
        System.out.println(q.enQueue(4)); // false (full)
        System.out.println(q.Rear());     // 3
        System.out.println(q.isFull());   // true
        System.out.println(q.deQueue());  // true
        System.out.println(q.enQueue(4)); // true
        System.out.println(q.Rear());     // 4
    }
}
