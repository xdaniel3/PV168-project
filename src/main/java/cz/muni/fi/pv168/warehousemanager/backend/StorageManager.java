package cz.muni.fi.pv168.warehousemanager.backend;

import java.util.List;

/**
 * @author StorageManager on 15.03.16.
 */
public interface StorageManager {

    void createStorage(Storage storage);

    Storage getStorageById(Long id);

    List<Storage> findAllStorages();

    void updateStorage(Storage storage, int quantity);

    void deleteStorage(Storage storage);

    List<Storage> findStoragesForWarehouse(Warehouse warehouse);

    List<Storage> findStoragesForProducts(Product product);

}
