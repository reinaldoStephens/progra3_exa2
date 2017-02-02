/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;
import org.hibernate.Query;

/**
 *
 * @author Admin
 */
public class AuthorDAOImpl implements AuthorDAO {

    private final org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Author findByName(String name) {
        Author author = null;
        Query query = session.createQuery("from author where name = :name ");
        query.setParameter("name", name);

        if (query.list().size() > 0) {
            author = (Author) query.list().get(0);
        }

        return author;
    }

}
