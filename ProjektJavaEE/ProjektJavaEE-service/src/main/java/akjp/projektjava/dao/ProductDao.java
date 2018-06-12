/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package akjp.projektjava.dao;
import java.util.List;
import akjp.projektjava.model.ProductDTO;

public interface ProductDao extends GenericDao<ProductDTO,Long>  {
    public List<ProductDTO> findProductsBetween(Double a, Double b);
    public List<ProductDTO> findProduct(String name, String type);
    public List<ProductDTO> findMostexpensiveProduct();
    public List<ProductDTO> findProductNoPurchases();
    public List<ProductDTO> findMostBought();
    public void changePrice(Double c);
    public void editProduct (Long id);
}
