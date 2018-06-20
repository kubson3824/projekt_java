package webaccess;

import akjp.dao.ProductDao;
import akjp.model.ProductDTO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "product")
@SessionScoped
public class Product implements Serializable {

    @EJB
    private ProductDao dao;

    private ProductDTO newProduct = new ProductDTO();

    public List<ProductDTO> getProducts() {
        return dao.findAll();
    }

    public ProductDao getDao() {
        return dao;
    }

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }

    public ProductDTO getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(ProductDTO newProduct) {
        this.newProduct = newProduct;
    }

    public ProductDTO getNewProductDTO() {
        return newProduct;
    }

    public void setNewProductDTO(ProductDTO newProduct) {
        this.newProduct = newProduct;
    }

    public void onProductAdd() {
        newProduct = new ProductDTO();
    }

    public void onProductEdit(ProductDTO p) {
        newProduct = p;
    }

    public String added() {
        dao.save(newProduct);
        RequestContext.getCurrentInstance().execute("PF('productDlg').hide()");
        return "/admin.xhtml?faces-redirect=true";
    }

    public String edited(){
        dao.update(newProduct);
        RequestContext.getCurrentInstance().execute("PF('productEditDlg').hide()");
        return "/admin.xhtml?faces-redirect=true";
    }

    public String onRemove(ProductDTO p) {
        dao.remove(p.getId());
        return "/admin.xhtml?faces-redirect=true";
    }
}
