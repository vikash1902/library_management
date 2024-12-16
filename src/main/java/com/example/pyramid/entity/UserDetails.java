package com.example.pyramid.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_details")
public class UserDetails {

    @Id
    @Column(name = "user_id")
    private String userId;


    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_role")
    private  int role;

    @ManyToOne
    @JoinColumn(name = "user_role", referencedColumnName = "role_id", insertable = false, updatable = false)
    private RoleDetails roleDetails;
}
