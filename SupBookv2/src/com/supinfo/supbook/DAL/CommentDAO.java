package com.supinfo.supbook.DAL;
import com.supinfo.supbook.entity.Comment;
import com.supinfo.supbook.utils.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CommentDAO {

    public static void addComment(Comment comment) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(comment);
        et.commit();
        em.close();
    }
}
