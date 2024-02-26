package Diary;


import Diary.Exceptions.DiaryNotFoundException;
import Diary.Exceptions.IncorrectPasswordException;

import java.util.ArrayList;

public class Diaries {

    private final ArrayList<Diary> diaries = new ArrayList<Diary>();

    public void add(String username, String password) {
        Diary diary = new Diary(username,password);
        diaries.add(diary);
    }

    public int getNumberOfDiaries() {
        return diaries.size();
    }


    public Diary findByUsername(String username) {
        Diary foundDiary = null ;
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) foundDiary = diary;
        }
        checkDiary(foundDiary);
        return foundDiary;
    }

    public void delete(String username, String password) {
        Diary diary = findByUsername(username);
        checkDiary(diary);

        if (diary.validate(password)) {
            if (diary.validateUsername(username)) diaries.remove(diary);
            else throw new DiaryNotFoundException("Username does not exist");
        }
        else throw new IncorrectPasswordException("Incorrect Password");
    }

    private void checkDiary(Diary diary) {
        if (diary == null) throw new DiaryNotFoundException("Diary Not Found");
    }
}
