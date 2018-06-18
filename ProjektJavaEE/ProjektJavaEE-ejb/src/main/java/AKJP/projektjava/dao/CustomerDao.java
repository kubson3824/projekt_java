/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AKJP.projektjava.dao;
import java.util.List;
import AKJP.projektjava.model.CustomerDTO;

public interface CustomerDao extends GenericDao<CustomerDTO,Long>  {
    public List<CustomerDTO> findCustomerDTOByLastName(String lastName);
}