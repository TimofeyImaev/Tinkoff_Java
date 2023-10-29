package edu.hw3;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Task8 {
    private Task8() {

    }

    public static class BackwardIterator<T> implements java.util.Iterator<T> {
        private final java.util.Iterator<T> iterator;

        public BackwardIterator(Collection<T> collection) {
            LinkedList<T> elements = new LinkedList<>();

            Iterator<T> collectionIterator = collection.iterator();
            while (collectionIterator.hasNext()) {
                elements.add(collectionIterator.next());
            }
            Collections.reverse(elements);

            iterator = elements.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
