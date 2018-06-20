package akjp.dao.jpa;

import akjp.model.KlientDTO;
import javax.ejb.Stateless;

@Stateless
public class JpaKlientDao extends AbstractDao<KlientDTO,Long>{

    public JpaKlientDao() {
        super(KlientDTO.class);
    }

    public KlientDTO findByUsernameAndPassword(String username, String password) {
        return em.createNamedQuery("KlientDTO.findByUsernameAndPassword", KlientDTO.class)
                .setParameter("un", username)
                .setParameter("pw", password)
                .getResultList().stream().findFirst().orElse(null);
    }
}
