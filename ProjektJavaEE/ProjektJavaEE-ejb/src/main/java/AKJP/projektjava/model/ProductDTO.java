package AKJP.projektjava.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT", schema="APP")
public class ProductDTO extends AbstractDTO {
   
    private String nazwa;
    private Double cena;
    private String kategoria;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }


    
    @Override
    public String toString() {
        return "["+getId()+", "+nazwa+", "+cena+", "+kategoria;
    }
}
