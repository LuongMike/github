/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author PC
 */
public class BookDTO {
    private String bookId;
    private String title;
    private String author;
    private int publishYear;
    private double price;
    private int quantity;

    public BookDTO() {
    }

    public BookDTO(String bookId, String title, String author, int publishYear, double price, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "bookId=" + bookId + ", title=" + title + ", author=" + author + ", publishYear=" + publishYear + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    
}
