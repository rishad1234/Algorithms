/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Admin
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] q;
    private int size;

    public RandomizedQueue() {
        @SuppressWarnings("unchecked")
        Item[] a = (Item[]) new Object[2];
        q = a;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            if (size == q.length) {
                resize();
            }
            q[size] = item;
            size++;
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            int index = StdRandom.uniform(size);
            Item item = q[index];

            for (int i = index; i < size - 1; i++) {
                q[i] = q[i + 1];
            }
            size--;
            return item;
        }
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return q[StdRandom.uniform(size)];
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[this.size * 2];
        for (int i = 0; i < q.length; i++) {
            temp[i] = q[i];
        }

        q = temp;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private int current;
        private int[] random;

        public ArrayIterator() {
            this.random = new int[size];
            for (int i = 0; i < size; i++) {
                random[i] = i;
            }
            StdRandom.shuffle(random);
            current = 0;
        }

        public boolean hasNext() {
            return current != random.length;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return q[random[current++]];
        }
    }
}
