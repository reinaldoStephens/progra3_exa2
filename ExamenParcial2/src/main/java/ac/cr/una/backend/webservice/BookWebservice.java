/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.dao.BookDAOImpl;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.service.BookService;
import ac.cr.una.backend.service.BookServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Admin
 */
@Path("books")
public class BookWebservice {

    private BookDAO bookDAO;
    private BookService bookService;

    @Context
    private UriInfo context;

    /**
     *
     */
    public BookWebservice() {
    }

    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        result = bookService.deleteAll();
        return result;
    }

    /**
     *
     * @param book
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(Book book) {
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        bookService.save(book);

        return null;
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        List<Book> books = null;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);

        books = bookService.findAll();

        return books;
    }

    /**
     *
     * @return
     */
    public float getTotalPrice() {
        return 0;
    }

}
