package org.my.edy.builder.book;

import org.my.edy.builder.MyBuilder;

public class BookBuilder implements MyBuilder {
    private Book book;

    @Override
    public void reset() {
        this.book = new Book();
    }

    @Override
    public void buildStepA(String name) {
        this.book.setName(name);
    }

    @Override
    public void buildStepB(int cost) {
        this.book.setCost(cost);
    }

    @Override
    public void buildStepC(long id) {
        this.book.setId(id);
    }

    public Book build() {
        return this.book;
    }
}
