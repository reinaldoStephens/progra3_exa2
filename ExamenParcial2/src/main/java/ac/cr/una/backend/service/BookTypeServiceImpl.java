/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.model.BookType;

/**
 *
 * @author Admin
 */
public class BookTypeServiceImpl implements BookTypeService{
    
    private BookTypeDAO bookTypeDAO;

    /**
     *
     */
    public BookTypeServiceImpl() {
    }

    /**
     *
     * @param bookTypeDAO
     */
    public BookTypeServiceImpl(BookTypeDAO bookTypeDAO) {
        this.bookTypeDAO = bookTypeDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        return bookTypeDAO.deleteAll();
    }

    /**
     *
     * @param bookType
     * @return
     */
    @Override
    public BookType save(BookType bookType) {
        return bookTypeDAO.save(bookType);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public BookType findByName(String name) {
        return bookTypeDAO.findByName(name);
    }
    
}
