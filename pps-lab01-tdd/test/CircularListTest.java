import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void setup() {
        list = new CircularListImpl();
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
    public void testNext() {
        assertEquals(Optional.empty(), list.next());

        list.add(1);

        assertEquals(Optional.of(1), list.next());
    }

    @Test
    public void testCircularNext() {
        list.add(1);
        list.add(2);

        assertEquals(Optional.of(1), list.next());
        assertEquals(Optional.of(2), list.next());
        assertEquals(Optional.of(1), list.next());
    }

    @Test
    public void testPrevious() {
        assertEquals(Optional.empty(), list.previous());

        list.add(1);

        assertEquals(Optional.of(1), list.previous());
    }

    @Test
    public void testCircularPrevious() {
        list.add(1);
        list.add(2);

        assertEquals(Optional.of(2), list.previous());
        assertEquals(Optional.of(1), list.previous());
        assertEquals(Optional.of(2), list.previous());
    }

    @Test
    public void testReset() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.next();
        list.next();

        list.reset();

        assertEquals(Optional.of(1), list.next());
    }

}
