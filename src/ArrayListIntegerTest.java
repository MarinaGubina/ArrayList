import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListIntegerTest {

    private final ArrayListInteger arr = new ArrayListInteger(5);
    private final static int INDEX_TEST = 1;
    private final static Integer ITEM_TEST = 30;
    private final static Integer ITEM_TEST_TRUE = 9;
    private final static Integer ITEM_TEST_FALSE = 100;

    @BeforeEach
    public void setUp(){
        arr.add(8);
        arr.add(9);
        arr.add(2);
        arr.add(4);
    }

    @Test
    public void shouldAddString(){
        int actual = arr.add(ITEM_TEST);
        assertEquals(ITEM_TEST,actual);
    }

    @Test
    public void shouldAddWithIndex() {
        assertEquals(arr.add(INDEX_TEST,ITEM_TEST), ITEM_TEST);
    }

    @Test
    public void set() {
        assertEquals(arr.set(INDEX_TEST,ITEM_TEST),ITEM_TEST);
    }

    @Test
    public void remove() {
        assertEquals(arr.remove(ITEM_TEST_TRUE), ITEM_TEST_TRUE);
    }

    @Test
    public void removeWithIndex() {
        assertEquals(arr.remove(INDEX_TEST), ITEM_TEST_TRUE);
    }

    @Test
    public void shouldTrueContains() {
        assertTrue(arr.contains(ITEM_TEST_TRUE));
    }

    @Test
    public void shouldFalseContains() {
        assertFalse(arr.contains(ITEM_TEST_FALSE));
    }

    @Test
    public void indexOf() {
        assertEquals(INDEX_TEST, arr.indexOf(ITEM_TEST_TRUE));
        assertEquals(-1,arr.indexOf(ITEM_TEST_FALSE));
    }


    @Test
    public void lastIndexOf() {
        assertEquals(INDEX_TEST, arr.lastIndexOf(ITEM_TEST_TRUE));
        assertEquals(-1, arr.lastIndexOf(ITEM_TEST_FALSE));
    }

    @Test
    public void get() {
        assertEquals(ITEM_TEST_TRUE, arr.get(INDEX_TEST));
    }

    @Test
    public void equals() {
        ArrayListInteger list = new ArrayListInteger(5);
        list.add(8);
        list.add(9);
        list.add(2);
        list.add(4);
        assertTrue(arr.equals(list));
    }

    @Test
    public void size() {
        assertEquals(4, arr.size());
    }

    @Test
    public void isEmpty() {
        assertFalse( arr.isEmpty());
    }

    @Test
    public void clear() {
        arr.clear();
        assertEquals(0, arr.size());
    }

    @Test
    public void toArray() {
        Integer[] list = new Integer[4];
        list[0] = 8;
        list[1] = 9;
        list[2] = 2;
        list[3] = 4;
        assertArrayEquals(list, arr.toArray());
    }
}