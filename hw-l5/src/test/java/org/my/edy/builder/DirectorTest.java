package org.my.edy.builder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.my.edy.builder.book.Book;
import org.my.edy.builder.book.BookBuilder;
import org.my.edy.builder.product.Product;
import org.my.edy.builder.product.ProductBuilder;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {
    static Director director;

    @BeforeAll
    static void setUp() {
        director = new Director();
    }

    @Test
    void createProduct() {
        ProductBuilder builder = new ProductBuilder();
        director.createProduct(builder);
        Product product = builder.build();

        assertNotNull(product);
        assertEquals(Product.class, product.getClass());
        assertEquals("Product", product.getName());
        assertEquals(100, product.getCost());
        assertEquals(1L, product.getId());
    }

    @Test
    void resetProduct() {
        ProductBuilder builder = new ProductBuilder();
        director.createProduct(builder);
        Product product = builder.build();
        director.createProduct(builder);
        Product product2 = builder.build();

        assertNotNull(product);
        assertNotNull(product2);
        assertNotEquals(product, product2);
    }

    @Test
    void createBook() {
        BookBuilder builder = new BookBuilder();
        director.createBook(builder);
        Book book = builder.build();

        assertNotNull(book);
        assertEquals(Book.class, book.getClass());
        assertEquals("Book", book.getName());
        assertEquals(200, book.getCost());
        assertEquals(2L, book.getId());
    }

    @Test
    void resetBook() {
        BookBuilder builder = new BookBuilder();
        director.createBook(builder);
        Book book = builder.build();
        director.createBook(builder);
        Book book2 = builder.build();

        assertNotNull(book);
        assertNotNull(book2);
        assertNotEquals(book, book2);
    }
}