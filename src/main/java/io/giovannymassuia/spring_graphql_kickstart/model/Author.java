package io.giovannymassuia.spring_graphql_kickstart.model;

public class Author {

    private long id;
    private String name;
    private int totalBooksPublished;

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
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

    public int getTotalBooksPublished() {
        return totalBooksPublished;
    }

    public void setTotalBooksPublished(int totalBooksPublished) {
        this.totalBooksPublished = totalBooksPublished;
    }
}
