package akjp.dao;

import akjp.model.ZamowienieDTO;
import akjp.model.KlientDTO;
import java.util.List;

public interface ZamowienieDao {

    public void save(ZamowienieDTO zam);

    public ZamowienieDTO update(ZamowienieDTO b);

    public void remove(Long id);

    public List<ZamowienieDTO> findAll();
    
    public List<ZamowienieDTO> findByUser(KlientDTO k);
    
    public List<ZamowienieDTO> findByUsername(String username);
}
