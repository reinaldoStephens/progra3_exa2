/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class BookDAOImpl implements BookDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        session.getSessionFactory().getCurrentSession().createSQLQuery("delete from book").executeUpdate();
        return true;
    }

    /**
     *
     * @param book
     * @return
     */
    @Override
    public Book save(Book book) {
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        return book;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Book> findAll() {
        List<Book> book = new ArrayList<>();

        book = session.createCriteria(Book.class).list();

        return book;
    }

}
