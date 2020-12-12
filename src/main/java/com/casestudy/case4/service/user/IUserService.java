package com.casestudy.case4.service.user;

import com.casestudy.case4.model.User;
import com.casestudy.case4.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends GeneralService<User>, UserDetailsService {
    User findByUserName(String userName);
    Page<User> findAllByStatusIsFalse(Pageable pageable);
    Page<User> findAllByStatusIsTrue(Pageable pageable);
    Page<User> findAllUserPage(Pageable pageable);
}
