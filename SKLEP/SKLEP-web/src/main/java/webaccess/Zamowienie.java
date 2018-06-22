package webaccess;

import akjp.dao.PurchaseItemDao;
import akjp.dao.ZamowienieDao;
import akjp.model.PurchaseItemDTO;
import akjp.model.ZamowienieDTO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "zamowienie")
@SessionScoped
public class Zamowienie implements Serializable {

    @EJB
    private ZamowienieDao dao;

    @EJB
    private PurchaseItemDao dao2;

    private ZamowienieDTO newZamowienie = new ZamowienieDTO();
    private PurchaseItemDTO newPid = new PurchaseItemDTO();

    public PurchaseItemDao getDao2() {
        return dao2;
    }

    public void setDao2(PurchaseItemDao dao2) {
        this.dao2 = dao2;
    }

    public PurchaseItemDTO getNewPid() {
        return newPid;
    }

    public void setNewPid(PurchaseItemDTO newPid) {
        this.newPid = newPid;
    }

    public void onPurchaeseItemAdd() {
        newPid = new PurchaseItemDTO();
    }

    public void added2() {
        dao2.save(newPid);
    }

    public List<ZamowienieDTO> getZamowienies() {
        return dao.findAll();
    }

    public ZamowienieDao getDao() {
        return dao;
    }

    public void setDao(ZamowienieDao dao) {
        this.dao = dao;
    }

    public ZamowienieDTO getNewZamowienie() {
        return newZamowienie;
    }

    public void setNewZamowienie(ZamowienieDTO newZamowienie) {
        this.newZamowienie = newZamowienie;
    }

    public void onZamowienieAdd() {
        newZamowienie = new ZamowienieDTO();
    }

    public String added() {
        dao.save(newZamowienie);
        RequestContext.getCurrentInstance().execute("PF('productDlg').hide()");
        return "/zamowienia.xhtml?faces-redirect=true";
    }

    public String onRemove(ZamowienieDTO z) {
        dao.remove(z.getId());
        return "/zamowienia.xhtml?faces-redirect=true";
    }
}
