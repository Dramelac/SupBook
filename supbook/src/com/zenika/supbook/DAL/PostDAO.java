package com.zenika.supbook.DAL;

import com.zenika.supbook.model.Post;
import com.zenika.supbook.model.User;
import com.zenika.supbook.service.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PostDAO {

    public static void addPost(Post post) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(post);
        et.commit();
        em.close();
    }

    public static void updateUser(Post post) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(post);
        et.commit();
        em.close();
    }

    public static void removePostById(int id) {
        EntityManager em = PersistenceManager.getEntityManager();
        Post post = getPostById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(em.contains(post) ? post : em.merge(post));
        et.commit();
        em.close();
    }

    private static Post getPostById(int id) {
        EntityManager em = PersistenceManager.getEntityManager();
        return em.find(Post.class, id);
    }

    public static long getPostCountUser(User user) {
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT count(*) FROM Post p WHERE p.userOwner = :user");
        query.setParameter("user",user);
        return (long) query.getSingleResult();
    }

    public static List<Post> getAll() {
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Post p");
        return (List<Post>) query.getResultList();
    }

    public static  List<Post> getPostByPageId(User page){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Post p WHERE p.userPage = :page");
        query.setParameter("page", page);
        return (List<Post>) query.getResultList();
    }

}
