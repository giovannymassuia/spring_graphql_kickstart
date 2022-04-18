package io.giovannymassuia.spring_graphql_kickstart.respository;

import io.giovannymassuia.spring_graphql_kickstart.model.Author;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {

    private final List<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();
        this.authors.add(new Author(1L, "Eric Evans"));
        this.authors.add(new Author(2L, "Robert C. Martin"));
    }

    public Author findById(long authorId, boolean delay) {
        // simulate slow query
        if (delay) sleep(2000L);

        return this.authors.stream().filter(author -> author.getId() == authorId).findFirst().orElse(null);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Author> findAll() {
        return this.authors;
    }

    public void save(Author author) {
        this.authors.add(author);
    }
}
