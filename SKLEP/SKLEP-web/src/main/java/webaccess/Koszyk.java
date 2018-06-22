package webaccess;

import akjp.dao.ZamowienieDao;
import akjp.dao.jpa.JpaKlientDao;
import akjp.model.KlientDTO;
import akjp.model.ZamowienieDTO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "koszyk")
@SessionScoped

public class Koszyk implements Serializable {

    @EJB
    private ZamowienieDao dao;
    @EJB
    private JpaKlientDao jpaKlientDao;

    private KlientDTO klient;

    private ZamowienieDTO newZamowienie = new ZamowienieDTO();

    public List<ZamowienieDTO> getZamowienies(String username) {
        klient = jpaKlientDao.findByUsername(username);
        System.out.println(klient.getUsername());
        return dao.findByUsername(username);
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

    public ZamowienieDTO getNewZamowienieDTO() {
        return newZamowienie;
    }

    public void setNewZamowienieDTO(ZamowienieDTO newZamowienie) {
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
