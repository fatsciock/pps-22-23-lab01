package filtered;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularListFiltered {

    void add(final int element);

    int size();

    boolean isEmpty();

    Optional<Integer> filteredNext(Predicate<Integer> predicate);
}
