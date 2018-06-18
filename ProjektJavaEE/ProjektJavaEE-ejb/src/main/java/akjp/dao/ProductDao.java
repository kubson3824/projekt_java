package akjp.dao;

import akjp.model.ProductDTO;
import java.util.List;

public interface ProductDao extends GenericDao<ProductDTO,Long>  {
    public List<ProductDTO> findAll();
}
