package model;

import util.Util;

import java.util.List;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private String address;
    private List<Product> productOrder;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<Product> productOrder) {
        this.productOrder = productOrder;
    }

    public void input(){
        System.out.println("Nhap ten: ");
        name = (Util.scanner.nextLine());
        System.out.println("Nhap so dien thoai: ");
        phone = Util.scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        address  = Util.scanner.nextLine();


    }

    public void output(){
        System.out.println("ID: " + id);
        System.out.println("Ten: " + name);
        System.out.println("So dt: " + phone);
        System.out.println("dia chi: " + address);
    }
}
