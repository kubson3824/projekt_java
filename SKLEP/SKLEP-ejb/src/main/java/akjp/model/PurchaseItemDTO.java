package akjp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASE_ITEM", schema="APP")
public class PurchaseItemDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ProductDTO product;
    @ManyToOne
    private ZamowienieDTO zamowienie;
    private Integer ilosc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
    
    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public ZamowienieDTO getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(ZamowienieDTO zamowienie) {
        this.zamowienie  = zamowienie;
    }
    
}
