package akjp.dao.jpa;

import akjp.dao.KlientDao;
import akjp.model.KlientDTO;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@DataSourceDefinition(
        name = "java:global/AKJBbaza",
        className = "org.apache.derby.jdbc.ClientDataSource",
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
public class JpaKlientDao implements KlientDao {

    @PersistenceContext(unitName = "AKJP_ejb_1.0PU")
    private EntityManager em;

    @Override
    public void save(KlientDTO kli) {
        em.persist(kli);
    }

    @Override
    public KlientDTO update(KlientDTO b) {
        return em.merge(b);
    }

    @Override
    public void remove(Long id) {
        em.remove(em.getReference(KlientDTO.class, id));
    }

    @Override
    public List<KlientDTO> findAll() {
        TypedQuery<KlientDTO> q = em.createNamedQuery("KlientDTO.findAll", KlientDTO.class);
        return q.getResultList();
    }
}
