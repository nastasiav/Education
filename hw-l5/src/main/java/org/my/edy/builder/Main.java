package org.my.edy.builder;

import org.my.edy.builder.book.Book;
import org.my.edy.builder.book.BookBuilder;
import org.my.edy.builder.product.Product;
import org.my.edy.builder.product.ProductBuilder;

public class Main {
    static void main() {
        Director director = new Director();
        BookBuilder bookBuilder = new BookBuilder();
        ProductBuilder productBuilder = new ProductBuilder();

        director.createBook(bookBuilder);
        director.createProduct(productBuilder);

        Book book = bookBuilder.build();
        Product product = productBuilder.build();

        IO.println(book);
        IO.println(product);
    }
}
