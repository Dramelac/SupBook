package com.supinfo.supbook.DAL;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.utils.PersistenceManager;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.IOException;
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

    public static void updatePost(Post post){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(post);
        et.commit();
        em.close();
    }

    public static List<Post> getAllPostsOrderByPublishDate(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query  query = em.createQuery("SELECT a FROM Post a ORDER BY a.createAt DESC ");
        List<Post> posts = (List<Post>)query.getResultList();
        return posts;
    }

    public static List<Post> getTenPostsOrderByPublishDate(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query  query = em.createQuery("SELECT  a FROM Post a ORDER BY a.createAt DESC");
        query.setMaxResults(10);
        List<Post> posts = (List<Post>)query.getResultList();
        return posts;
    }

    public static Post getPostById(int id){
        EntityManager em = PersistenceManager.getEntityManager();
        return em.find(Post.class, id);
    }

    public static void removePostByPost(Post ad){
        PersistenceManager.getEntityManager().close();
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(em.contains(ad) ? ad : em.merge(ad));
        et.commit();
        em.close();
    }

    public static long getPostCount(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT count(*) FROM Post");
        return (long) query.getSingleResult();
    }

    public static Post getAndCheck(int id, int userID) throws NotFoundException, IOException, IllegalAccessException {
        Post post = PostDAO.getPostById(id);
        if (post == null){
            throw new NotFoundException("Post no found");
        } else if (post.getUserOwner().getId() != userID){
            throw new IllegalAccessException("You dont have access to this post");
        }
        return post;
    }

}
