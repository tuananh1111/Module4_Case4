package com.casestudy.case4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    @ManyToOne
    private Hotel hotel;
    @NotEmpty(message = "vui lòng nhập nhân xét của mình")
    private String content;
    @Max(5)
    @Column(columnDefinition = "Integer default 5")
    private int rate;

    public Comment() {
    }

    public Comment(Long id, User user, Hotel hotel, @NotEmpty(message = "vui lòng nhập nhân xét của mình") String content, @Max(5) int rate) {
        this.id = id;
        this.user = user;
        this.hotel = hotel;
        this.content = content;
        this.rate = rate;
    }
}
