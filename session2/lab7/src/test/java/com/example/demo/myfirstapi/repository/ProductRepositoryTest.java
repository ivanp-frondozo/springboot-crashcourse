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

}
