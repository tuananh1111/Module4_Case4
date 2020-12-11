package com.casestudy.case4.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrinciple implements UserDetails {
    private Long id;
    private String fullName;
    private String phone;
    private String address;
    private int age;
    private String email;
    private String userName;
    private String passWord;
    private Collection<? extends GrantedAuthority> roles;
    private boolean status;

    public UserPrinciple(Long id, String fullName, String phone, String address, int age, String email, String userName, String passWord, Collection<? extends GrantedAuthority> roles, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
        this.status = status;
    }

    public static UserPrinciple build(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new UserPrinciple(user.getId(), user.getFullName(), user.getPhone(),user.getAddress(), user.getAge(), user.getEmail(), user.getUserName(), user.getPassWord(), authorities, user.isStatus());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
