/**
 * author: Hamza Ahmed
 * date: 12/20/2024
 * IntQueue Assignment
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class IntQueue {
    // LinkedList to store queue elements
    private LinkedList<Integer> queue;

    // Creates an empty queue
    public IntQueue() {
        queue = new LinkedList<>();
    }

    // Adds an item or thing to the end of the queue
    public void enqueue(int element) {
        queue.addLast(element);
    }

    // Removing and returning the front thing or item of the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.removeFirst();
    }

    // Returns the front item or thing without removing it
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.getFirst();
    }

    // Checks if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Returns a string representation of the queue
    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        IntQueue queue = new IntQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue); // Output: [1, 2, 3]
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue); // Output: [2, 3]
        System.out.println(queue.peek()); // Output: 2
    }
}