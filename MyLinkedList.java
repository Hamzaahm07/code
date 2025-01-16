import java.util.NoSuchElementException;

/**
 * author: Hamza Ahmed
 * date: 12/20/2024
 * My Linked List assignment
 */

public class MyLinkedList<T> {
    // Instance variable for the head of the linked list
    private Node head;

    // Constructor
    public MyLinkedList() {
        this.head = null; // Empty linked list has no head
    }

    /**
     * Check if the linked list is empty.
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Adds a new node at the beginning of the list.
     * 
     * @param data The data to add.
     */
    public void prepend(T data) {
        Node node = new Node(data);

        // Step 0: is the list empty?
        if (isEmpty()) {
            this.head = node;
            return;
        }

        // Step 1: make the "next" of this node point to the current list
        node.next = this.head;

        // Step 2: make node the new head of the list
        this.head = node;
    }

    /**
     * Adds a new node at the end of the list.
     * 
     * @param data The data to add.
     */
    public void append(T data) {
        Node node = new Node(data);

        // Step 0: is the list empty?
        if (isEmpty()) {
            this.head = node;
            return;
        }

        // Step 1: traverse to the end of the list
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        // Step 2: Add the new node at the end
        current.next = node;
    }

    /**
     * Removes the first element from the linked list.
     */
    public void removeFirst() {
        if (isEmpty()) {
            return; // Nothing to remove
        }

        // Move the head pointer to the next node
        this.head = this.head.next;
    }

    /**
     * Returns the first element in the list.
     * 
     * @return the first element's data
     * @throws NoSuchElementException if the list is empty
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot get the first element of an empty list.");
        }
        return this.head.data;
    }

    /**
     * Returns the size (number of elements) in the linked list.
     * 
     * @return The size of the linked list
     */
    public int size() {
        int count = 0; // Start the count at 0
        Node current = this.head; // Start at the head of the list
        while (current != null) { // Loop until the end of the list
            count++; // Increment count for each node
            current = current.next; // Move to the next node
        }
        return count; // Return the total number of nodes in the list
    }

    /**
     * Creates a string representation of the linked list.
     * 
     * @return String representation of linked list elements
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder repr = new StringBuilder();
        Node current = this.head;

        while (current != null) {
            repr.append(current.data);
            if (current.next != null) {
                repr.append(" -> ");
            }
            current = current.next;
        }

        return "[" + repr + "]";
    }

    /**
     * Inner Node class representing a node in a singly linked list.
     */
    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}