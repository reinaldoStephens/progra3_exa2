/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.BookTypeDAOImpl;
import ac.cr.una.backend.model.BookType;
import ac.cr.una.backend.service.BookTypeService;
import ac.cr.una.backend.service.BookTypeServiceImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Admin
 */
@Path("bookTypes")
public class BookTypeWebservice {

    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;

    @Context
    private UriInfo context;

    /**
     *
     */
    public BookTypeWebservice() {
    }

    /**
     *
     * @param type
     * @return
     */
    @GET
    @Path("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookType getByName(@PathParam("type") String type) {
        BookType bookType = null;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        bookType = bookTypeService.findByName(type);

        return bookType;
    }

    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        result = bookTypeService.deleteAll();

        return result;
    }

    /**
     *
     * @param bookType
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookType createBookType(BookType bookType) {
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        bookType = bookTypeService.save(bookType);

        return bookType;
    }

}
