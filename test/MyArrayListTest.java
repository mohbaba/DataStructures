import ArrayList.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {


    @BeforeEach
    public void setup(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());
    }
    @Test
    public void testThatListIsEmpty(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testThatListIsNotEmpty() {
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("mohbaba");
        assertFalse(stringList.isEmpty());
    }


    @Test
    public void testThatOneItemCanBeAddedToList(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("mohbaba");
        assertEquals(1,stringList.getSize());

        assertFalse(stringList.isEmpty());
    }

    @Test
    public void testThatTwoItemsCanBeAddedToList(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("mohbaba");
        stringList.add("Pain");
        assertEquals(2,stringList.getSize());

        assertFalse(stringList.isEmpty());
    }

    @Test
    public void testThatTwoItemsCanBeAddedToListAndOneCanBeRemoved(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("mohbaba");
        stringList.add("Pain");
        assertEquals(2,stringList.getSize());

        stringList.remove("mohbaba");
        assertEquals(1,stringList.getSize());
        assertFalse(stringList.isEmpty());


    }

    @Test
    public void testThatGetTheIndexOfAnElementInTheArray(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("mohbaba");
        stringList.add("Pain");
        assertEquals("Pain",stringList.get(2));
        assertEquals("mohbaba",stringList.get(1));




    }

    @Test
    public void addXYZ_RemoveYAndZShiftsToYPositionTest(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("mohbaba");
        stringList.add("Pain");
        stringList.add("magnus");
        assertEquals(3,stringList.getSize());

        stringList.remove("Pain");
        assertEquals(2,stringList.getSize());
        
        assertEquals("magnus",stringList.get(2));

        assertNotEquals("Pain",stringList.get(2));

    }

    @Test
    public void addThreeElements_tryToGetTheFourthAndFailsTest(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("Moh");
        stringList.add("Abike");
        stringList.add("Beejay");
        assertEquals(3,stringList.getSize());

//        assertEquals(null,stringList.get(4));
        assertThrows(IndexOutOfBoundsException.class,()->stringList.get(5));

    }
    @Test
    public void addXYZ_RemoveYByIndexAndZShiftsToYPositionTest(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("Moh");
        stringList.add("Abike");
        stringList.add("Beejay");
        assertEquals(3,stringList.getSize());

        stringList.remove(2);
        assertEquals(2,stringList.getSize());
        assertEquals("Beejay",stringList.get(2));
            }

    @Test
    public void addFourElementsTest_lengthOfActualArrayIncreases(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("Moh");
        stringList.add("Dayo");
        stringList.add("Beejay");
        stringList.add("Jumoke");
        assertEquals(4,stringList.getSize());

        assertEquals("Jumoke",stringList.get(4));
    }

    @Test
    public void testGetElementAtIndexOutOfArrayListBounds(){
        MyArrayList stringList = new MyArrayList();
        assertTrue(stringList.isEmpty());

        stringList.add("Beejay");
        stringList.add("Jumoke");
        stringList.add("Dayo");
        stringList.add("Mohbaba");
        assertEquals(4,stringList.getSize());

        assertThrows(IndexOutOfBoundsException.class,()->stringList.get(5));
        assertThrows(IndexOutOfBoundsException.class,()->stringList.get(0));

    }
}
