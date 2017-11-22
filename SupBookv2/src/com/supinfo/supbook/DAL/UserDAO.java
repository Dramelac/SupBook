package com.supinfo.supbook.DAL;

import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.User;
import com.supinfo.supbook.utils.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static void addUser(User user){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
        em.close();
    }

    public static void updateUser(User user){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(user);
        et.commit();
        em.close();
    }

    public static String getPasswordByName(String username){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT u.password FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        List result = query.getResultList();
        return (result.size() == 0) ? "" : ((String) result.get(0));
    }

    public static User getUserByName(String username){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        List result = query.getResultList();
        return (result.size() == 0) ? null : ((User) result.get(0));
    }

    public static User getUserById(int id){
        EntityManager em = PersistenceManager.getEntityManager();
        return em.find(User.class, id);
    }

    public static long getUserCount(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT count(*) FROM User");
        return (long) query.getSingleResult();
    }

    public static List<User> getAll(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }
    public static List<User> getAllLike(String inputName){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u where u.username Like :inputName ");
        return (List<User>) query.getResultList();
    }

    public static List<User> getFriends(User user){
        EntityManager em = PersistenceManager.getEntityManager();
        List<User> friends = new ArrayList<>();
        Query query = em.createQuery("SELECT f.receiver FROM FriendRequest f WHERE f.owner = :user AND f.status = true ");
        query.setParameter("user", user);
        friends.addAll((List<User>) query.getResultList());
        query = em.createQuery("SELECT f.owner FROM FriendRequest f WHERE f.receiver = :user AND f.status = true ");
        query.setParameter("user", user);
        friends.addAll((List<User>) query.getResultList());
        return friends;
    }

    public static void removeUserById(int id){
        EntityManager em = PersistenceManager.getEntityManager();
        User user = getUserById(id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(em.contains(user) ? user : em.merge(user));
        et.commit();
        em.close();
    }

}
