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
    public void addProduct(String name, Double price, String type) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<ProductDTO> r = em.createNamedQuery("ProductDTO.addProduct", ProductDTO.class);
        r.setParameter("name", name);
        r.setParameter("price", price);
        r.setParameter("type", type);
        r.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void editProduct(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
