import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * author: Hamza Ahmed
 * date: 12/20/2024
 * IntStack Assignment
 */


public class IntStack {
    // LinkedList to store stack elements
    private LinkedList<Integer> stack;

    // Creates an empty stack
    public IntStack() {
        stack = new LinkedList<>();
    }

    // Adds an item or thing to the front (top) of the stack
    public void push(int element) {
        stack.addFirst(element);
    }

    // Removes and returns the front (top) item of the stack
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.removeFirst();
    }

    // Returns the front (top) element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.getFirst();
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Returns a string representation of the stack
    @Override
    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        IntStack stack = new IntStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack); // Output: [3, 2, 1]
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack); // Output: [2, 1]
        System.out.println(stack.peek()); // Output: 2
    }
}