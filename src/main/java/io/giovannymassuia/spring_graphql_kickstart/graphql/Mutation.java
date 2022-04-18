package io.giovannymassuia.spring_graphql_kickstart.graphql;

import graphql.kickstart.tools.GraphQLMutationResolver;
import io.giovannymassuia.spring_graphql_kickstart.model.Author;
import io.giovannymassuia.spring_graphql_kickstart.respository.AuthorRepository;
import java.util.Comparator;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String name) {
        Long lastId = authorRepository.findAll().stream().map(Author::getId).max(Comparator.comparing(Long::intValue)).orElse(0L);
        Author author = new Author(++lastId, name);
        authorRepository.save(author);
        return author;
    }

}
