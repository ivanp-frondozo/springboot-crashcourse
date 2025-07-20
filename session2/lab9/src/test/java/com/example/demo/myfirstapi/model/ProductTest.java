package com.example.demo.myfirstapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldReturnNullForObjectWithoutId() {
        Product product = new Product("Test", 100.0);
        assertNull(product.getId());
    }

    @Test
    void shouldReturnId() {
        Product product = new Product(1L, "Test", 100.0);
        assertEquals(1L, product.getId());
    }

    @Test
    void shouldSetCorrectProductId() {
        Product product = new Product(1L,"Test",100);
        product.setId(2L);
        assertEquals(2L, product.getId());
    }

    @Test
    void shouldSetCorrectProductName() {
        Product product = new Product(1L,"Test",100);
        product.setName("Test2");
        assertEquals("Test2", product.getName());
    }
    @Test
    void shouldSetCorrectProductPrice() {
        Product product = new Product("Test", 100);
        product.setPrice(150);
        assertEquals(150, product.getPrice());
    }

    @Test
    void testToStringFormat() {
        Product product = new Product(5L, "Test1", 100.0);
        String sample = "Product{id=5, name='Test1', price=100.0}";
        assertEquals(sample, product.toString());
    }

    @Test
    void shouldBeEqualWhenFieldsMatch() {
        Product product1 = new Product(1L, "Test1", 10.0);
        Product product2 = new Product(1L, "Test1", 10.0);
        assertEquals(product1, product2);
    }

    @Test
    void shouldNotBeEqualWhenIdIsDifferent() {
        Product product1 = new Product(1L, "Test1", 10.0);
        Product product2 = new Product(2L, "Test1", 10.0);
        assertNotEquals(product1,product2);
    }

    @Test
    void shouldNotBeEqualWhenNameIsDifferent() {
        Product product1 = new Product(1L, "Test1", 10.0);
        Product product2 = new Product(1L, "Test2", 10.0);
        assertNotEquals(product1,product2);
    }

    @Test
    void shouldNotBeEqualWhenPriceIsDifferent() {
        Product product1 = new Product(1L, "Test1", 10.0);
        Product product2 = new Product(1L, "Test1", 20.0);
        assertNotEquals(product1,product2);
    }

    @Test
    void shouldBeEqualToItself() {
        Product product1 = new Product(1L, "Test1", 10.0);
        assertEquals(product1, product1);
    }

    @Test
    void shouldNotBeEqualToNull() {
        Product product1 = new Product(1L, "Test1", 10.0);
        assertNotEquals(product1, null);
    }

    @Test
    void shouldReturnSameHashCodeForSameObject(){
        Product product1 = new Product(1L, "Test", 10.0);
        Product product2 = new Product(1L, "Test", 10.0);
        assertEquals(product1.hashCode(), product2.hashCode());

    }

    @Test
    void shouldReturnDifferentHashCodeForDifferentObjects() {
        Product product1 = new Product(1L, "Test1", 10.0);
        Product product2 = new Product(2L, "Test2", 20.0);
        assertNotEquals(product1.hashCode(), product2.hashCode());
    }
}