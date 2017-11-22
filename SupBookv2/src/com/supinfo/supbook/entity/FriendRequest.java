package com.supinfo.supbook.entity;

import com.sun.javafx.beans.IDProperty;
import com.supinfo.supbook.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class FriendRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="OwnerID")
    private User owner;

    @ManyToOne
    @JoinColumn(name="ReceiverID")
    private User receiver;

    @Column(unique = false )
    private Date createAt;

    @Column(unique = false)
    private Boolean status = false;

    public FriendRequest(){

    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public User getOwner() {return owner;}

    public void setOwner(User owner) {this.owner = owner;}

    public User getReceiver() {return receiver;}

    public void setReceiver(User receiver) {this.receiver = receiver;}

    public Date getCreateAt() {return createAt;}

    public void setCreateAt(Date createAt) {this.createAt = createAt;}

    public Boolean getStatus() {return status;}

    public void setStatus(Boolean status) {this.status = status;}
}

