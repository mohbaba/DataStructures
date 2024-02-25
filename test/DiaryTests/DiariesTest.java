package DiaryTests;

import Diary.Diaries;
import Diary.Exceptions.DiaryNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {

    private Diaries diaries;
    @BeforeEach
    public void setup(){
         diaries = new Diaries();
    }

    @Test
    public void addDiaryTest(){
        diaries.add("username","password");
        assertEquals(1,diaries.getNumberOfDiaries());
    }

    @Test
    public void findDiaryByUsernameTest(){
        diaries.add("username","password");
        diaries.add("username1","password1");
        assertNotNull(diaries.findByUsername("username1"));

    }

    @Test
    public void findDiaryByUsernameThatDoesNotExistTest(){
        assertThrows(DiaryNotFoundException.class,()->diaries.findByUsername("username20"));

    }

    @Test
    public void deleteDiary(){
        diaries.add("Mohababa","bossman");
        diaries.add("Promises","Bagslikas");
        diaries.delete("Mohababa","bossman");
        assertEquals(1,diaries.getNumberOfDiaries());
        assertNotNull(diaries.findByUsername("Promises"));
    }

}
