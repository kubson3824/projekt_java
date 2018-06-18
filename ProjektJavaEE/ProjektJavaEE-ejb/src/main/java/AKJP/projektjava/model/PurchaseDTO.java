package AKJP.projektjava.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
@NamedQuery(name = "PurchaseDTO.findAllPurchases", query = "select p  from PurchaseDTO p where p.customer.firstName = :first and p.customer.lastName = :last"),
@NamedQuery(name = "PurchaseDTO.findAllPurchasesAll", query = "select DISTINCT e from PurchaseDTO e left join e.purchaseItems c")
})
@Entity
@Table(name="PURCHASE", schema="APP")
public class PurchaseDTO extends AbstractDTO {
    
    @ManyToOne
    private CustomerDTO customer;
    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<PurchaseItemDTO> purchaseItems = new LinkedList<PurchaseItemDTO>();
    private String miejsce;
    private Date data;

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
    public void addPurchaseItem(PurchaseItemDTO pi) {
        purchaseItems.add(pi);
        pi.setPurchase(this);
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }
    
    public String getMiejsce(){
        return miejsce;
    }
    
    public void setMiejsce(String miejsce){
        this.miejsce=miejsce;
    }
    
    public Date getData(){
        return data;
    }
    
    public void setData(Date data){
        this.data=data;
    } 
}