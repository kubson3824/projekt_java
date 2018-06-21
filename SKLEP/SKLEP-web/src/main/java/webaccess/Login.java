package webaccess;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;

import akjp.dao.jpa.JpaKlientDao;
import akjp.model.KlientDTO;
import web.util.JSF;

@Named
@ViewScoped
public class Login implements Serializable {

    @Inject
    private Klient klient;

    @EJB
    private JpaKlientDao jpaKlientDao;
    
    private KlientDTO newKlient = new KlientDTO();

    private String username;
    private String password;

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public JpaKlientDao getJpaKlientDao() {
        return jpaKlientDao;
    }

    public void setJpaKlientDao(JpaKlientDao jpaKlientDao) {
        this.jpaKlientDao = jpaKlientDao;
    }

    public KlientDTO getNewKlient() {
        return newKlient;
    }

    public void setNewKlient(KlientDTO newKlient) {
        this.newKlient = newKlient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String added() {
        jpaKlientDao.save(newKlient);
        return "/home.xhtml?faces-redirect=true";
    }

    public void login() throws IOException, ServletException {
        if (jpaKlientDao.findByUsernameAndPassword(username, password) != null) {
            klient.setUsername(username);
            JSF.redirect("home.xhtml");
        } else {
            JSF.addErrorMessage("Invalid credentials");
        }
    }
    // akcja wylogowania
    public void logout() throws IOException {
        JSF.invalidateSession();
        JSF.redirect("home.xhtml");
    }
}
