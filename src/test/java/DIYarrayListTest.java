import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

public class DIYarrayListTest {

    @Test
    void addTest() {
        List<Integer> list = new DIYarrayList<>();
        for (int i = 0; i < 22; i++) {
            list.add(i);
        }
        assertEquals(22, list.size());
    }

    @Test
    void addAllTest() {
        List<Integer> list = new DIYarrayList<>();
        Integer[] list2 = {1, 2, 3, 4};
        boolean isAdded = Collections.addAll(list, list2);
        assertTrue(isAdded);
        assertEquals(4, list.size());
    }

    @Test
    void addAllOneByOneTest() {
        List<Integer> list = new DIYarrayList<>();
        boolean isAdded = Collections.addAll(list, 1, 3, 5);
        assertTrue(isAdded);
        assertEquals(3, list.size());
    }

    @Test
    void getTest() {
        List<Integer> list = new DIYarrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void sortTest() {
        List<Integer> list = new DIYarrayList<>();
        boolean isAdded = Collections.addAll(list, 1, 3, 5, 2, 4);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i + 1) > list.get(i));
        }
    }

    @Test
    void copyTest() {
        List<Integer> list1 = new DIYarrayList<>();
        Collections.addAll(list1, 1, 2, 3, 4);
        List<Integer> list2 = new DIYarrayList<>();
        Collections.addAll(list2, 5, 6, 7, 8);

        Collections.copy(list1, list2);
        for (int i = 0; i < list1.size(); i++) {
            assertEquals(list1.get(i), list2.get(i));
        }
    }
}
