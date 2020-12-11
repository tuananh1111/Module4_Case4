package com.casestudy.case4.service.role;

import com.casestudy.case4.model.Role;
import com.casestudy.case4.service.GeneralService;

import java.util.Optional;

public interface IRoleService extends GeneralService<Role> {
    Role findRoleByName(String name);

}
