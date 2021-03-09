package leetcode;

/**
 * 循环队列 FIFO（先进先出）
 */
public class _622_MyCircularQueue {

    public static void main(String[] args) {
        _622_MyCircularQueue queue = new _622_MyCircularQueue(3);
        System.out.println(queue.enQueue(1) + "");
        System.out.println(queue.enQueue(2) + "");
        System.out.println(queue.enQueue(3) + "");
        System.out.println(queue.enQueue(4) + "");
        System.out.println(queue.Rear() + "");
        System.out.println(queue.isFull() + "");
        System.out.println(queue.deQueue() + "");
        System.out.println(queue.enQueue(4) + "");
        System.out.println(queue.Rear() + "");
    }

    private final int size;
    private int tail;
    private int head;
    private final int[] queue;

    _622_MyCircularQueue(int k) {
        size = k + 1;
        queue = new int[size];
        tail = 0;
        head = 0;
    }

    /**
     * 向循环队列插入一个元素
     *
     * @param value
     * @return
     */
    boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 从循环队列中删除一个元素
     *
     * @return
     */
    boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % size;
        return true;
    }

    /**
     * 从队首获取元素
     *
     * @return
     */
    int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    /**
     * 获取队尾元素
     *
     * @return
     */
    int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(tail - 1 + size) % size];
    }

    boolean isEmpty() {
        return tail == head;
    }

    boolean isFull() {
        return (tail + 1) % size == head;
    }
}

