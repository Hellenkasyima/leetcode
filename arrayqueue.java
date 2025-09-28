class Queue {
    private int[] queue;
    private int front, rear, capacity;

    public Queue(int size) {
        capacity = size;
        queue = new int[size];
        front = 0;
        rear = -1;
    }

    public void enqueue(int x) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
        } else {
            queue[++rear] = x;
            System.out.println(x + " enqueued to queue");
        }
    }

    public void dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(queue[front++] + " dequeued from queue");
        }
    }

    public void display() {
        if (front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // Overflow
        q.display();
    }
}
