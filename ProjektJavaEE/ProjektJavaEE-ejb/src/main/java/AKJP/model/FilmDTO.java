/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AKJP.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author student
 */
@Entity
@Table(name="PRODUCT", schema="APP")
public class FilmDTO extends AbstractDTO {
   
    private String title;
    private String director;
    private Double price;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDirector(){
    return director;
    }
    public void setDirector(String director){
    this.director=director;
    }
    
    

     @Override
    public String toString() {
        return "["+getId()+","+director+","+price;
    }
}
