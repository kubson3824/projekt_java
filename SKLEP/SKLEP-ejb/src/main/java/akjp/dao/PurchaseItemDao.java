package akjp.dao;

import akjp.model.PurchaseItemDTO;

public interface PurchaseItemDao {

    public void save(PurchaseItemDTO pro);

    public PurchaseItemDTO update(PurchaseItemDTO b);

    public void remove(Long id);
}
