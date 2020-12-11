package com.casestudy.case4.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Timestamp dayBook;
    @Column(columnDefinition = "boolean default false")
    private boolean status;
    @ManyToOne
    private User user;

}
