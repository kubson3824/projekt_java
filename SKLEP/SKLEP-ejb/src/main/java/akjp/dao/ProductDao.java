package akjp.dao;

import akjp.model.ProductDTO;
import java.util.List;

public interface ProductDao {

    public void save(ProductDTO pro);

    public ProductDTO update(ProductDTO b);

    public void remove(Long id);

    public List<ProductDTO> findAll();
}
