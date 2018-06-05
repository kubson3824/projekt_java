package akjp.projektjavaee.clientapp;

import javax.naming.NamingException;
import akjp.projektjava.dao.ProductDao;
import akjp.projektjava.dao.jpa.JpaProductDao;
import akjp.projektjava.model.ProductDTO;
import java.text.ParseException;
import java.util.List;

public class Clientapp {

    public static void main(String[] args) throws NamingException, ParseException {

        System.out.println("Sklep internetowy");
        System.out.println("");
        
        ProductDao pdao = new JpaProductDao();

        createProduct(pdao, "niekonik", 400.09, "zabawka");

        List<ProductDTO> ProductL = pdao.findProductsBetween(100.00, 700.00);
        System.out.println(ProductL);
    }

    public static void createProduct(ProductDao pdao, String name, Double price, String type) {
        ProductDTO p1 = new ProductDTO();
        p1.setName(name);
        p1.setPrice(price);
        p1.setType(type);
        pdao.save(p1);
    }
}
