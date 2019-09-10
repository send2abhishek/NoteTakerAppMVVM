package com.attra.notetakerappmvvm.Models;

import java.util.Date;

public class NoteEntity {

    private int id;
    private Date date;
    private String text;

    public NoteEntity(int id, Date date, String text) {
        this.id = id;
        this.date = date;
        this.text = text;
    }

    public NoteEntity(Date date, String text) {
        this.date = date;
        this.text = text;
    }

    public NoteEntity() {
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
