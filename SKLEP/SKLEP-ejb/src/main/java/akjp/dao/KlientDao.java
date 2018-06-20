package akjp.dao;

import akjp.model.KlientDTO;
import java.util.List;

public interface KlientDao {

    public void save(KlientDTO kli);

    public KlientDTO update(KlientDTO b);

    public void remove(Long id);

    public List<KlientDTO> findAll();
}
