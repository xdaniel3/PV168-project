package cz.muni.fi.pv168.warehousemanager.backend;

import java.util.List;

/*
 * Implementation of ProductManager
 *
 * @author Tomas Daniel, 433393
 */

public class ProductManagerImpl implements ProductManager {

    public void createProduct(Product product) {

        if(product==null) throw new IllegalArgumentException("product should not be null");
        if(product.getId()!= null) throw new IllegalArgumentException("product id should not be assigned prior saving");
        if(product.getName() == null) throw new IllegalArgumentException("product should have any name");
        if(product.getPrice() < 0) throw new IllegalArgumentException("product should cost something");
        //TODO complete implementation

    }

    public void updateProduct(Product product) {
        if(product==null) throw new IllegalArgumentException("product should not be null");
        if(product.getId()!= null) throw new IllegalArgumentException("product id should not be assigned prior saving");
        if(product.getName() == null) throw new IllegalArgumentException("product should have any name");
        if(product.getPrice() < 0) throw new IllegalArgumentException("product should cost something");
        //TODO complete implementation

    }

    public void deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Product findProductById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Product> findAllProducts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
