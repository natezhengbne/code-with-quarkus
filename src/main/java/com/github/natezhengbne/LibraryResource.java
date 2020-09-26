//package com.github.natezhengbne;
//
//import com.github.natezhengbne.entity.Author;
//import com.github.natezhengbne.entity.Book;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//
//@Path("/library")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class LibraryResource {
//    @Inject
//    EntityManager em;
//
//    @PUT
//    @Path("book")
//    @Transactional
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public void addBook(@FormParam("title") String title, @FormParam("authorId") Long authorId) {
//        Author author = Author.findById(authorId);
//        if (author == null) {
//            return;
//        }
//
//        Book book = new Book();
//        book.title = title;
//        book.author = author;
//        book.persist();
//
//        author.books.add(book);
//        author.persist();
//    }
//
//    @DELETE
//    @Path("book/{id}")
//    @Transactional
//    public void deleteBook(@PathParam("id") Long id) {
//        Book book = Book.findById(id);
//        if (book != null) {
//            book.author.books.remove(book);
//            book.delete();
//        }
//    }
//
//    @PUT
//    @Path("author")
//    @Transactional
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public void addAuthor(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName) {
//        Author author = new Author();
//        author.firstName = firstName;
//        author.lastName = lastName;
//        author.persist();
//    }
//
//    @POST
//    @Path("author/{id}")
//    @Transactional
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public void updateAuthor(@PathParam("id") Long id, @FormParam("firstName") String firstName, @FormParam("lastName") String lastName) {
//        Author author = Author.findById(id);
//        if (author == null) {
//            return;
//        }
//        author.firstName = firstName;
//        author.lastName = lastName;
//        author.persist();
//    }
//
//    @DELETE
//    @Path("author/{id}")
//    @Transactional
//    public void deleteAuthor(@PathParam("id") Long id) {
//        Author author = Author.findById(id);
//        if (author != null) {
//            author.delete();
//        }
//    }
//}
