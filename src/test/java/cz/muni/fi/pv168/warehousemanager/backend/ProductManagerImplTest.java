package cz.muni.fi.pv168.warehousemanager.backend;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/*
 * Test class of ProductManager
 *
 * @author Tomas Daniel, 433393
 */

public class ProductManagerImplTest {

    private ProductManagerImpl manager;

    @Before
    public void setUp() throws SQLException {
        manager = new ProductManagerImpl();
    }

    @Test
    public void testCreateProduct()  {
        Product product = newProduct("Pen",50);
        manager.createProduct(product);
        Long productId = product.getId();

        assertThat("saved grave has null id", product.getId(), is(not(equalTo(null))));

        Product result = manager.findProductById(productId);
        assertThat("retrieved product differ from the saved one", result, is(equalTo(product)));


        assertThat("retrieved grave is the same instance", result, is(not(sameInstance(product))));
        assertDeepEquals(product, result);


    }

    @Test
    public void testProductWithNull() throws Exception {
        try{
            manager.createProduct(null);
            fail("expected IllegalArgumentException for null argument");
        } catch(IllegalArgumentException ex) {
            //OK
        }

    }

    @Test
    public void testProductWithBadValues() {
        Product product1 = newProduct("notebook", 35000);
        product1.setId(50L);
        try{
            manager.createProduct(product1);
            fail("Shouldn't be possible to assign ID");
        } catch(IllegalArgumentException ex) {
            //OK
        }
        Product product2 = newProduct("car", -100000);
        try {
            manager.createProduct(product2);
            fail("Price must be positive!");
        } catch (IllegalArgumentException ex) {
            //OK
        }
        Product product3 = newProduct(null, 100);
        try{
            manager.createProduct(product3);
            fail("Name shouldn't be null!");
        } catch(IllegalArgumentException ex) {
            //OK
        }

        Product product4 = newProduct("bicycle", 0);
        try {
            manager.createProduct(product4);
            fail("Product can't be free!");
        } catch (IllegalArgumentException ex) {
            //OK
        }


    }

    @Test
    public void testUpdateProduct() {
        Product product1 = newProduct("Desk", 780);
        Product product2 = newProduct("Screwdriver", 8000);

        manager.createProduct(product1);
        manager.createProduct(product2);

        product1.setPrice(1000);
        product1.setName("iPhone");
        manager.updateProduct(product1);

        assertThat("Price didn't change.",product1.getPrice(), is(equalTo(1000)));
        assertThat("Name didn't chane", product1.getName(), is(equalTo("iPhone")));

        product1.setPrice(-1000);
        product1.setName(null);

        try{
            manager.updateProduct(product1);
            fail("Price shouldn't be negative");
        } catch(IllegalArgumentException ex) {
            //OK
        }

        product1.setName(null);

        try{
            manager.updateProduct(product1);
            fail("Should contain name");
        } catch(IllegalArgumentException ex) {
            //OK
        }

        assertDeepEquals(product2, manager.findProductById(product2.getId()));

    }

    @Test
    public void testDeleteProduct()  {
        Product product1 = newProduct("Table", 500);
        Product product2 = newProduct("Camera", 8000);

        manager.createProduct(product1);
        manager.createProduct(product2);

        assertNotNull(product1);
        assertNotNull(product2);

        manager.deleteProduct(product2);

        assertNull(product2.getId());
        assertNotNull(product1.getId());

    }

    @Test
    public void testFindProductById() {
        Product product1 = newProduct("Television", 23000);
        Product product2 = newProduct("Camera", 8000);

        manager.createProduct(product1);
        manager.createProduct(product2);

        assertEquals(product1, manager.findProductById(product1.getId()));
        assertEquals(product2, manager.findProductById(product2.getId()));
    }

    @Test
    public void testFindAllProducts() {
        assertTrue(manager.findAllProducts().isEmpty());

        Product product1 = newProduct("Trousers", 2300);
        Product product2 = newProduct("T-shirt", 800);

        manager.createProduct(product1);
        manager.createProduct(product2);

        List<Product> actual = Arrays.asList(product1, product2);
        List<Product> expected = manager.findAllProducts();

        assertEquals("Products are not same", actual, expected);

        assertDeepEquals(actual, expected);



    }

    private static Product newProduct(String name, int price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    private void assertDeepEquals(Product expected, Product actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPrice(), actual.getPrice());
    }

    private void assertDeepEquals(List<Product> expectedList, List<Product> actualList) {
        for (int i = 0; i < expectedList.size(); i++) {
            Product expected = expectedList.get(i);
            Product actual = actualList.get(i);
            assertDeepEquals(expected, actual);
        }
    }

}