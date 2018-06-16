package AKJP;

import javax.ejb.Stateless;
import akjp.projektjava.ejb.Bean1Remote;

@Stateless
public class Bean1 implements Bean1Remote {

    @Override
    public String getMessage() {
        return "Hello from Remote EJB Bean!";
    }
}
