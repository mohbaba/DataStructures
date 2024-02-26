package Diary;

import Diary.Exceptions.EntryNotFoundException;
import Diary.Exceptions.IncorrectPasswordException;
import Diary.Exceptions.LockedDiaryException;

import java.util.ArrayList;

public class Diary {
    private final String username;
    private String password;
    private boolean isLocked = true;
    private final ArrayList<Entry> entries = new ArrayList<>();

    public Diary(String username, String password){
        this.username = username;
        this.password = password;

    }
    public void unlockDiary(String password) {
        validatePassword(password);
        isLocked = false;
    }

    private void validatePassword(String password){
        if (!this.password.equals(password))throw new IncorrectPasswordException("The password " +
                "you entered is incorrect");
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lockDiary() {
        isLocked = true;
    }

    public int getNumberOfEntries() {
        return entries.size();
    }

    private int generateId(){
        return entries.size();
    }

    private void checkLock(){
        if (isLocked) throw new LockedDiaryException("Diary is locked ");
    }

    public void createEntry(String title,String body){
        checkLock();
        Entry entry = new Entry(generateId(),title,body);
        entries.add(entry);
    }

    public void deleteEntry(int entryId) {
        checkLock();
        Entry entry = findEntryById(entryId);
        validateEntry(entry);
        entries.remove(entry);
    }



    private void validateEntry(Entry entry){
        if (entry == null)throw new EntryNotFoundException("Entry Not Found");
    }
    public Entry findEntryById(int entryId) {
        checkLock();
        for (Entry entry : entries) {
            if (entry.getId() == entryId) {
                return entry;
            }
        }
        return null;
    }

    public boolean validate(String password){
        return this.password.equals(password);
    }

    public void updateEntry(int entryId,String title, String body) {
        checkLock();
        Entry entry = findEntryById(entryId);
        validateEntry(entry);
        entry.setTitle(title);
        entry.setBody(body);
    }


    public String getUsername() {
        return username;
    }

    public boolean validateUsername(String username) {
        return this.username.equals(username);
    }
}
