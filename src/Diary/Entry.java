package Diary;

import java.time.LocalDate;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDate date;

    public Entry(int id,String title,String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    void setTitle(String title) {
        this.title = title;
    }

     void setBody(String body) {
        this.body = body;
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }

    public String toString(){
        return String.format("%d%n%s",id,body);
    }
}
