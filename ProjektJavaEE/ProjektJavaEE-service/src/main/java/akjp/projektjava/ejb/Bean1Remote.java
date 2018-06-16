package akjp.projektjava.ejb;

import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Remote;
//import wipb.jee.clientdemo.model.Book;

@Remote
public interface Bean1Remote {

    String getMessage();
    
//    void save(Book book);
//    List<Book> findAll();
//    void remove(Long id);
//    void update(Long id, String title);
//    @Asynchronous
//    List<Book> findByLength(Integer length);
//    @Asynchronous
//    void sendEmail(String to, String subject, String message);
}
