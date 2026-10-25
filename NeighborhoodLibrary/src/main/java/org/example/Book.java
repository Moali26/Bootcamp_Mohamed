package org.example;

public class Book {

    //put in your properties, constructor, getters/setters
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut ;
    private String checkedOutTo;


    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedout) {
        isCheckedOut = checkedout;
    }

    public String getCheckOutTo() {
        return checkedOutTo;
    }

    public void setCheckOutTo(String checkOutTo) {
        this.checkedOutTo = checkOutTo;
    }

    //these are the custom methods you'll need to check in and
    //check out a book.
    public void checkOut(String name) {
        //switch the boolean to true or false
        //need to update checkedOutTo to the nam//
        isCheckedOut = true;
        checkedOutTo = name;
    }

    public void checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";
    }
}