package com.example.notes.OnBoard;

public class ModelOnBoard {
    String text;
    int image;

    public ModelOnBoard(String text, int image) {
        this.text = text;
        this.image = image;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
