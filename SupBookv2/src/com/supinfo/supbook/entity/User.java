package com.supinfo.supbook.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String username;

    @Column(unique=false)
    private String password;

    @Column(unique=true)
    private String email;

    @Column(unique=false)
    private boolean isAdmin;

    @OneToMany(mappedBy = "userOwner")
    private Collection<Post> posts;

    @OneToMany(mappedBy = "userPage")
    private Collection<Post> postsPage;

    @OneToMany(mappedBy = "owner")
    private Collection<Comment> comments;

    public User() {
    }

    public User(String username, String password, String firstname, String lastname, String email, String address, String phonenumber, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAdmin = false;
    }

    public int getId() {
        return id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean getIsAdmin() {return isAdmin;}

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Collection<Post> getPostsPage() {
        return postsPage;
    }

    public void setPostsPage(Collection<Post> postsPage) {
        this.postsPage = postsPage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
