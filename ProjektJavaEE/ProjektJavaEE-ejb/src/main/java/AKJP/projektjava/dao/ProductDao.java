package AKJP.projektjava.dao;
import java.util.List;
import AKJP.projektjava.model.ProductDTO;

public interface ProductDao extends GenericDao<ProductDTO,Long>  {
    public List<ProductDTO> findProductsBetween(Double a, Double b);
    public List<ProductDTO> findProduct(String name, String type);
    public List<ProductDTO> findMostexpensiveProduct();
    public List<ProductDTO> findProductNoPurchases();
    public List<ProductDTO> findMostBought();
    public void changePrice(Double c);
    public void editProduct (String name, String newname, Long price, String kat);
    public List<ProductDTO> showAll();
}