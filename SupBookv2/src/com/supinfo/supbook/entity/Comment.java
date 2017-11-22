package com.supinfo.supbook.entity;

import com.sun.istack.internal.NotNull;
import javafx.geometry.Pos;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @NotNull
    private Post post;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @NotNull
    private User owner;


}
