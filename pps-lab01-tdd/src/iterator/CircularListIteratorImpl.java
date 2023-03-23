package iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CircularListIteratorImpl implements CircularListIterator {

    private final List<Integer> list;
    private int index;

    public CircularListIteratorImpl() {
        list = new LinkedList<>();
        index = 0;
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Integer next() {
                int tmp = list.get(index);
                if (index + 1 < size())
                    index++;
                else
                    index = 0;
                return tmp;
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Integer next() {
                if (index - 1 < 0)
                    index = size() - 1;
                else
                    index--;
                return list.get(index);
            }
        };
    }
}