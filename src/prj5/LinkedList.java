// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Khang Nguyen (khang) Nathan Kim (nathank) Jason Hassold (jasonh44)
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a basic implementation of a linked list
 *
 * @author khang, nathank, jasonh44
 * @version 12.11.2018
 *
 * @param <E>
 *            This is the type of object that this class will store
 */
public class LinkedList<E> implements Iterable<E> {

    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @param <D>
     *            This is the type of object that this class will store
     * @author khang, nathank, jasonh44
     *
     * @version 12.11.2018
     */
    private static class Node<E> {
        // Fields
        private E data;
        private Node<E> next;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E data() {
            return data;
        }


        /**
         * Sets the new data
         *
         * @param newData
         */
        public void setData(E newData) {
            data = newData;
        }
    }


    /**
     * Iterator inner class
     *
     * @author jasonh44
     * @version 12.11.2018
     */
    private class LLIterator<A> implements Iterator<E> {
        // Fields
        private Node<E> nextNode;


        /**
         * Constructor
         */
        public LLIterator() {
            nextNode = firstNode;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return null != nextNode;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (hasNext()) {
                Node<E> returnNode = nextNode;
                nextNode = nextNode.next();
                return returnNode.data();
            }
            else {
                throw new NoSuchElementException("Illegal call to next(); "
                    + "iterator is after end of list.");
            }
        }

    }

    // Fields
    private Node<E> firstNode;
    private int size;


    /**
     * Creates a new LinkedList object
     */
    public LinkedList() {
        firstNode = null;
        size = 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = firstNode;

        // empty stack case
        if (isEmpty()) {
            firstNode = new Node<E>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(E obj) {
        Node<E> current = firstNode;

        // account for matching firstNode
        if ((null != firstNode) && (obj.equals(current.data))) {
            firstNode = firstNode.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                current.setNext(current.next.next);
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean remove(int index) {
        // // if the index is invalid
        if (index < 0 || firstNode == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {

            Node<E> current = firstNode;
            int currentIndex = 0;

            // account for 1 size
            if ((index == 0)) {
                firstNode = firstNode.next;
                size--;
                return true;
            }

            // account for 2+ size
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public E get(int index) {
        Node<E> current = firstNode;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj) {
        Node<E> current = firstNode;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        // make sure we don't call clear on an empty list
        if (firstNode != null) {
            firstNode = null;
            size = 0;
        }
    }


    /**
     * Creates and returns an LLIterator object
     *
     * @return the LLIterator object
     */
    public Iterator<E> iterator() {
        return new LLIterator<E>();
    }


    /**
     * returns next node
     *
     * @return next node
     */
    public Node<E> nextNode() {
        return firstNode.next();
    }


    /**
     * returns this node
     *
     * @return this node
     */
    public Node<E> thisNode() {
        return firstNode;
    }


    /**
     * Swaps two nodes
     *
     * @param newNode
     *            node to swap
     */
    public void swap(Node<E> fNode, Node<E> newNode) {
        Node<E> temp = new Node<E>(fNode.data());
        fNode.setData(newNode.data());
        newNode.setData(temp.data());

    }

    /**
     * Gets Node at index
     * @param index index of node
     * @return node
     */
    public Node<E> getNode(int index) {
        Node<E> returnNode = firstNode;
        for (int i = 0; i < index; i++) {
            returnNode = firstNode.next();
        }

        return returnNode;
    }

    /**
     * Returns array of list
     * @return
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = firstNode; x != null; x = x.next()) {
            result[i++] = x.data;
        }
        return result;
    }
}
