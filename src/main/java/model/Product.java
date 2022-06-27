package model;

import util.Util;

public class Product {
    private String id;
    private String name;
    private int amount;
    private double inPrice;
    private double outPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getInPrice() {
        return inPrice;
    }

    public void setInPrice(double inPrice) {
        this.inPrice = inPrice;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public void input(){
        System.out.println("Nhap ten: ");
        name = (Util.scanner.nextLine());
        System.out.println("Nhap so luong: ");
        amount = Integer.parseInt(Util.scanner.nextLine());
        System.out.println("Nhap gia mua vao: ");
        inPrice  = Double.parseDouble(Util.scanner.nextLine());
        System.out.println("Nhap gia ban ra: ");
        outPrice = Double.parseDouble(Util.scanner.nextLine());

    }

    public void output(){
        System.out.println("ID: " + id);
        System.out.println("Ten: " + name);
        System.out.println("So luong: " + amount);
        System.out.println("Gia mua vao: " + inPrice);
        System.out.println("Gia ban ra: " + outPrice);
    }
}
