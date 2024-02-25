package DiaryTests;

import Diary.Diary;
import Diary.Entry;
import Diary.Exceptions.EntryNotFoundException;
import Diary.Exceptions.IncorrectPasswordException;
import Diary.Exceptions.LockedDiaryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    private Diary diary;

    @BeforeEach
    public void setUp(){
        diary = new Diary("username","password" );
    }

    @Test
    public void testDiaryCanBeUnlockedWithPassword(){
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
    }

    @Test
    public void testDiaryCanBeLocked(){
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatDiaryWillThrowExceptionWhenPasswordIsIncorrect(){
        assertThrows(IncorrectPasswordException.class,()->diary.unlockDiary("quentin"));

    }

    @Test
    public void testDiaryCanCreateEntry(){
        diary.unlockDiary("password");
        diary.createEntry("My Day","Interesting Day");
        assertEquals(1,diary.getNumberOfEntries());
    }

    @Test
    public void testDiaryCanDeleteEntry(){
        diary.unlockDiary("password");
        diary.createEntry("Name of the day","I had fun today!");
        System.out.println(diary.getNumberOfEntries());
        diary.deleteEntry(0);
        assertEquals(0,diary.getNumberOfEntries());

    }

    @Test
    public void deleteEntryThatDoesNotExist_ThrowException(){
        diary.unlockDiary("password");
        diary.createEntry("Name of the day","I had fun today!");

        assertThrows(EntryNotFoundException.class,()->diary.deleteEntry(1));

    }

    @Test
    public void createThreeEntries_deleteSecondEntryTestThatTheThirdAndFirstIdAreStillTheSame(){
        diary.unlockDiary("password");
        diary.createEntry("Name of the day","I had fun today!");
        diary.createEntry("Game of the day","I had a fun day!");
        diary.createEntry("Aim of the day","I had one today!");
        diary.deleteEntry(1);
        assertEquals(0,diary.findEntryById(0).getId());
        assertEquals(2,diary.findEntryById(2).getId());

    }

    @Test
    public void createEntryOnDiaryWhenLocked_ThrowExceptionTest(){
        assertThrows(LockedDiaryException.class,()->diary.createEntry("How far?","Im good"));
    }

    @Test
    public void deleteEntryOnDiaryWhenLocked_ThrowExceptionTest(){
         assertThrows(LockedDiaryException.class,()->diary.deleteEntry(0));
    }

    @Test
    public void findEntryInDiaryWhenLocked_ThrowExceptionTest(){
        assertThrows(LockedDiaryException.class,()->diary.findEntryById(0));
    }

    @Test
    public void findAnEntry_WhenTheEntryExists(){
        diary.unlockDiary("password");
        diary.createEntry("Name of the day","I had fun today!");
        assertNotNull(diary.findEntryById(0));
    }

    @Test
    public void findAnEntryThatDoesNotExist_returnNullTest(){
        diary.unlockDiary("password");
        assertNull(diary.findEntryById(3));
    }
    @Test
    public void updateEntryInDiaryWhenLocked_ThrowExceptionTest(){
        assertThrows(LockedDiaryException.class,()->diary.updateEntry(0,"hey","How far"));
    }

    @Test
    public void updateEntryInDiary_EntryChanges(){
        diary.unlockDiary("password");
        diary.createEntry("Mohbaba","Confam");

        Entry entry = diary.findEntryById(0);

        assertEquals("Mohbaba", entry.getTitle());
        diary.updateEntry(0,"Abike","Magnus tilo");

        assertEquals("Abike",entry.getTitle());
        assertEquals("Magnus tilo",entry.getBody());
    }
}
