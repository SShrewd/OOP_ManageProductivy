package dao;

import model.BookProduct;
import model.MovieProduct;
import model.MusicProduct;
import model.Product;

import java.util.List;

public class ProductDAO extends ServiceDAO<Product>{
    public void insert(Product product){
        if(product instanceof BookProduct){
            String sql = "INSERT INTO book(name, amount, inPrice, outPrice, publisher, author) values(?,?,?,?,?,?)";
            insert(sql, product.getName(), product.getAmount(), product.getInPrice(), product.getOutPrice(), ((BookProduct) product).getPublisher(), ((BookProduct) product).getAuthor());
        }
        if(product instanceof MovieProduct){
            String sql = "INSERT INTO movie(name, amount, inPrice, outPrice, actor, author) values(?,?,?,?,?,?)";
            insert(sql, product.getName(), product.getAmount(), product.getInPrice(), product.getOutPrice(), ((MovieProduct) product).getActor(), ((MovieProduct) product).getAuthor());
        }

        if(product instanceof MusicProduct){
            String sql = "INSERT INTO music(name, amount, inPrice, outPrice, singer, category) values(?,?,?,?,?,?)";
            insert(sql, product.getName(), product.getAmount(), product.getInPrice(), product.getOutPrice(), ((MusicProduct) product).getSinger(), ((MusicProduct) product).getCategory());
        }
    }

    public Product getById(int id, Class<?> c){
        String sql = "SELECT * FROM %s WHERE id = ?";
        String table = null;
        IMapper<Product> mapper = new ProductMapper();
        if(c.equals(MovieProduct.class)){
            table = "movie";
        }
        if(c.equals(MusicProduct.class)){
            table = "music";
        }
        if(c.equals(BookProduct.class)){
            table = "book";
        }
        String SQL = String.format(sql, table);
        List<Product> list = query(SQL, mapper, id);
        return list.isEmpty()? null : list.get(0);
    }

    public List<Product> getAll(Class<?> c){
        String sql = "SELECT * FROM %s";
        String table = null;
        IMapper<Product> mapper = new ProductMapper();
        if(c.equals(MovieProduct.class)){
            table = "movie";
        }
        if(c.equals(MusicProduct.class)){
            table = "music";
        }
        if(c.equals(BookProduct.class)){
            table = "book";
        }
        String SQL = String.format(sql, table);
        List<Product> list = query(SQL, mapper);
        return list;
    }
}
