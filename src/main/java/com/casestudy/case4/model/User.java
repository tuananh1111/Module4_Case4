package com.casestudy.case4.model;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Bạn cần điền họ tên của mình")
    @Size(min = 1, max = 50, message = "Họ tên cần từ 1-50 từ ")
    private String fullName;
    @NotEmpty(message = "Vui lòng nhập SDT")
    private String phone;
    @NotEmpty(message = "Vui lòng nhập địa chỉ")
    @Column(columnDefinition = "varchar(255) default 'HN' ")
    private String address;
    @Min(value = 18, message = "Bạn phải đủ 18t mới có thể đặt phòng")
    private int age;
    @Email
    private String email;
    @NotBlank(message = "bạn cần tên đăng nhập")
    private String userName;
    @NotBlank(message = "Vui lòng nhập mật khẩu")
    private String passWord;
    @Column(columnDefinition="boolean DEFAULT TRUE")
    private boolean status;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    public User() {
    }

    public User(Long id, @NotBlank(message = "Bạn cần điền họ tên của mình") @Size(min = 1, max = 50, message = "Họ tên cần từ 1-50 từ ") String fullName, @NotEmpty(message = "Vui lòng nhập SDT") String phone, @NotEmpty(message = "Vui lòng nhập địa chỉ") String address, @Min(value = 18, message = "Bạn phải đủ 18t mới có thể đặt phòng") int age, @Email String email, @NotBlank(message = "bạn cần tên đăng nhập") String userName, @NotBlank(message = "Vui lòng nhập mật khẩu") String passWord, boolean status, Set<Role> roles) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.status = status;
        this.roles = roles;
    }

    public User(@NotBlank(message = "Bạn cần điền họ tên của mình") @Size(min = 1, max = 50, message = "Họ tên cần từ 1-50 từ ") String fullName, @NotEmpty(message = "Vui lòng nhập SDT") String phone, @NotEmpty(message = "Vui lòng nhập tuổi") @Min(value = 18, message = "Bạn phải đủ 18t mới có thể đặ phòng") int age, @Email String email, @NotBlank(message = "bạn cần tên đăng nhập") String userName, @NotBlank(message = "Vui lòng nhập mật khẩu") String passWord, boolean status) {
        this.fullName = fullName;
        this.phone = phone;
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.status = status;
    }


    public User(@NotBlank(message = "Bạn cần điền họ tên của mình") @Size(min = 1, max = 50, message = "Họ tên cần từ 1-50 từ ") String fullName, @NotEmpty(message = "Vui lòng nhập SDT") String phone, @NotEmpty(message = "Vui lòng nhập địa chỉ") String address, @Min(value = 18, message = "Bạn phải đủ 18t mới có thể đặt phòng") int age, @Email String email, @NotBlank(message = "bạn cần tên đăng nhập") String userName, @NotBlank(message = "Vui lòng nhập mật khẩu") String passWord, Set<Role> roles) {
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
    }
}
