public class Queue {
    private int[] arr;
    private int maxSize;
    private int front;//队列首元素
    private int rear;//下一个插入元素的位置

    public Queue(int size) {
        maxSize = size;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }


    public void add(int num) {
        if (isFull()) {
            System.out.println("队列已满！");
            return;
        }
        arr[rear] = num;
        rear = (++rear) % maxSize;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int num = arr[front];
        //arr[front] = 0;
        front = (++front) % maxSize;
        return num;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return arr[front];
    }

    public void list() {
        if(isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        for (int i = front; i < front+(rear+maxSize-front)%maxSize; i++) {
            System.out.print(arr[i%maxSize] + " ");
        }
    }
}
