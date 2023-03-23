import iterator.CircularListIterator;
import iterator.CircularListIteratorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CircularListIteratorTest {

    private CircularListIterator list;

    @BeforeEach
    void setup() {
        list = new CircularListIteratorImpl();
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
    public void testForwardIterator() {
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.forwardIterator();

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(1, iterator.next());
    }

    @Test
    public void testPreviousIterator() {
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.backwardIterator();

        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(3, iterator.next());

    }

}
