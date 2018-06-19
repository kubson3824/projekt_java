/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akjp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author student
 */
@Entity
@Table(name="PURCHASE_ITEM", schema="APP")
public class PurchaseItemDTO extends AbstractDTO {
    @ManyToOne
    private ProductDTO product;
    @ManyToOne
    private ZamowienieDTO zamowienie;
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

    public ZamowienieDTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDTO zamowienie) {
        this.zamowienie  = zamowienie;
    }
    
}
