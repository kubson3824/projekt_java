/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package akjp.projektjava.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import akjp.projektjava.dao.CustomerDao;
import akjp.projektjava.model.CustomerDTO;

/**
 *
 * @author user
 */
public class JpaCustomerDao extends GenericJpaDao<CustomerDTO, Long> implements CustomerDao {   
    public List<CustomerDTO> findCustomerDTOByLastName(String lastName){
        EntityManager em = getEntityManager();
        TypedQuery<CustomerDTO> g = em.createNamedQuery("CustomerDTO.findByLastName", CustomerDTO.class);
        g.setParameter("lastName",lastName);
        return g.getResultList();
    }
}
