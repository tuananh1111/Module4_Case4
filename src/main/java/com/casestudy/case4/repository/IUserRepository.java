package com.casestudy.case4.repository;



import com.casestudy.case4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
