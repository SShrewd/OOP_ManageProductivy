package model;

import util.Util;

public class BookProduct extends Product{
    private String publisher;
    private String author;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Nhap nha xuat ban: ");
        publisher = Util.scanner.nextLine();
        System.out.println("Nhap tac gia: ");
        author = Util.scanner.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Nha xuat ban: " + publisher);
        System.out.println("Tac gia: " + author);
    }
}
