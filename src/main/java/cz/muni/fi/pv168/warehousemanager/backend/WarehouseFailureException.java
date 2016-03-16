package cz.muni.fi.pv168.warehousemanager.backend;

/*
 * Exception during malfunction in db operation
 *
 * @author Tomas Daniel, 433393
 */
public class WarehouseFailureException extends RuntimeException {

    public WarehouseFailureException(String message) {
        super(message);
    }

    public WarehouseFailureException(Throwable cause) {
        super(cause);
    }

    public WarehouseFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
