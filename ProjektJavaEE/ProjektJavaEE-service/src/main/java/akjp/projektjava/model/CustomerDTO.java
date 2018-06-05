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
@NamedQuery(name = "CustomerDTO.findByLastName", query = "select c from CustomerDTO c where c.lastName=:lastName"),
@NamedQuery(name = "CustomerDTO.findByFirstName", query = "select c from CustomerDTO c where c.firstName=:firstName")
})
@Entity
@Table(name="CUSTOMER", schema="APP")
public class CustomerDTO extends AbstractDTO {
   
    private String firstName;
    private String lastName;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "["+getId()+","+firstName+","+lastName+","+email+"]";
    }
}
