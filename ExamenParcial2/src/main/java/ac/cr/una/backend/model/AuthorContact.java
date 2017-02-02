/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "authorcontact", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "idAuthorContact")})
public class AuthorContact implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idAuthorContact")
    private int idAuthorContact;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor", nullable = false)
    private Author author;
    @Column(name = "contact", unique = false, nullable = false)
    private String contact;
    @Column(name = "type", unique = false, nullable = false)
    private String type;

    /**
     *
     */
    public AuthorContact() {
    }

    /**
     *
     * @param idAuthorContact
     * @param author
     * @param contact
     * @param type
     */
    public AuthorContact(int idAuthorContact, Author author, String contact, String type) {
        this.idAuthorContact = idAuthorContact;
        this.author = author;
        this.contact = contact;
        this.type = type;
    }

    /**
     *
     * @return
     */
    public int getIdAuthorContact() {
        return idAuthorContact;
    }

    /**
     *
     * @param idAuthorContact
     */
    public void setIdAuthorContact(int idAuthorContact) {
        this.idAuthorContact = idAuthorContact;
    }

    /**
     *
     * @return
     */
    public Author getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public String getContact() {
        return contact;
    }

    /**
     *
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idAuthorContact;
        hash = 17 * hash + Objects.hashCode(this.author);
        hash = 17 * hash + Objects.hashCode(this.contact);
        hash = 17 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuthorContact other = (AuthorContact) obj;
        if (this.idAuthorContact != other.idAuthorContact) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthorContact{" + "idAuthorContact=" + idAuthorContact + ", author=" + author + ", contact=" + contact + ", type=" + type + '}';
    }

}
