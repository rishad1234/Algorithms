/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 *
 * @author Admin
 */
public class Deque<Item> implements Iterable<Item> {

    
    private Item[] dequeue;
    private int size;

    public Deque() {
        @SuppressWarnings("unchecked")
        Item[] a = (Item[]) new Object[2];
        dequeue = a;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            if (size == dequeue.length) {
                resize();
            }

            for (int i = size - 1; i > 0; i--) {
                dequeue[i] = dequeue[i + 1];
            }
            dequeue[0] = item;
            size++;
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            if (size == dequeue.length) {
                resize();
            }
            dequeue[size] = item;
            size++;
        }
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Item item = dequeue[0];
            for (int i = 0; i < size - 1; i++) {
                dequeue[i] = dequeue[i + 1];
            }
            size--;
            return item;
        }
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Item item = dequeue[size - 1];
            dequeue[size - 1] = null;
            size--;
            return item;
        }
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[this.size * 2];
        for (int i = 0; i < dequeue.length; i++) {
            temp[i] = dequeue[i];
        }

        dequeue = temp;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private int i = 0;

        public boolean hasNext() {
            return i < size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = dequeue[i];
            i++;
            return item;
        }
    }
}
