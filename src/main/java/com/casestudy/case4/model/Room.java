package com.casestudy.case4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private Double price;
    private String description;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeRoom typeRoom;

    public Room() {
    }

    public Room(Long id, String name, Double price, String description, Hotel hotel, TypeRoom typeRoom) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.hotel = hotel;
        this.typeRoom = typeRoom;
    }

    public Room(Long id, String name, String image, Double price, String description, Hotel hotel, TypeRoom typeRoom) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.hotel = hotel;
        this.typeRoom = typeRoom;
    }
}
