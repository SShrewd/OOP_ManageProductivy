package view;

import dao.ProductDAO;
import dao.RecepitDAO;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------MENU-----------------------");
            System.out.println("1. Quan ly san pham");
            System.out.println("2. Thanh toan cho khach hang");
            System.out.println("3. Thong ke doanh thu theo khoang thoi gian");
            System.out.println("4. Chi phi khac");

            System.out.println("-----------------------------------------------");
            System.out.println("Ban chon: ");

            ProductDAO productDAO = new ProductDAO();
            RecepitDAO recepitDAO = new RecepitDAO();
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:{
                    System.out.println("   a. Them");
                    System.out.println("   b. Sua");
                    System.out.println("   c. Xoa");
                    System.out.println("Ban chon: ");
                    String ctr = scanner.nextLine();
                    char c = ctr.charAt(0);
                    switch (c){
                        case 'a':{
                            System.out.println("Nhap loai(1-Nhac/2-Phim/3-Sach)");
                            int cat = Integer.parseInt(scanner.nextLine());
                            Product product = null;
                            if(cat == 1)
                                product = new MusicProduct();

                            if(cat == 2)
                                product = new MovieProduct();

                            if(cat == 3)
                                product = new BookProduct();

                            product.input();
                            productDAO.insert(product);
                        }
                        case 'b':{

                        }
                        case 'c':{

                        }
                    }
                    break;
                }
                case 2:{
                    System.out.println("Nhap thong tin khach hang: ");
                    Customer customer = new Customer();
                    customer.input();

                    System.out.println("Nhap so luong san pham mua: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    List<Product> products = new ArrayList<>();

                    for(int i=0; i<n; i++){
                        System.out.print("Nhap id san pham thu " + i + ": ");
                        int ids = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhap loai san pham(1-Nhac/2-Phim/3-Sach):");
                        int cats = Integer.parseInt(scanner.nextLine());

                        Product product = null;
                        if(cats == 1){
                             product = productDAO.getById(ids, MusicProduct.class);
                        }
                        if(cats == 2){
                            product = productDAO.getById(ids, MovieProduct.class);
                        }
                        if(cats == 3){
                            product = productDAO.getById(ids, BookProduct.class);
                        }
                        products.add(product);
                    }

                    products.forEach(p -> p.output());

                    long total = 0;
                    for(Product p: products){
                        total += p.getOutPrice();
                    }

                    recepitDAO.insert(total);
                    System.out.println("=> TONG HOA DON: " + total + " USD");
                }
                case 3:{
                    System.out.println("Nhap ngay bat dau(dd/MM/yyyy): ");
                    String dateFrom = scanner.nextLine();
                    System.out.println("Nhap ngay ket thuc(dd/MM/yyyy): ");
                    String dateTo = scanner.nextLine();

                    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date date1 = simpleDateFormat.parse(dateFrom);
                        Date date2 = simpleDateFormat.parse(dateTo);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        List<Receipt> receipts = recepitDAO.getFromDate(dateFormat.format(date1), dateFormat.format(date2));

                        long total = 0;
                        for(Receipt receipt: receipts){
                            total += receipt.getTotal();
                        }
                        System.out.println("=> DOANH THU: " + total);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
            }
        }
    }
}
