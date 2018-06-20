package akjp.dao;

import akjp.model.ZamowienieDTO;
import java.util.List;

public interface ZamowienieDao {

    public void save(ZamowienieDTO zam);

    public ZamowienieDTO update(ZamowienieDTO b);

    public void remove(Long id);

    public List<ZamowienieDTO> findAll();
}
