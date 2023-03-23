package iterator;

import java.util.Iterator;

public interface CircularListIterator {

    void add(final int element);

    int size();

    boolean isEmpty();

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();
}
