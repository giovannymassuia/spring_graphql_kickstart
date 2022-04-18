package io.giovannymassuia.spring_graphql_kickstart.graphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import io.giovannymassuia.spring_graphql_kickstart.model.Author;
import io.giovannymassuia.spring_graphql_kickstart.model.Book;
import io.giovannymassuia.spring_graphql_kickstart.respository.AuthorRepository;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
class BookResolver implements GraphQLResolver<Book> {

    public final AuthorRepository authorRepository;

    BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // run Async
//    public CompletableFuture<Author> getAuthor(Book book) {
//        Logger.getLogger(BookResolver.class.getName()).info("Book.Author resolver: " + book.getName());
//        return CompletableFuture.supplyAsync(() ->
//                book.getAuthor() != null ? book.getAuthor() : authorRepository.findById(book.getAuthorId(), true));
//    }

    public Author getAuthor(Book book) {
        Logger.getLogger(BookResolver.class.getName()).info("Book.Author resolver: " + book.getName());
        return book.getAuthor() != null ? book.getAuthor() : authorRepository.findById(book.getAuthorId(), true);
    }

}