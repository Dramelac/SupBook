package com.zenika.supbook.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column
    private String content;

    @Column
    private String image;

    @Column
    private Date createAt;

    @ManyToOne
    @JoinColumn(name = "userID")
    @NotNull
    private User userOwner;

    @ManyToOne
    @JoinColumn(name = "pageID")
    @NotNull
    private User userPage;

    @OneToMany(mappedBy = "post")
    private Collection<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public User getUserPage() {
        return userPage;
    }

    public void setUserPage(User userPage) {
        this.userPage = userPage;
    }
}
