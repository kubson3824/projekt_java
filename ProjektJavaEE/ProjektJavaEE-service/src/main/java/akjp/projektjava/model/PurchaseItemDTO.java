/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package akjp.projektjava.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author m
 */
@Entity
@Table(name="PURCHASE_ITEM", schema="APP")
public class PurchaseItemDTO extends AbstractDTO {
    @ManyToOne
    private ProductDTO product;
    @ManyToOne
    private PurchaseDTO purchase;
    private Integer quantity;

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PurchaseDTO getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDTO purchase) {
        this.purchase = purchase;
    }
}
