package akjp.projektjavaee.clientapp;

import javax.naming.NamingException;
import akjp.projektjava.dao.ProductDao;
import akjp.projektjava.dao.jpa.JpaProductDao;
import akjp.projektjava.model.ProductDTO;
import java.text.ParseException;
import java.util.List;
import javax.naming.InitialContext;
import akjp.projektjava.ejb.Bean1Remote;
import java.util.Scanner;

public class Clientapp {

    public static void main(String[] args) throws NamingException, ParseException {

        System.out.println("Sklep internetowy");
        System.out.println("");
        
        ProductDao pdao = new JpaProductDao();

        createProduct(pdao, "niekonik", 400.09, "zabawka");

        List<ProductDTO> ProductL = pdao.findProductsBetween(100.00, 700.00);
        System.out.println(ProductL);
        pdao.delete(ProductL.get(0));
        
        //test dzialania ejb, robie na payarze5
        //ejbb();
        
        //interfejs konsolowy
        Scanner skaner = new Scanner(System.in);
        boolean iff=true;
        String a, b, c;
        Double var;
        Long var2;
        while(true) {
            System.out.println("1. Produkty.");
            System.out.println("2. Zamowienia.");
            System.out.println("3. Wyjdz");
            switch(Integer.parseInt(skaner.nextLine())) {
                case 1://produkty
                    iff=true;
                    while(iff){
                    System.out.println("1. Pokaz wszystkie produkty.");
                    System.out.println("2. Dodaj produkt.");
                    System.out.println("3. Edytuj produkt.");
                    System.out.println("4. Usun produkt.");
                    System.out.println("5. Wyjdz");
                        switch(Integer.parseInt(skaner.nextLine())) {
                            case 1://pokaz
                                List<ProductDTO> ProductLL = pdao.showAll();
                                System.out.println(ProductLL);
                                break;

                            case 2://dodaj produkt
                                System.out.println("Nazwa:");
                                a = skaner.nextLine();
                                System.out.println("Cena:");
                                var = Double.parseDouble(skaner.nextLine());
                                System.out.println("Kategoria:");
                                b = skaner.nextLine();
                                createProduct(pdao, a, var, b);
                                break;

                            case 3://edytuj produkt
                                System.out.println("Nazwa produktu do edycji:");
                                a = skaner.nextLine();
                                System.out.println("Nowa nazwa:");
                                b = skaner.nextLine();
                                System.out.println("Nowa cena:");
                                var2 = Long.parseLong(skaner.nextLine());
                                System.out.println("Nowa kategoria:");
                                c = skaner.nextLine();
                                pdao.editProduct(a, b, var2, c);
                                break;

                            case 4://usun produkt
                                System.out.println("Nazwa produktu do usuniecia: ");
                                a = skaner.nextLine();
                                System.out.println("Typ produktu: ");
                                b = skaner.nextLine();
                                deleteProduct(pdao, a, b);
                                break;

                            case 5://Wyjdz
                                iff=false;
                                break;
                            default:
                                System.out.println("Nieprawidlowa komenda. Wybierz jeszcze raz: ");
                                continue;
                        }
                    }
                    break;
                    
                case 2://zamowienia
                    break;
                case 3:
                    return;
                default:
                    continue;
            }
        }
    }

    public static void createProduct(ProductDao pdao, String name, Double price, String type) {
        ProductDTO p1 = new ProductDTO();
        p1.setName(name);
        p1.setPrice(price);
        p1.setType(type);
        pdao.save(p1);
    }
    
    public static void deleteProduct(ProductDao pdao, String name, String type){
        List<ProductDTO> ProductL = pdao.findProduct(name, type);
        System.out.println(ProductL);
        pdao.delete(ProductL.get(0));
    }
    
    public static void ejbb() throws NamingException{
        System.out.println("Initializing remote EJB bean...");
        InitialContext ic = new InitialContext();
        // pobranie referencji do ejb (proxy) do komponentu EJB z usługi katalogowej JNDI serwera aplikacyjnego
        Bean1Remote ejb = (Bean1Remote) ic.lookup("java:global/ProjektJavaEE-ear-1.0/ProjektJavaEE-ejb-1.0/Bean1!akjp.projektjava.ejb.Bean1Remote");
        // wywołanie metody ejb z serwera aplikacyjnego                            
        String result = ejb.getMessage();
        System.out.println("Remote message result: "+result);
    }
}
