/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package akjp.projektjava.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
@NamedQuery(name = "ProductDTO.findProductBetween", query = "select c from ProductDTO c where c.price between :min and :max"),
@NamedQuery(name = "ProductDTO.findMostexpensiveProduct", query = "select c from ProductDTO c where c.price >= ALL(select d.price from ProductDTO d)"),
@NamedQuery(name = "ProductDTO.findProductNoPurchases", query = "select c from ProductDTO c where c.id not in(select d.product.id from PurchaseItemDTO d)"),
@NamedQuery(name = "ProductDTO.findMostBought", query = "select c from ProductDTO c where c.id in(select d.product.id from PurchaseItemDTO d group by d.product.id having SUM(d.quantity)>=ALL(select SUM(e.quantity) from PurchaseItemDTO e group by e.product.id))"),
@NamedQuery(name = "ProductDTO.changePrice", query = "update ProductDTO d set d.price = d.price*:chprice"),
@NamedQuery(name = "ProductDTO.editProduct", query = "update ProductDTO d set d.price = :chprice, d.name=:chname, d.type=:chtype where d.name=:name"),
@NamedQuery(name = "ProductDTO.findProduct", query = "select c from ProductDTO c where c.name=:name and c.type=:type"),
@NamedQuery(name = "ProductDTO.showAll", query = "select c from ProductDTO c")
})
@Entity
@Table(name="PRODUCT", schema="APP")
public class ProductDTO extends AbstractDTO {
   
    private String name;
    private Double price;
    private String type;

    public ProductDTO() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
     @Override
    public String toString() {
        return "["+getId()+", "+name+", "+price+", "+type;
    }
}
