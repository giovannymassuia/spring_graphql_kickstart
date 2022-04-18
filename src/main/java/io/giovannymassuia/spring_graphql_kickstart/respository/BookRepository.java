package io.giovannymassuia.spring_graphql_kickstart.respository;

import io.giovannymassuia.spring_graphql_kickstart.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();

        books.add(new Book(1L, "Domain Driven Design", 1L));
        books.add(new Book(2L, "SOLID", 2L));
        books.add(new Book(3L, "Clean Arch", 2L));
    }

    public List<Book> findAll() {
        return this.books;
    }
}
