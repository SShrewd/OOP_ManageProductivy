package dao;

import model.Receipt;

import java.util.List;

public class RecepitDAO extends ServiceDAO<Receipt>{

    public void insert(long total){
        insert("INSERT INTO receipt(total) values(?)", total);
    }

    public List<Receipt> getFromDate(String str1, String str2){

        String sql = "SELECT * FROM Receipt where order_date >= ? and order_date <= ?";
        return query(sql, new ReceiptMapper(), str1, str2);
    }
}
