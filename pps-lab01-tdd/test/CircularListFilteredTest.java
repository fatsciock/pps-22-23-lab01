import filtered.CircularListFiltered;
import filtered.CircularListFilteredImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CircularListFilteredTest {

    private CircularListFiltered list;

    @BeforeEach
    void setup() {
        list = new CircularListFilteredImpl();
    }

    @Test
    public void testAdd() {
        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());

        list.add(1);

        assertEquals(1, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testFilteredNext() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Optional.of(3),list.filteredNext(val -> val > 2));
        assertEquals(Optional.empty(),list.filteredNext(val -> val > 4));
    }
}
