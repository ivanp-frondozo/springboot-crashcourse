package com.example.demo.myfirstapi.repository;

import com.example.demo.myfirstapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository;

    @BeforeEach
    void setup() {
        repository = new ProductRepository();
    }

    @Test
    void shouldReturnThreeInitialProductsWhenFindAllIsCalled() {
        List<Product> products = repository.findAll();
        assertEquals(3, products.size());
    }

    @Test
    void shouldReturnPresentOptionalWhenProductIdExists() {
        Product expected = repository.findAll().get(0);
        Optional<Product> result = repository.findById(expected.getId());
        assertTrue(result.isPresent());
    }

    @Test
    void shouldReturnCorrectProductWhenProductIdExists() {
        Product expected = repository.findAll().get(0);
        Optional<Product> result = repository.findById(expected.getId());
        assertEquals(expected, result.get());
    }

    @Test
    void shouldReturnEmptyOptionalWhenProductIdDoesNotExist() {
        Optional<Product> result = repository.findById(100L);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldIncreaseRepositorySizeToFourWhenNewProductIsSaved() {
        repository.save(new Product("Test", 100.0));
        assertEquals(4, repository.findAll().size());
    }

    @Test
    void shouldAssignNonNullIdWhenSavingNewProduct() {
        Product newProduct = new Product("Test", 100.0);
        Product saved = repository.save(newProduct);
        assertNotNull(saved.getId());
    }

    @Test
    void shouldPreserveProductNameWhenSavingNewProduct() {
        Product saved = repository.save(new Product("Test", 100.0));
        assertEquals("Test", saved.getName());
    }

    @Test
    void shouldPreserveIdWhenUpdatingExistingProduct() {
        Product existing = repository.findAll().get(0);
        Product updated = new Product(existing.getId(), "Updated", 100.0);
        Product result = repository.save(updated);
        assertEquals(existing.getId(), result.getId());
    }

    @Test
    void shouldUpdateNameWhenUpdatingExistingProduct() {
        Product existing = repository.findAll().get(0);
        Product updated = new Product(existing.getId(), "Updated", 100.0);
        Product result = repository.save(updated);
        assertEquals("Updated", result.getName());
    }

    @Test
    void shouldUpdatePriceWhenUpdatingExistingProduct() {
        Product existing = repository.findAll().get(0);
        Product updated = new Product(existing.getId(), "Updated", 100.0);
        Product result = repository.save(updated);
        assertEquals(100.00, result.getPrice());
    }

    @Test
    void shouldNotChangeRepositorySizeWhenSavingNonExistingId() {
        Product fake = new Product(1L, "Fake", 100.0);
        repository.save(fake);
        assertEquals(3, repository.findAll().size());
    }

    @Test
    void shouldReturnInputProductWhenSavingNonExistingId() {
        Product fake = new Product(1L, "Fake", 100.0);
        Product result = repository.save(fake);
        assertEquals(fake, result);
    }
}
