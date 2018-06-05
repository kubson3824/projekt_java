/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package akjp.projektjava.dao;
import java.util.List;
import akjp.projektjava.model.PurchaseDTO;

public interface PurchaseDao extends GenericDao<PurchaseDTO,Long>  {
    public List<PurchaseDTO> findAllPurchases(String first, String last);
    public List<PurchaseDTO> findAllPurchasesAll();
}

