package akjp.projektjava.dao;
import java.util.List;
import akjp.projektjava.model.Client;

public interface ClientDao  {
    void save(Client t);
    void delete (Client t);
    void update (Client t);
    Client findById(Integer id);
    List<Client> findAll();
}
