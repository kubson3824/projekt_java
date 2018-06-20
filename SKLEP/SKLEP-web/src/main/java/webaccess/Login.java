package webaccess;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;

import akjp.dao.jpa.JpaKlientDao;
import web.util.JSF;

@Named
@ViewScoped
public class Login implements Serializable {

    @Inject
    private Klient klient;

    @EJB
    private JpaKlientDao jpaKlientDao;

    private String username;
    private String password;

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
