package akjp.dao.jpa;

import akjp.model.ProductDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import akjp.dao.ProductDao;

@Stateless
public class JpaProductDao extends GenericJpaDao<ProductDTO, Long> implements ProductDao {
    @PersistenceContext(unitName = "AKJP_ejb_1.0PU")
    private EntityManager em;
    
    @Override
    public List<ProductDTO> findAll() {
        TypedQuery<ProductDTO> q = em.createNamedQuery("ProductDTO.findAll", ProductDTO.class);
        return q.getResultList();
    }
}
