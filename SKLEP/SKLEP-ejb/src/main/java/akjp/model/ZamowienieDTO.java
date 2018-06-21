package akjp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name = "ZamowienieDTO.findAll", query = "select c from ZamowienieDTO c"),
@NamedQuery(name = "ZamowienieDTO.findByUser", query = "select c from ZamowienieDTO c where c.klient=:klient"),
})
@Table(name = "ZAMOWIENIE", schema = "APP")
public class ZamowienieDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private KlientDTO klient;
    @OneToMany(mappedBy = "zamowienie", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<PurchaseItemDTO> purchaseItems = new LinkedList<PurchaseItemDTO>();
    private Date data_zamowienia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KlientDTO getKlient() {
        return klient;
    }

    public void setKlient(KlientDTO klient) {
        this.klient = klient;
    }

    public void addPurchaseItem(PurchaseItemDTO pi) {
        purchaseItems.add(pi);
        pi.setZamowienie(this);
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }

    public Date getDataZamowienia() {
        return data_zamowienia;
    }

    public void setDataZamowienia(Date data_zamowienia) {
        this.data_zamowienia = data_zamowienia;
    }

}
