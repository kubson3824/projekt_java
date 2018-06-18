/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AKJP.projektjava.dao;
import AKJP.projektjava.model.PurchaseDTO;
import java.util.List;

public interface PurchaseDao extends GenericDao<PurchaseDTO,Long>  {
    public List<PurchaseDTO> findAllPurchases(String first, String last);
    public List<PurchaseDTO> findAllPurchasesAll();
}

