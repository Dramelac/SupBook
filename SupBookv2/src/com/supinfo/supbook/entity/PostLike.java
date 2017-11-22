package com.supinfo.supbook.entity;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;


@Entity
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column
    private boolean action;

    @ManyToOne
    @JoinColumn(name = "userID")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "postID")
    @NotNull
    private Post post;


    public PostLike() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
