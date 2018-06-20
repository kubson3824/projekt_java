package akjp.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries(
        {
            @NamedQuery(name = "KlientDTO.findByUsernameAndPassword", query = "select uc from KlientDTO uc where uc.username=:un and uc.password=:pw")
            ,
        @NamedQuery(name = "KlientDTO.findAll", query = "select c from KlientDTO c")
        }
)
@Table(name = "KLIENT", schema = "APP")
public class KlientDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy = "klientDTO", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<UserGroup> userGroups = new LinkedList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public void add(UserGroup userGroup) {
        userGroup.setKlientDTO(this);
        this.userGroups.add(userGroup);
    }

    @Override
    public String toString() {
        return "[" + getId() + "," + username + "," + email + "]";
    }
}
