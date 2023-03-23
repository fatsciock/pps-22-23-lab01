package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private final List<Integer> list;
    private int index;

    public CircularListImpl() {
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
    public Optional<Integer> next() {
        if(isEmpty())
            return Optional.empty();
        else {
            Optional<Integer> res = Optional.of(list.get(index));
            if(index + 1 < size())
                index++;
            else
                index = 0;
            return res;
        }
    }

    @Override
    public Optional<Integer> previous() {
        if(isEmpty())
            return Optional.empty();
        else {
            if(index - 1 < 0)
                index = size() - 1;
            else
                index--;
            return Optional.of(list.get(index));
        }
    }

    @Override
    public void reset() {
        index = 0;
    }
}
