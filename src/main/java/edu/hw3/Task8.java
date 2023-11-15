package edu.hw3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task8 {
    private Task8() {

    }

    public static class BackwardIterator<T> implements java.util.Iterator<T> {
        private final java.util.ListIterator<T> listIterator;

        public BackwardIterator(Collection<T> collection) {
            List<T> elements = new ArrayList<>(collection);
            listIterator = elements.listIterator(elements.size());
        }

        @Override
        public boolean hasNext() {
            return listIterator.hasPrevious();
        }

        @Override
        public T next() {
            return listIterator.previous();
        }

        @Override
        public void remove() {
            listIterator.remove();
        }
    }
}
