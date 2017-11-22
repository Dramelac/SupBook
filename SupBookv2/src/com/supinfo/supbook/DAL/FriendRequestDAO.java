package com.supinfo.supbook.DAL;

import com.supinfo.supbook.entity.FriendRequest;
import com.supinfo.supbook.entity.User;
import com.supinfo.supbook.utils.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class FriendRequestDAO {
    public static void addFriendRequest(FriendRequest friendRequest) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(friendRequest);
        et.commit();
        em.close();
    }

    public static void updateFriendRequest(FriendRequest friendRequest) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(friendRequest);
        et.commit();
        em.close();
    }

    public static FriendRequest getFriendRequestByID(int id) {
        EntityManager em = PersistenceManager.getEntityManager();
        return em.find(FriendRequest.class, id);
    }

    public static List<FriendRequest> getRequestByReceiverID(User user) {
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT f FROM FriendRequest f WHERE f.receiver = :user");
        query.setParameter("user", user);

        return (List<FriendRequest>) query.getResultList();
    }

    public static  void removeFriendRequestByID (int id) {
        EntityManager em = PersistenceManager.getEntityManager();
        FriendRequest friendRequest = getFriendRequestByID(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(em.contains(friendRequest) ? friendRequest : em.merge(friendRequest));
        et.commit();
        em.close();
    }

    public static long getFriendRequestCount() {
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT count(*) FROM FriendRequest");
        return (long) query.getSingleResult();
    }

    public static List<FriendRequest> getAll() {
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT u FROM FriendRequest u");
        return (List<FriendRequest>) query.getResultList();
    }
}
