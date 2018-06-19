package akjp.dao.jpa;

import akjp.model.ProductDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import akjp.dao.ProductDao;
import javax.annotation.sql.DataSourceDefinition;

@DataSourceDefinition(
        name="java:global/AKJBbaza",
        className="org.apache.derby.jdbc.ClientDataSource",
        minPoolSize = 1,
        initialPoolSize = 1,
        portNumber = 1527,
        serverName = "localhost",
        user = "app",
        password = "app",
        databaseName = "AKJP",
        properties = {"connectionAttributes=;create=true"}       
)
@Stateless
public class JpaProductDao implements ProductDao {

    @PersistenceContext(unitName = "AKJP_ejb_1.0PU")
    private EntityManager em;

    @Override
    public void save(ProductDTO pro) {
        em.persist(pro);
    }

    @Override
    public ProductDTO update(ProductDTO b) {
        return em.merge(b);
    }

    @Override
    public void remove(Long id) {
        em.remove(em.getReference(ProductDTO.class, id));
    }

    @Override
    public List<ProductDTO> findAll() {
        TypedQuery<ProductDTO> q = em.createNamedQuery("ProductDTO.findAll", ProductDTO.class);
        return q.getResultList();
    }
}
