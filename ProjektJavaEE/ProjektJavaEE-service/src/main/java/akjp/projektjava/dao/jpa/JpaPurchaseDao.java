/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package akjp.projektjava.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import akjp.projektjava.dao.PurchaseDao;
import akjp.projektjava.model.PurchaseDTO;

/**
 *
 * @author user
 */
public class JpaPurchaseDao extends GenericJpaDao<PurchaseDTO, Long> implements PurchaseDao {
    @Override
    public List<PurchaseDTO> findAllPurchases(String first, String last){
        EntityManager em = getEntityManager();
        TypedQuery<PurchaseDTO> r = em.createNamedQuery("PurchaseDTO.findAllPurchases", PurchaseDTO.class);
        r.setParameter("first", first);
        r.setParameter("last", last);
        return r.getResultList();
    }
    @Override
    public List<PurchaseDTO> findAllPurchasesAll(){
        EntityManager em = getEntityManager();
        TypedQuery<PurchaseDTO> s = em.createNamedQuery("PurchaseDTO.findAllPurchasesAll", PurchaseDTO.class);
        return s.getResultList();
    }
}

