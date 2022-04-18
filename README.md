# Spring Boot GraphQL simple projetc

## How to test
- Run the project
- Go to http://localhost:8080/playground

### Schema
```graphql
type Author {
  id: ID
  name: String
  totalBooksPublished: Int
}

type Book {
  id: ID
  name: String
  author: Author
}

type Mutation {
  createAuthor(name: String): Author
}

type Query {
  books: [Book]
  authors: [Author]
  author(id: ID): Author
}
```

---

### Resources:
- https://www.graphql-java.com/tutorials/getting-started-with-spring-boot
- https://github.com/graphql-java-kickstart/graphql-spring-boot
