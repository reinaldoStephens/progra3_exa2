/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.BookType;
import org.hibernate.Query;

/**
 *
 * @author Admin
 */
public class BookTypeDAOImpl implements BookTypeDAO {

    private final org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public boolean deleteAll() {
        boolean isDeleted = false;
        BookType bookType = null;

        session.beginTransaction();
        bookType = (BookType) session.get(BookType.class);
        session.delete(bookType);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    @Override
    public BookType save(BookType bookType) {
        session.beginTransaction();
        session.save(bookType);
        session.getTransaction().commit();

        return bookType;
    }

    @Override
    public BookType findByName(String name) {
        BookType bookType = null;
        Query query = session.createQuery("from author where name = :name ");
        query.setParameter("name", name);

        if (query.list().size() > 0) {
            bookType = (BookType) query.list().get(0);
        }

        return bookType;
    }

}
