/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package akjp.projektjava.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import akjp.projektjava.dao.ProductDao;
import akjp.projektjava.model.ProductDTO;

/**
 *
 * @author user
 */
public class JpaProductDao extends GenericJpaDao<ProductDTO, Long> implements ProductDao {

    @Override
    public List<ProductDTO> findProductsBetween(Double a, Double b) {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> r = em.createNamedQuery("ProductDTO.findProductBetween", ProductDTO.class);
        r.setParameter("min", a);
        r.setParameter("max", b);
        return r.getResultList();
    }

    @Override
    public List<ProductDTO> findMostexpensiveProduct() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> s = em.createNamedQuery("ProductDTO.findMostexpensiveProduct", ProductDTO.class);
        return s.getResultList();
    }

    @Override
    public List<ProductDTO> findProductNoPurchases() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> s = em.createNamedQuery("ProductDTO.findProductNoPurchases", ProductDTO.class);
        return s.getResultList();
    }

    @Override
    public List<ProductDTO> findMostBought() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> s = em.createNamedQuery("ProductDTO.findMostBought", ProductDTO.class);
        return s.getResultList();
    }

    @Override
    public void changePrice(Double c) {
        double d = 1 + (c * 0.01);
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<ProductDTO> r = em.createNamedQuery("ProductDTO.changePrice", ProductDTO.class);
        r.setParameter("chprice", d);
        r.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void editProduct(String name, String newname, Long price, String type) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<ProductDTO> r = em.createNamedQuery("ProductDTO.editProduct", ProductDTO.class);
        r.setParameter("name", name);
        r.setParameter("chname", newname);
        r.setParameter("chprice", price);
        r.setParameter("chtype", type);
        r.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public List<ProductDTO> findProduct(String name, String type) {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> r = em.createNamedQuery("ProductDTO.findProduct", ProductDTO.class);
        r.setParameter("name", name);
        r.setParameter("type", type);
        return r.getResultList();
    }
    
    @Override
    public List<ProductDTO> showAll() {
        EntityManager em = getEntityManager();
        TypedQuery<ProductDTO> r = em.createNamedQuery("ProductDTO.showAll", ProductDTO.class);
        return r.getResultList();
    }

}
