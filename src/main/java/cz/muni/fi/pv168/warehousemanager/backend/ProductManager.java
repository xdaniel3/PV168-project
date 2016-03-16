package cz.muni.fi.pv168.warehousemanager.backend;

import java.util.List;

/*
 * Interface of ProductManager
 *
 * @author Tomas Daniel, 433393
 */

public interface ProductManager {

    void createProduct(Product product) throws WarehouseFailureException;

    void updateProduct(Product product) throws WarehouseFailureException;

    void deleteProduct(Product product) throws WarehouseFailureException;

    Product findProductById(Long id) throws WarehouseFailureException;

    List<Product> findAllProducts() throws WarehouseFailureException;
}
