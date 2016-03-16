package cz.muni.fi.pv168.warehousemanager.backend;

/*
 * Product class
 *
 * @author Tomas Daniel, 433393
 */


public class Product {


    private Long id;
    private String name;
    private int price;


    public Long getId() {
            return this.id;
        }

    public void setId(Long id) {
            this.id = id;
        }

    public String getName() {
            return this.name;
        }

    public void setName(String name) {
            this.name = name;
        }

    public int getPrice() {
            return this.price;
        }

    public void setPrice(int price) {
        this.price = price;
    }




}
