package cz.muni.fi.pv168.warehousemanager.backend;

/**
 * @author Warehouse on 15.03.16.
 */
public class Warehouse {
    private Long id;
    private String name;
    private int capacity;
    private String locality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

}
