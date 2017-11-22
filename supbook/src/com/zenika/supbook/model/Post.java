package com.zenika.supbook.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
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
}
