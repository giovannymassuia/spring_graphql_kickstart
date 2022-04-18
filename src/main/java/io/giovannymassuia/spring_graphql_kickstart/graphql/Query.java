package io.giovannymassuia.spring_graphql_kickstart.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import io.giovannymassuia.spring_graphql_kickstart.model.Author;
import io.giovannymassuia.spring_graphql_kickstart.model.Book;
import io.giovannymassuia.spring_graphql_kickstart.respository.AuthorRepository;
import io.giovannymassuia.spring_graphql_kickstart.respository.BookRepository;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> books(DataFetchingEnvironment environment) {
//        if (environment.getSelectionSet().contains("author")) {
//            return bookRepository.findAll().stream()
//                    .peek(book -> book.setAuthor(authorRepository.findById(book.getAuthorId(), false)))
//                    .collect(Collectors.toList());
//        } else {
            return bookRepository.findAll();
//        }
    }

    public List<Author> authors() {
        return authorRepository.findAll();
    }

    // Async
    public CompletableFuture<Author> author(long authorId) {
        Logger.getLogger(GraphQLQueryResolver.class.getName()).info("Executing authorId async: " + authorId);
        return CompletableFuture.supplyAsync(() -> authorRepository.findById(authorId, true));
    }

}
