package com.casestudy.case4.service.user;

import com.casestudy.case4.model.User;
import com.casestudy.case4.service.GeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends GeneralService<User>, UserDetailsService {
    User findByUserName(String userName);
}
