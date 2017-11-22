package com.supinfo.supbook.DAL;


import com.supinfo.supbook.entity.PostLike;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.User;
import com.supinfo.supbook.utils.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class LikeDAO {

    public static void addLike(PostLike like){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(like);
        et.commit();
        em.close();
    }

    public static void updateLike(PostLike like){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(like);
        et.commit();
        em.close();
    }

    public static PostLike getLikeByPost(Post post){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT l FROM PostLike l WHERE l.post = :post");
        query.setParameter("post", post);
        List result = query.getResultList();
        return (result.size() == 0) ? null : ((PostLike) result.get(0));
    }



}
