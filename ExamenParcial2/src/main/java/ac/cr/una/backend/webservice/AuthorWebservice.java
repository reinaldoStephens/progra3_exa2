/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.AuthorContactDAO;
import ac.cr.una.backend.dao.AuthorContactDAOImpl;
import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.dao.AuthorDAOImpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.service.AuthorService;
import ac.cr.una.backend.service.AuthorServiceImpl;
import java.util.List;
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
@Path("authors")
public class AuthorWebservice {

    private AuthorDAO authorDAO;
    private AuthorContactDAO authorContactDAO;
    private AuthorService authorService;

    @Context
    private UriInfo context;

    /**
     *
     */
    public AuthorWebservice() {
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthorContact> getAllAuthors() {
        List<AuthorContact> authorsList = null;
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorContactDAO);

        authorsList = authorService.findAll();

        return authorsList;
    }

    /**
     *
     * @param name
     * @return
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthorByName(@PathParam("name") String name) {
        Author author = null;
        authorDAO = new AuthorDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);

        author = authorService.findByName(name);

        return author;
    }

    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        authorDAO = new AuthorDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);

        result = authorService.deleteAll();

        return result;
    }

    /**
     *
     * @param authorContact
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuthorContact createAuthor(AuthorContact authorContact) {
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);

        authorContact = authorService.save(authorContact);
        return authorContact;
    }

}
