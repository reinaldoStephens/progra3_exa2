/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.model.BookType;

/**
 *
 * @author Admin
 */
public interface BookTypeService {

    /**
     *
     * @return
     */
    public boolean deleteAll();

    /**
     *
     * @param bookType
     * @return
     */
    public BookType save(BookType bookType);

    /**
     *
     * @param name
     * @return
     */
    public BookType findByName(String name);
    
}
