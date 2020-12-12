package com.casestudy.case4.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RoomForm {
    private Long id;

    private String name;
    private MultipartFile coverImage;
    private Double price;
    private String description;
    private Hotel hotel;
    private TypeRoom typeRoom;

    public RoomForm() {
    }

    public RoomForm(Long id, String name, MultipartFile coverImage, Double price, String description, Hotel hotel, TypeRoom typeRoom) {
        this.id = id;
        this.name = name;
        this.coverImage = coverImage;
        this.price = price;
        this.description = description;
        this.hotel = hotel;
        this.typeRoom = typeRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(MultipartFile coverImage) {
        this.coverImage = coverImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }
}
