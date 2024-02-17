import MySet.MySet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {
    private MySet mySet;

    @BeforeEach
    public void setup(){
        mySet = new MySet();
    }

    @Test
    public void testThatSetCanContainElements(){
        mySet = new MySet();
        assertTrue(mySet.isEmpty());
    }

    @Test
    public void testThatSetCanAddElements(){
        mySet.add(1);
        int expected = 1;
        assertEquals(expected,mySet.getSize());
    }

    @Test
    public void testThatSetCanRemoveElement(){
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.remove(2);

        assertEquals(3,mySet.getSize());
    }

    @Test
    public void removeElementFromSet_GetElementAtTheIndexWhichElementWasRemoved(){
        mySet.add(10);
        mySet.add(20);
        mySet.add(30);
        mySet.add(40);
        mySet.add(50);

        mySet.remove(20);

        assertEquals(30,mySet.get(2));
        assertEquals(40,mySet.get(3));


        assertEquals(4,mySet.getSize());
    }

    @Test
    public void getElementWithNegativeIndexAndFailsTest(){
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        assertThrows(IllegalArgumentException.class,()->mySet.get(-1));
        assertThrows(IllegalArgumentException.class,()->mySet.get(4));

    }

    @Test
    public void getElementWithHighPositiveIndexAndFailsTest(){
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        assertThrows(IllegalArgumentException.class,()->mySet.get(4));

    }

//

}

