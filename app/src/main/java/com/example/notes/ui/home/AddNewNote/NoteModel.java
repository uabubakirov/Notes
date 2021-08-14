package com.example.notes.ui.home.AddNewNote;

public class NoteModel {
    String text,time;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public NoteModel(String text, String time) {
        this.text = text;
        this.time = time;
    }
}
