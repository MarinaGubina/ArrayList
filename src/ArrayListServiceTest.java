import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListServiceTest {

    private final ArrayListService arrayList = new ArrayListService(5);;

    @BeforeEach
    public void setUp(){
        arrayList.add("winter");
        arrayList.add("spring");
        arrayList.add("summer");
        arrayList.add("autumn");
    }

    @Test
    public void shouldAddString(){
        String actual = arrayList.add("spring");
        assertEquals("spring",actual);
    }

    @Test
    public void shouldAddWithIndex() {
        assertEquals(arrayList.add(1,"test"), "test");
    }

    @Test
    public void set() {
        assertEquals(arrayList.set(1,"test"),"test");
    }

    @Test
    public void remove() {
        assertEquals(arrayList.remove("winter"), "winter");
    }

    @Test
    public void removeWithIndex() {
        arrayList.remove(2);
    }

    @Test
    public void shouldTrueContains() {
        assertTrue(arrayList.contains("autumn"));
    }

    @Test
    public void shouldFalseContains() {
        assertFalse(arrayList.contains("tttt"));
    }

    @Test
    public void indexOf() {
        assertEquals(1, arrayList.indexOf("spring"));
    }


    @Test
    public void lastIndexOf() {
        assertEquals(1, arrayList.lastIndexOf("spring"));
    }

    @Test
    public void shouldReturnConstantIndexOf() {
        assertEquals(-1, arrayList.indexOf("sp"));
    }

    @Test
    public void get() {
        assertEquals("summer", arrayList.get(2));
    }

    @Test
    public void equals() {
        ArrayListService list = new ArrayListService(5);
        list.add("winter");
        list.add("spring");
        list.add("summer");
        list.add("autumn");
        assertTrue(arrayList.equals(list));
    }

    @Test
    public void size() {
        assertEquals(4, arrayList.size());
    }

    @Test
    public void isEmpty() {
        assertFalse( arrayList.isEmpty());
    }

    @Test
    public void clear() {
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void toArray() {
        String[] list = new String[4];
        list[0] = "winter";
        list[1] = "spring";
        list[2] = "summer";
        list[3] = "autumn";
        assertArrayEquals(list, arrayList.toArray());
    }


}
