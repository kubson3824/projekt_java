package akjp.dao.jpa;

import akjp.dao.ZamowienieDao;
import akjp.model.KlientDTO;
import akjp.model.ZamowienieDTO;
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
public class JpaZamowienieDao implements ZamowienieDao {

    @PersistenceContext(unitName = "AKJP_ejb_1.0PU")
    private EntityManager em;

    @Override
    public void save(ZamowienieDTO zam) {
        em.persist(zam);
    }

    @Override
    public ZamowienieDTO update(ZamowienieDTO b) {
        return em.merge(b);
    }

    @Override
    public void remove(Long id) {
        em.remove(em.getReference(ZamowienieDTO.class, id));
    }

    @Override
    public List<ZamowienieDTO> findAll() {
        TypedQuery<ZamowienieDTO> q = em.createNamedQuery("ZamowienieDTO.findAll", ZamowienieDTO.class);
        return q.getResultList();
    }

    @Override
    public List<ZamowienieDTO> findByUser(KlientDTO k) {
        TypedQuery<ZamowienieDTO> q = em.createNamedQuery("ZamowienieDTO.findByUser", ZamowienieDTO.class);
        return q.getResultList();
    }
    
    @Override
    public List<ZamowienieDTO> findByUsername(String username) {
        return em.createNamedQuery("ZamowienieDTO.findByUsername", ZamowienieDTO.class)
                .setParameter("un", username)
                .getResultList();
    }
}
