package com.twodev.booksfilmslists.models;

public class BookModel {
    private String photo;
    private String BookTitle;

    public BookModel(String bookTitle) {
        BookTitle = bookTitle;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        BookTitle = bookTitle;
    }
}
