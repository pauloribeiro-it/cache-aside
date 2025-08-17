package com.cache.aside.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @Column
    private Integer id;

    @Column
    private String description;

}
