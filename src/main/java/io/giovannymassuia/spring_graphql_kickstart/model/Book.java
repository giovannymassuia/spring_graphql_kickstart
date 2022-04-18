package io.giovannymassuia.spring_graphql_kickstart.model;

public class Book {

    private long id;
    private String name;
    private long authorId;
    private Author author;

    public Book(long id, String name, long authorId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}