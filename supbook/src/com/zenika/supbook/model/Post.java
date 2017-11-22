package com.zenika.supbook.model;

import com.sun.istack.internal.NotNull;
import javafx.geometry.Pos;

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
    private User user;
}
