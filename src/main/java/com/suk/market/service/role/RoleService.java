package com.suk.market.service.role;

import com.suk.market.domain.Role;

public interface RoleService {
    Iterable<Role> getAllRoles();

    Role getRoleByName(String name);
}
