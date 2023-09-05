package com.liquibase.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "profile")
public class Profile extends BaseEntity {

    @Column (name = "first_name")
    private String firstName;
    @Column(name = "photo")
    private String photo;
}
