package webaccess;

import akjp.dao.ZamowienieDao;
import akjp.model.ZamowienieDTO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "zamowienie")
@SessionScoped
public class Zamowienie implements Serializable{
    @EJB
    private ZamowienieDao dao;
    
    private ZamowienieDTO newZamowienie = new ZamowienieDTO();

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
    
    public String onRemove(ZamowienieDTO z){
        dao.remove(z.getId());
        return "/zamowienia.xhtml?faces-redirect=true";
    }
}