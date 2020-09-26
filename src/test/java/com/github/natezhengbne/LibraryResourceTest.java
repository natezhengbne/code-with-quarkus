package com.github.natezhengbne;

import com.github.natezhengbne.entity.Author;
import com.github.natezhengbne.entity.Book;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@Slf4j
class LibraryResourceTest {
    // http://www.wangzhenhua.rocks/zh-hans/java/jpa-one-to-many-many-to-one-best-practice
    @Inject
    EntityManager entityManager;

    @Test
    @Transactional
    void testOneToMany(){
        Author author = new Author();
        author.firstName = "Jack";
        author.lastName = "JJ";

        Book book = new Book();
        book.title = "hello";
        book.setAuthor(author);

        Set<Book> books = new HashSet<>();
        books.add(book);

//        author.books = (books);

        Author.persist(author);
        Book.persist(book);

//        Book book1 = Book.findAll().firstResult();
//
//        log.info(Author.findAll().firstResult().toString());
//        log.info(book1.toString());
//
//        assertNotNull(book1.getAuthor());

        List<Author> authorList = entityManager.createQuery("select a from Author a", Author.class).getResultList();
        List<Book> bookList = entityManager.createQuery("select a from Book a", Book.class).getResultList();

        log.info(authorList.get(0).toString());
        log.info(bookList.get(0).toString());

    }

}