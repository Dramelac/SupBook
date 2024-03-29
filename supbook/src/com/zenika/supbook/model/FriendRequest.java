package com.zenika.supbook.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class FriendRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OwnerID")
    private User owner;

    @ManyToOne(fetch=FetchType.LAZY)
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

