package com.zenika.supbook.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class FriendRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "OwnerID")
    private int OwnerID;

    @JoinColumn(name = "ReceiverID")
    private int ReceiverID;

    @Column(unique = false )
    private Date createAt;

    @Column(unique = false)
    private Boolean status = false;

}

