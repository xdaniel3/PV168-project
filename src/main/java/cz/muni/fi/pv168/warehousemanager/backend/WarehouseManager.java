package cz.muni.fi.pv168.warehousemanager.backend;

import java.util.List;

/**
 * @author WarehouseManager on 15.03.16.
 */
public interface WarehouseManager {

    /**
     * @param warehouse
     */
    void createWarehouse(Warehouse warehouse);


    /**
     * @param warehouse
     */
    void updateWarehouse(Warehouse warehouse);

    /**
     * @param warehouse
     */
    void deleteWarehouse(Warehouse warehouse);

    /**
     * @param id
     * @return
     */
    Warehouse findWarehouseById(Long id);

    /**
     * @return
     */
    List<Warehouse> findAllWarehouses();


}
