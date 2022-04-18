package io.giovannymassuia.spring_graphql_kickstart.graphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import io.giovannymassuia.spring_graphql_kickstart.model.Author;
import io.giovannymassuia.spring_graphql_kickstart.respository.BookRepository;
import org.springframework.stereotype.Component;

@Component
class AuthorResolver implements GraphQLResolver<Author> {

    public final BookRepository bookRepository;

    AuthorResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public long getTotalBooksPublished(Author author) {
        return bookRepository.findAll().stream().filter(book -> book.getAuthorId() == author.getId()).count();
    }
}