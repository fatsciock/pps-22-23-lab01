package filtered;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CircularListFilteredImpl implements CircularListFiltered{

    private final List<Integer> list;
    private int index;

    public CircularListFilteredImpl() {
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
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        if(list.stream().filter(predicate).findFirst().isEmpty()) {
            return Optional.empty();
        } else {
            return list.stream().filter(predicate).findFirst();
        }
    }
}
