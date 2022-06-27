package dao;

import model.Customer;
import model.Product;

import java.util.List;

public class OrderDAO extends ServiceDAO<Customer>{

    public void insert(Customer customer){
        String sqlCus = "INSER INTO customer(name, phone, address) values(?,?,?)";
        insert(sqlCus, customer.getName(), customer.getPhone(), customer.getAddress());

        Customer cus = findByPhone(customer.getPhone());
        List<Product> productList = customer.getProductOrder();
        for(Product product: productList){
            String sql = "INSERT INTO orders(customer_id, product_id, category) values(?,?)";
            insert(sql, cus.getId(), product.getId());
        }
    }

    public Customer findByPhone(String phone){
        String sqlCus = "SELECT * FROM customer where phone = ?";
        List<Customer> customers = query(sqlCus, new CustomerMapper(), phone);
        return customers.isEmpty()? null : customers.get(0);
    }

    public List<Customer> findByCustomerID(int id){
        String sqlCus = "SELECT * FROM orders where customer_id = ?";
        return query(sqlCus, new CustomerMapper(), id);
    }
}
