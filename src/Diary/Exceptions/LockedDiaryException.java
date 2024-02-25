package Diary.Exceptions;

public class LockedDiaryException extends RuntimeException{
    public LockedDiaryException(String message){
        super(message);
    }
}
