package com.supinfo.supbook.DAL;
import com.supinfo.supbook.entity.Comment;
import com.supinfo.supbook.utils.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CommentDAO {

    public static void addComment(Comment comment) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(comment);
        et.commit();
        em.close();
    }

    public static List<Comment> getCommentsForPost(int postId){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Comment c WHERE c.post=" + postId + " ORDER BY c.id DESC");
        List<Comment> comments = (List<Comment>)query.getResultList();
        return comments;
    }
}
